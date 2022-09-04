package com.Itransition.personalHub.ItemProperties;

import com.Itransition.personalHub.Exceptions.ItemNotFoundException;
import com.Itransition.personalHub.Exceptions.ItemPropertiesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ItemPropertiesServiceImpl implements ItemPropertiesService{
    @Autowired
    private ItemPropertiesRepository mItemPropertiesRepository;

    @Override
    public void updateItemProperties(ItemPropertiesEntity itemPropertiesEntity, Long itemId) {
        ItemPropertiesEntity itemProperties = new ItemPropertiesEntity();
        if (mItemPropertiesRepository.findByItemId(itemId).isPresent()) {
            itemProperties = mItemPropertiesRepository.findByItemId(itemId).get();
        }
        else {
            createItemProperties(itemPropertiesEntity, itemId);
            return;
        }
        if (itemPropertiesEntity.getInteger1() != null) itemProperties.setInteger1(itemPropertiesEntity.getInteger1());
        if (itemPropertiesEntity.getInteger2() != null) itemProperties.setInteger2(itemPropertiesEntity.getInteger2());
        if (itemPropertiesEntity.getInteger3() != null) itemProperties.setInteger3(itemPropertiesEntity.getInteger3());
        if (itemPropertiesEntity.getString1() != null) itemProperties.setString1(itemPropertiesEntity.getString1());
        if (itemPropertiesEntity.getString2() != null) itemProperties.setString2(itemPropertiesEntity.getString2());
        if (itemPropertiesEntity.getString3() != null) itemProperties.setString3(itemPropertiesEntity.getString3());
        if (itemPropertiesEntity.getMultiline1() != null) itemProperties.setMultiline1(itemPropertiesEntity.getMultiline1());
        if (itemPropertiesEntity.getMultiline2() != null) itemProperties.setMultiline2(itemPropertiesEntity.getMultiline2());
        if (itemPropertiesEntity.getMultiline3() != null) itemProperties.setMultiline3(itemPropertiesEntity.getMultiline3());
        if (itemPropertiesEntity.isBoolean1() != null) itemProperties.setBoolean1(itemPropertiesEntity.isBoolean1());
        if (itemPropertiesEntity.isBoolean2() != null) itemProperties.setBoolean2(itemPropertiesEntity.isBoolean2());
        if (itemPropertiesEntity.isBoolean3() != null) itemProperties.setBoolean3(itemPropertiesEntity.isBoolean3());
        if (itemPropertiesEntity.getDate1() != null) itemProperties.setDate1(itemPropertiesEntity.getDate1());
        if (itemPropertiesEntity.getDate2() != null) itemProperties.setDate2(itemPropertiesEntity.getDate2());
        if (itemPropertiesEntity.getDate3() != null) itemProperties.setDate3(itemPropertiesEntity.getDate3());
    }

    @Override
    public ItemPropertiesEntity getItemPropertiesByItemId(Long itemId) {
        return mItemPropertiesRepository.findByItemId(itemId)
                .orElseThrow(() -> new ItemPropertiesNotFoundException(itemId));
    }

    @Override
    public void deleteItemPropertiesByItemId(Long itemId) {
        mItemPropertiesRepository.deleteByItemId(itemId);
    }

    @Override
    public void createItemProperties(ItemPropertiesEntity itemPropertiesEntity, Long itemId) {
        itemPropertiesEntity.setItemId(itemId);
        mItemPropertiesRepository.save(itemPropertiesEntity);
    }
}
