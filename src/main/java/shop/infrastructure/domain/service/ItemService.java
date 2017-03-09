package shop.infrastructure.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.repository.ItemRepository;

/**
 * Created by Witu on 09.03.2017.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
