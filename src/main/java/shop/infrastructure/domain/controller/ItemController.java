package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.service.ItemService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(params = "id")
	public Item get(Long id) {
		return itemService.get(id);
	}
	
	@GetMapping
	public List<Item> getAllItems() {
		return itemService.getAll();
	}
	
	@PostMapping
	public Item save(Item customer) {
		return itemService.save(customer);
	}
	
	@PutMapping
	public Item update(Item item) {
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
}
