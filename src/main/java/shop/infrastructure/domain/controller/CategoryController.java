package shop.infrastructure.domain.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Category;
import shop.infrastructure.domain.service.CategoryService;

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
        return categoryService.update(category);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
