package shop.infrastructure.domain.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category get(Long id) {
        return categoryRepository.findOne(id);
    }

    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    public Category update(Category category) {
        if (get(category.getId()) != null) {
            return save(category);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
