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
    private CollectionPropertiesEntity mCollectionProperties;

    @Override
    public void update(CollectionPropertiesEntity collectionProperties, Long collectionId) {
        mCollectionProperties = mCollectionPropertiesRepository.findByCollectionId(collectionId)
                .orElse(mCollectionProperties = new CollectionPropertiesEntity(collectionId));
        if (mCollectionProperties.getInteger1Name() != null) mCollectionProperties.setInteger1Name(collectionProperties.getInteger1Name());
        if (mCollectionProperties.getInteger2Name() != null) mCollectionProperties.setInteger2Name(collectionProperties.getInteger2Name());
        if (mCollectionProperties.getInteger3Name() != null) mCollectionProperties.setInteger3Name(collectionProperties.getInteger3Name());
        if (mCollectionProperties.getString1Name() != null) mCollectionProperties.setString1Name(collectionProperties.getString1Name());
        if (mCollectionProperties.getString2Name() != null) mCollectionProperties.setString2Name(collectionProperties.getString2Name());
        if (mCollectionProperties.getString3Name() != null) mCollectionProperties.setString3Name(collectionProperties.getString3Name());
        if (mCollectionProperties.getMultiline1Name() != null) mCollectionProperties.setMultiline1Name(collectionProperties.getMultiline1Name());
        if (mCollectionProperties.getMultiline2Name() != null) mCollectionProperties.setMultiline2Name(collectionProperties.getMultiline2Name());
        if (mCollectionProperties.getMultiline3Name() != null) mCollectionProperties.setMultiline3Name(collectionProperties.getMultiline3Name());
        if (mCollectionProperties.getBoolean1Name() != null) mCollectionProperties.setBoolean1Name(collectionProperties.getBoolean1Name());
        if (mCollectionProperties.getBoolean2Name() != null) mCollectionProperties.setBoolean2Name(collectionProperties.getBoolean2Name());
        if (mCollectionProperties.getBoolean3Name() != null) mCollectionProperties.setBoolean3Name(collectionProperties.getBoolean3Name());
        if (mCollectionProperties.getDate1Name() != null) mCollectionProperties.setDate1Name(collectionProperties.getDate1Name());
        if (mCollectionProperties.getDate2Name() != null) mCollectionProperties.setDate2Name(collectionProperties.getDate2Name());
        if (mCollectionProperties.getDate3Name() != null) mCollectionProperties.setDate3Name(collectionProperties.getDate3Name());
    }

    @Override
    public CollectionPropertiesEntity getCollectionProperties(Long collectionId) {
        return mCollectionPropertiesRepository.findByCollectionId(collectionId)
                .orElseThrow(() -> new CollectionPropertyNotFoundException(collectionId));
    }


}