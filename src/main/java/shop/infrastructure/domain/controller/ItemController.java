package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.service.ItemService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("items")
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
        if (itemService.get(item.getId()) != null) {
            return itemService.update(item);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping
    public void delete(Long id) {
        itemService.delete(id);
    }

    @GetMapping("category/{id}")
    public List<Item> findAllByCategory(@PathVariable Long id) {
        return itemService.findAllByCategory(id);
    }
}
