package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.exception.UsernameAlreadyUsedException;
import shop.infrastructure.domain.exception.WrongConfirmPasswordException;
import shop.infrastructure.domain.model.customer.Customer;
import shop.infrastructure.domain.model.customer.Role;
import shop.infrastructure.domain.model.customer.BackendUser;
import shop.infrastructure.domain.model.customer.CustomerDto;
import shop.infrastructure.domain.repository.BackendUserRepository;
import shop.infrastructure.domain.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserAuthorityService userAuthorityService;

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
            userAuthorityService.save(BackendUser.getUserAuthority(customerRepository.save(customerToReturn)));
            return customerToReturn;
        }
    }

    @Transactional
    public boolean grantToModerator(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (userAuthorityService.hasUserRole(toDelete)) {
            userAuthorityService.delete(BackendUser.getUserAuthority(toDelete));
            userAuthorityService.save(BackendUser.getModeratorAuthority(toSave));
            return true;
        }
        return false;
    }

    @Transactional
    public boolean degradeToUser(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (userAuthorityService.hasModeratorRole(toDelete)) {
            userAuthorityService.delete(BackendUser.getModeratorAuthority(toDelete));
            userAuthorityService.save(BackendUser.getUserAuthority(toSave));
            return true;
        }
        return false;
    }

    public boolean grantAdmin(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (userAuthorityService.hasModeratorRole(toDelete)) {
            userAuthorityService.delete(BackendUser.getModeratorAuthority(toDelete));
            userAuthorityService.save(BackendUser.getAdminAuthority(toSave));
            return true;
        }
        return false;
    }

    public boolean degradeToModerator(String username) {
        Customer toDelete = findByUsername(username);
        Customer toSave = Customer.getCopy(toDelete);
        if (userAuthorityService.hasAdminRole(toDelete)) {
            userAuthorityService.delete(BackendUser.getAdminAuthority(toDelete));
            userAuthorityService.save(BackendUser.getModeratorAuthority(toSave));
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
                Customer customerToSave = new Customer(customerDto.getUsername(), customerDto.getNewpassword(), customerDto.getEmail(), customerDto.getName(), customerDto.getLastname(), true);
                BackendUser backendUser = userAuthorityService.save(BackendUser.getUserAuthorityByRole(customerToSave, userAuthorityService.findAndDelete(toDelete)));
                customerToReturn = customerRepository.save(backendUser.getUser());
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
        customerRepository.delete(username);
    }

    public List<BackendUser> getAllBackendUsers() {
        return userAuthorityService.findAll();
    }
}

@Service
class UserAuthorityService {

    @Autowired
    private BackendUserRepository backendUserRepository;

    @Transactional
    BackendUser save(BackendUser backendUser) {
        return backendUserRepository.save(backendUser);
    }

    @Transactional
    boolean hasUserRole(Customer customer) {
        return backendUserRepository.findByBackendUser_Username(customer).isUserAuthority();
    }

    @Transactional(readOnly = true)
    boolean hasModeratorRole(Customer customer) {
        return backendUserRepository.findByBackendUser_Username(customer).isModeratorAuthority();
    }

    @Transactional
    Role findAndDelete(Customer customer) {
        BackendUser toDelete = backendUserRepository.findByBackendUser_Username(customer);
        Role role = toDelete.getRole();
        backendUserRepository.delete(backendUserRepository.findByBackendUser_Username(customer));
        return role;
    }

    @Transactional
    void delete(BackendUser backendUser) {
        backendUserRepository.delete(backendUser);
    }

    @Transactional(readOnly = true)
    boolean hasAdminRole(Customer customer) {
        return backendUserRepository.findByBackendUser_Username(customer).isAdminAuthority();
    }

    @Transactional
    BackendUser findByCustomer(Customer customer) {
        return backendUserRepository.findByBackendUser_Username(customer);
    }


    public List<BackendUser> findAll() {
        return backendUserRepository.findAll();
    }
}
