package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.repository.CategoryRepository;

import java.util.List;

/**
 * Created by Witu on 26.04.2017.
 */
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
        return categoryRepository.save(category);
    }
}
