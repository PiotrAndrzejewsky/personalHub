package com.Itransition.personalHub.ItemProperties;

public interface ItemPropertiesService {
    void updateItemProperties(ItemPropertiesEntity itemPropertiesEntity, Long itemId);
    ItemPropertiesEntity getItemPropertiesByItemId(Long itemId);
    void deleteItemPropertiesByItemId(Long itemId);
    void createItemProperties(ItemPropertiesEntity itemPropertiesEntity, Long itemId);
}
