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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.service.ItemService;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("{id}")
    public Item get(@PathVariable Long id) {
        return itemService.get(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAll();
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
        return itemService.update(item);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        itemService.delete(id);
    }

    @GetMapping("category/{id}")
    public List<Item> findAllByCategory(@PathVariable Long id) {
        return itemService.findAllByCategory(id);
    }
}
