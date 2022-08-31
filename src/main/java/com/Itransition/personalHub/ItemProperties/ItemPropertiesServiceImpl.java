package com.Itransition.personalHub.ItemProperties;

import com.Itransition.personalHub.Exceptions.ItemNotFoundException;
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
        ItemPropertiesEntity itemProperties = mItemPropertiesRepository.findByItemId(itemId)
                .orElse(itemProperties = new ItemPropertiesEntity(itemId));
        if (itemProperties.getInteger1() != null) itemProperties.setInteger1(itemPropertiesEntity.getInteger1());
        if (itemProperties.getInteger2() != null) itemProperties.setInteger2(itemPropertiesEntity.getInteger2());
        if (itemProperties.getInteger3() != null) itemProperties.setInteger3(itemPropertiesEntity.getInteger3());
        if (itemProperties.getString1() != null) itemProperties.setString1(itemPropertiesEntity.getString1());
        if (itemProperties.getString2() != null) itemProperties.setString2(itemPropertiesEntity.getString2());
        if (itemProperties.getString3() != null) itemProperties.setString3(itemPropertiesEntity.getString3());
        if (itemProperties.getMultiline1() != null) itemProperties.setMultiline1(itemPropertiesEntity.getMultiline1());
        if (itemProperties.getMultiline2() != null) itemProperties.setMultiline2(itemPropertiesEntity.getMultiline2());
        if (itemProperties.getMultiline3() != null) itemProperties.setMultiline3(itemPropertiesEntity.getMultiline3());
        if (itemProperties.isBoolean1() != null) itemProperties.setBoolean1(itemPropertiesEntity.isBoolean1());
        if (itemProperties.isBoolean2() != null) itemProperties.setBoolean2(itemPropertiesEntity.isBoolean2());
        if (itemProperties.isBoolean3() != null) itemProperties.setBoolean3(itemPropertiesEntity.isBoolean3());
        if (itemProperties.getDate1() != null) itemProperties.setDate1(itemPropertiesEntity.getDate1());
        if (itemProperties.getDate2() != null) itemProperties.setDate2(itemPropertiesEntity.getDate2());
        if (itemProperties.getDate3() != null) itemProperties.setDate3(itemPropertiesEntity.getDate3());
    }

    @Override
    public ItemPropertiesEntity getItemPropertiesByItemId(Long itemId) {
        return mItemPropertiesRepository.findByItemId(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @Override
    public void deleteItemPropertiesByItemId(Long itemId) {
        mItemPropertiesRepository.deleteByItemId(itemId);
    }
}
