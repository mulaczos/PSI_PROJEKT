package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> getAll() {
		return itemRepository.findAll();
	}
	
	public Item get(Long id) {
		return itemRepository.findOne(id);
	}
	
	public void delete(Long id) {
		itemRepository.delete(id);
	}
	
	public Item update(Item item) {
		return itemRepository.save(item);
	}
}
