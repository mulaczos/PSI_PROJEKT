package shop.infrastructure.domain.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.repository.CategoryRepository;
import shop.infrastructure.domain.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item get(Long id) {
        return itemRepository.findOne(id);
    }

    @Transactional
    public void delete(Long id) {
        itemRepository.delete(id);
    }

    @Transactional
    public Item update(Item item) {
        if (get(item.getId()) != null) {
            return save(item);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public List<Item> findAllByCategory(Long id) {
        Category category = categoryRepository.findOne(id);
        return itemRepository.findAllByCategory(category);
    }
}
