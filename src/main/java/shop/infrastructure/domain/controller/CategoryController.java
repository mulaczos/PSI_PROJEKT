package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.service.CategoryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Witu on 26.04.2017.
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        if (categoryService.get(category.getId()) != null) {
            return categoryService.update(category);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
