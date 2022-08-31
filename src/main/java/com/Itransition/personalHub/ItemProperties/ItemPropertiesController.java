package com.Itransition.personalHub.ItemProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemPropertiesController {

    @Autowired
    private ItemPropertiesServiceImpl mItemService;

    @PutMapping("/item/properties/update/{itemId}")
    public void updateItemProperties(@RequestBody ItemPropertiesEntity itemProperties, @PathVariable Long itemId) {
        mItemService.updateItemProperties(itemProperties, itemId);
    }

    @GetMapping("/item/properties/{itemId}")
    public ItemPropertiesEntity getItemPropertiesByItemId(@PathVariable Long itemId) {
        return mItemService.getItemPropertiesByItemId(itemId);
    }

    @DeleteMapping("/item/properties/delete/{itemId}")
    public void deleteItemPropertiesByItemId(@PathVariable Long itemId) {
        mItemService.deleteItemPropertiesByItemId(itemId);
    }
}
