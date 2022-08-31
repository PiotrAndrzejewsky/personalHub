package com.Itransition.personalHub.Collection;

import com.Itransition.personalHub.Exceptions.CollectionNotFoundException;
import com.Itransition.personalHub.Exceptions.TopicAlreadyExistsException;
import com.Itransition.personalHub.Exceptions.TopicNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CollectionServiceImpl implements CollectionService{

    @Autowired
    private CollectionRepository mCollectionRepository;

    @Override
    public boolean createCollection(CollectionEntity collectionEntity) {
        mCollectionRepository.save(collectionEntity);
        return true;
    }

    @Override
    public void deleteCollection(Long id) {
        if (doesCollectionExist(id)) {
            mCollectionRepository.deleteById(id);
            mCollectionRepository.deletePropertiesById(id);
        }
        else throw new CollectionNotFoundException(id);
    }

    @Override
    public CollectionEntity getCollection(Long id) {
        if (doesCollectionExist(id)) return mCollectionRepository.findById(id).get();
        else throw new CollectionNotFoundException(id);
    }

    @Override
    public List<CollectionEntity> getAllCollectionsById(Long userId) {
        return mCollectionRepository.getAllCollectionsById(userId);
    }

    @Override
    public void updateCollection(CollectionEntity collectionEntity, Long id) {
        CollectionEntity collection = mCollectionRepository.findById(id).orElseThrow(() -> new CollectionNotFoundException(id));
        if (collectionEntity.getName() != null) collection.setName(collectionEntity.getName());
        if (collectionEntity.getDescription() != null) collection.setDescription(collectionEntity.getDescription());
        if (collectionEntity.getTopic() != null) collection.setTopic(collectionEntity.getTopic());
        if (collectionEntity.getImage() != null) collection.setImage(collectionEntity.getImage());
    }

    @Override
    public boolean createNewTopic(String name) {
        if (!doesTopicExist(name)) {
            mCollectionRepository.saveNewTopic(name);
            return true;
        }
        else throw new TopicAlreadyExistsException(name);
    }

    @Override
    public String getTopicByTopicId(Long id) {
        if (doesTopicExist(id)) {
            return mCollectionRepository.findTopicById(id).get();
        }
        throw new TopicNotFoundException(id);
    }

    @Override
    public List<String> getAllTopics() {
        return mCollectionRepository.getAllTopic();
    }

    @Override
    public void updateLikes(Long id, int amount) {
        if (doesCollectionExist(id)) mCollectionRepository.updateLikes(id);
        else throw new CollectionNotFoundException(id);
    }

    @Override
    public int getLikes(Long id) {
        CollectionEntity collectionEntity = mCollectionRepository.findById(id).orElseThrow(() -> new CollectionNotFoundException(id));
        return collectionEntity.getLikes();
    }

    public boolean doesCollectionExist(Long id) {
        return mCollectionRepository.existsById(id);
    }

    public boolean doesTopicExist(String name) {
        return mCollectionRepository.findTopicByName(name).isPresent();
    }

    public boolean doesTopicExist(Long id) {
        return mCollectionRepository.findTopicById(id).isPresent();
    }
}
