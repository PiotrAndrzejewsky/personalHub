package com.Itransition.personalHub.Collection;

import com.Itransition.personalHub.Exceptions.CollectionNotFoundException;
import com.Itransition.personalHub.Exceptions.TopicAlreadyExistsException;
import com.Itransition.personalHub.Exceptions.TopicNotFoundException;
import com.Itransition.personalHub.Item.CommentRepository;
import com.Itransition.personalHub.Item.ItemEntity;
import com.Itransition.personalHub.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CollectionServiceImpl implements CollectionService{

    @Autowired
    private CollectionRepository mCollectionRepository;

    @Autowired
    private ItemRepository mItemRepository;

    @Autowired
    private CommentRepository mCommentRepository;

    @Autowired
    private TopicRepository mTopicRepository;

    @Override
    public boolean createCollection(CollectionEntity collectionEntity) {
        mCollectionRepository.save(collectionEntity);
        return true;
    }

    @Override
    public void deleteCollection(Long id) {
        if (mCollectionRepository.existsById(id)) {
            List<Long> itemsId = mItemRepository.getItemsIdByCollectionId(id);
            assert false;
            for (Long itemId : itemsId) {
                mItemRepository.deleteAllItemsLikes(itemId);
                mCommentRepository.deleteAllCommentsByItemId(itemId);
                mItemRepository.deleteItemPropertiesByItemId(itemId);
                mItemRepository.deleteById(itemId);
            }
            mCollectionRepository.deleteAllCollectionLikes(id);
            mCollectionRepository.deletePropertiesById(id);
            mCollectionRepository.deleteById(id);
        }
        else throw new CollectionNotFoundException(id);
    }

    @Override
    public CollectionEntity getCollection(Long id) {
        return mCollectionRepository.findById(id).orElseThrow(() -> new CollectionNotFoundException(id));
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
    public boolean createNewTopic(TopicEntity topic) {
        if (mTopicRepository.findTopicByName(topic.getTopic()).isEmpty()) {
            mTopicRepository.save(topic);
            return true;
        }
        else throw new TopicAlreadyExistsException(topic.getTopic());
    }

    @Override
    public TopicEntity getTopicByTopicId(Long id) {
        return mTopicRepository.findById(id).orElseThrow(() -> new TopicNotFoundException(id));
    }

    @Override
    public List<TopicEntity> getAllTopics() {
        return mTopicRepository.getAllTopics();
    }

    @Override
    public void updateLikes(Long collectionId, Long userId) {
        int count = mCollectionRepository.getLikesByCollectionAndUserId(collectionId, userId);
        if (count == 0) {
            mCollectionRepository.addNewLike(collectionId, userId);
        }
        else {
            mCollectionRepository.deleteLike(collectionId, userId);
        }
    }

    @Override
    public int getLikes(Long id) {
        return mCollectionRepository.getLikes(id);
    }
}
