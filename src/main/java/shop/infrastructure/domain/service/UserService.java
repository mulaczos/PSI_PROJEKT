package shop.infrastructure.domain.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.exception.UsernameAlreadyUsedException;
import shop.infrastructure.domain.exception.WrongConfirmPasswordException;
import shop.infrastructure.domain.model.customer.BackendUser;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.CustomerDto;
import shop.infrastructure.domain.model.customer.Role;
import shop.infrastructure.domain.repository.BackendUserRepository;
import shop.infrastructure.domain.repository.CustomerRepository;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BackendUserService backendUserService;

    @Transactional
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer save(Customer customer) {
        if (findByUsername(customer.getUsername()) != null) {
            throw new UsernameAlreadyUsedException(customer.getUsername());
        } else {
            customer.setEnabled(true);
            Customer customerToReturn = customerRepository.save(customer);
            backendUserService.save(BackendUser.getUserAuthority(customerRepository.save(customerToReturn)));
            return customerToReturn;
        }
    }

    @Transactional
    public boolean assignModerator(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (backendUserService.hasUserRole(toDelete) || backendUserService.hasAdminRole(toDelete)) {
            backendUserService.findAndDelete(toDelete);
            backendUserService.save(BackendUser.getModeratorAuthority(toSave));
            return true;
        }
        return false;
    }

    @Transactional
    public boolean degradeToUser(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (backendUserService.hasModeratorRole(toDelete) || backendUserService.hasAdminRole(toDelete)) {
            backendUserService.findAndDelete(toDelete);
            backendUserService.save(BackendUser.getUserAuthority(toSave));
            return true;
        }
        return false;
    }

    @Transactional
    public boolean grantAdmin(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (backendUserService.hasUserRole(toDelete) || backendUserService.hasModeratorRole(toDelete)) {
            backendUserService.findAndDelete(toDelete);
            backendUserService.save(BackendUser.getAdminAuthority(toSave));
            return true;
        }
        return false;
    }

    @Transactional
    public Customer updateUser(CustomerDto customerDto) {
        Customer toDelete = findByUsername(customerDto.getUsername());
        Customer customerToReturn = null;
        if (toDelete != null) {
            if (toDelete.getPassword().equals(customerDto.getConfirmwithpassword())) {
                Customer customerToSave = new Customer(customerDto.getUsername(), customerDto.getNewpassword(), customerDto.getEmail(), customerDto.getName(), customerDto.getLastname(), true, customerDto.getAddress(), customerDto.getCity(), customerDto.getZipcode());
                BackendUser backendUser = backendUserService.save(BackendUser.getUserAuthorityByRole(customerToSave, backendUserService.findAndDelete(toDelete)));
                customerToReturn = customerRepository.save(backendUser.getCustomer());
            } else {
                throw new WrongConfirmPasswordException();
            }
        } else {
            throw new EntityNotFoundException();
        }
        return customerToReturn;
    }

    @Transactional
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(String username) {
        backendUserService.delete(findByUsername(username));
    }

    @Transactional(readOnly = true)
    public List<BackendUser> getAllBackendUsers() {
        return backendUserService.findAll();
    }

    @Transactional(readOnly = true)
    public Role getRole(String username) {
        return backendUserService.getRoleFor(findByUsername(username));
    }

    @Transactional
    public boolean toggleDisable(String username) {
        Customer toDelete = findByUsername(username);
        if (toDelete != null) {
            Customer toSave = Customer.getCopy(toDelete);
            if (toDelete.isEnabled()) {
                toSave.setEnabled(false);
            } else {
                toSave.setEnabled(true);
            }
            BackendUser backendUser = backendUserService.save(BackendUser.getUserAuthorityByRole(toSave, backendUserService.findAndDelete(toDelete)));
            customerRepository.save(backendUser.getCustomer());
            return true;
        }
        return false;
    }
}

@Service
class BackendUserService {

    @Autowired
    private BackendUserRepository backendUserRepository;

    @Transactional
    BackendUser save(BackendUser backendUser) {
        return backendUserRepository.save(backendUser);
    }

    @Transactional
    boolean hasUserRole(Customer customer) {
        return findByCustomer(customer).isUser();
    }

    @Transactional(readOnly = true)
    boolean hasModeratorRole(Customer customer) {
        return findByCustomer(customer).isMod();
    }

    @Transactional
    Role findAndDelete(Customer customer) {
        BackendUser toDelete = findByCustomer(customer);
        Role role = toDelete.getRole();
        backendUserRepository.delete(findByCustomer(customer));
        return role;
    }

    @Transactional(readOnly = true)
    boolean hasAdminRole(Customer customer) {
        return findByCustomer(customer).isAdmin();
    }

    @Transactional
    public List<BackendUser> findAll() {
        return backendUserRepository.findAll();
    }

    @Transactional
    private BackendUser findByCustomer(Customer customer) {
        return backendUserRepository.findByBackendUser_Username(customer);
    }

    @Transactional(readOnly = true)
    public Role getRoleFor(Customer customer) {
        return findByCustomer(customer).getRole();
    }

    @Transactional
    public void delete(Customer customer) {
        backendUserRepository.deleteByBackendUserUsername(customer);
    }
}
