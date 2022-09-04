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
        CollectionPropertiesEntity collectionPropertiesEntity = new CollectionPropertiesEntity();
        if (mCollectionPropertiesRepository.findByCollectionId(collectionId).isPresent()) {
            collectionPropertiesEntity = mCollectionPropertiesRepository.findByCollectionId(collectionId).get();
        }
        else {
            createCollectionProperties(collectionPropertiesEntity, collectionId);
            return;
        }
        if (collectionProperties.getInteger1Name() != null) collectionPropertiesEntity.setInteger1Name(collectionProperties.getInteger1Name());
        if (collectionProperties.getInteger2Name() != null) collectionPropertiesEntity.setInteger2Name(collectionProperties.getInteger2Name());
        if (collectionProperties.getInteger3Name() != null) collectionPropertiesEntity.setInteger3Name(collectionProperties.getInteger3Name());
        if (collectionProperties.getString1Name() != null) collectionPropertiesEntity.setString1Name(collectionProperties.getString1Name());
        if (collectionProperties.getString2Name() != null) collectionPropertiesEntity.setString2Name(collectionProperties.getString2Name());
        if (collectionProperties.getString3Name() != null) collectionPropertiesEntity.setString3Name(collectionProperties.getString3Name());
        if (collectionProperties.getMultiline1Name() != null) collectionPropertiesEntity.setMultiline1Name(collectionProperties.getMultiline1Name());
        if (collectionProperties.getMultiline2Name() != null) collectionPropertiesEntity.setMultiline2Name(collectionProperties.getMultiline2Name());
        if (collectionProperties.getMultiline3Name() != null) collectionPropertiesEntity.setMultiline3Name(collectionProperties.getMultiline3Name());
        if (collectionProperties.getBoolean1Name() != null) collectionPropertiesEntity.setBoolean1Name(collectionProperties.getBoolean1Name());
        if (collectionProperties.getBoolean2Name() != null) collectionPropertiesEntity.setBoolean2Name(collectionProperties.getBoolean2Name());
        if (collectionProperties.getBoolean3Name() != null) collectionPropertiesEntity.setBoolean3Name(collectionProperties.getBoolean3Name());
        if (collectionProperties.getDate1Name() != null) collectionPropertiesEntity.setDate1Name(collectionProperties.getDate1Name());
        if (collectionProperties.getDate2Name() != null) collectionPropertiesEntity.setDate2Name(collectionProperties.getDate2Name());
        if (collectionProperties.getDate3Name() != null) collectionPropertiesEntity.setDate3Name(collectionProperties.getDate3Name());
    }

    @Override
    public CollectionPropertiesEntity getCollectionPropertiesByCollectionId(Long collectionId) {
        return mCollectionPropertiesRepository.findByCollectionId(collectionId)
                .orElseThrow(() -> new CollectionPropertyNotFoundException(collectionId));
    }

    @Override
    public void createCollectionProperties(CollectionPropertiesEntity collectionPropertiesEntity, Long collectionId) {
        collectionPropertiesEntity.setCollectionId(collectionId);
        mCollectionPropertiesRepository.save(collectionPropertiesEntity);
    }


}