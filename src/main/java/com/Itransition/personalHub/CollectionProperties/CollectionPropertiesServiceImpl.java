package com.Itransition.personalHub.CollectionProperties;

import com.Itransition.personalHub.Exceptions.CollectionPropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CollectionPropertiesServiceImpl implements CollectionPropertiesService {
    @Autowired
    private CollectionPropertiesRepository mCollectionPropertiesRepository;

    @Override
    public void update(CollectionPropertiesEntity collectionProperties, Long collectionId) {
        CollectionPropertiesEntity collectionPropertiesEntity = mCollectionPropertiesRepository.findByCollectionId(collectionId)
                .orElse(collectionPropertiesEntity = new CollectionPropertiesEntity(collectionId));
        if (collectionPropertiesEntity.getInteger1Name() != null) collectionPropertiesEntity.setInteger1Name(collectionProperties.getInteger1Name());
        if (collectionPropertiesEntity.getInteger2Name() != null) collectionPropertiesEntity.setInteger2Name(collectionProperties.getInteger2Name());
        if (collectionPropertiesEntity.getInteger3Name() != null) collectionPropertiesEntity.setInteger3Name(collectionProperties.getInteger3Name());
        if (collectionPropertiesEntity.getString1Name() != null) collectionPropertiesEntity.setString1Name(collectionProperties.getString1Name());
        if (collectionPropertiesEntity.getString2Name() != null) collectionPropertiesEntity.setString2Name(collectionProperties.getString2Name());
        if (collectionPropertiesEntity.getString3Name() != null) collectionPropertiesEntity.setString3Name(collectionProperties.getString3Name());
        if (collectionPropertiesEntity.getMultiline1Name() != null) collectionPropertiesEntity.setMultiline1Name(collectionProperties.getMultiline1Name());
        if (collectionPropertiesEntity.getMultiline2Name() != null) collectionPropertiesEntity.setMultiline2Name(collectionProperties.getMultiline2Name());
        if (collectionPropertiesEntity.getMultiline3Name() != null) collectionPropertiesEntity.setMultiline3Name(collectionProperties.getMultiline3Name());
        if (collectionPropertiesEntity.getBoolean1Name() != null) collectionPropertiesEntity.setBoolean1Name(collectionProperties.getBoolean1Name());
        if (collectionPropertiesEntity.getBoolean2Name() != null) collectionPropertiesEntity.setBoolean2Name(collectionProperties.getBoolean2Name());
        if (collectionPropertiesEntity.getBoolean3Name() != null) collectionPropertiesEntity.setBoolean3Name(collectionProperties.getBoolean3Name());
        if (collectionPropertiesEntity.getDate1Name() != null) collectionPropertiesEntity.setDate1Name(collectionProperties.getDate1Name());
        if (collectionPropertiesEntity.getDate2Name() != null) collectionPropertiesEntity.setDate2Name(collectionProperties.getDate2Name());
        if (collectionPropertiesEntity.getDate3Name() != null) collectionPropertiesEntity.setDate3Name(collectionProperties.getDate3Name());
    }

    @Override
    public CollectionPropertiesEntity getCollectionPropertiesByCollectionId(Long collectionId) {
        return mCollectionPropertiesRepository.findByCollectionId(collectionId)
                .orElseThrow(() -> new CollectionPropertyNotFoundException(collectionId));
    }


}