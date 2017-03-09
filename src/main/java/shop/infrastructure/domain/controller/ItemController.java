package shop.infrastructure.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.infrastructure.domain.model.Item;
import shop.infrastructure.domain.service.ItemService;

/**
 * Created by Witu on 09.03.2017.
 */
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    public Item save(Item item) {
        return itemService.save(item);
    }
}
