package com.Itransition.personalHub.Item;

import com.Itransition.personalHub.Collection.CollectionRepository;
import com.Itransition.personalHub.Exceptions.CollectionNotFoundException;
import com.Itransition.personalHub.Exceptions.CommentNotFoundException;
import com.Itransition.personalHub.Exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository mItemRepository;

    @Autowired
    private CollectionRepository mCollectionRepository;

    @Override
    public void createItem(ItemEntity itemEntity) {
        mItemRepository.save(itemEntity);
    }

    @Override
    public void updateItem(ItemEntity itemEntity, Long itemId) {
        ItemEntity item = mItemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
        if (itemEntity.getName() != null) item.setName(itemEntity.getName());
        if (itemEntity.getImage() != null) item.setImage(itemEntity.getImage());
    }

    @Override
    public void deleteItem(Long itemId) {
        if (mItemRepository.existsById(itemId)) {
            mItemRepository.deleteById(itemId);
            mItemRepository.deleteItemPropertiesByItemId(itemId);
            mItemRepository.deleteTagsByItemId(itemId);
            mItemRepository.deleteCommentsByItemId(itemId);
        }
        else throw new ItemNotFoundException(itemId);
    }

    @Override
    public void updateItemLikes(Long itemId, int amount) {
        if (mItemRepository.existsById(itemId)) {
            mItemRepository.updateLikes(itemId, amount);
        }
        else throw new ItemNotFoundException(itemId);
    }

    @Override
    public List<ItemEntity> getAllItemsByCollectionId(Long collectionId) {
        if (mCollectionRepository.existsById(collectionId)) {
            return mItemRepository.getAllItemsByCollectionId(collectionId);
        }
        else throw new CollectionNotFoundException(collectionId);
    }

    @Override
    public ItemEntity getItem(Long itemId) {
        return mItemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @Override
    public List<String> getCommentsByItemId(Long itemId) {
        return mItemRepository.getAllCommentsByItemId(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @Override
    public String getCommentById(Long commentId) {
        return mItemRepository.getCommentByCommentId(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    @Override
    public void addComment(String comment, Long itemId) {
        if (mItemRepository.existsById(itemId)) {
            mItemRepository.saveComment(itemId, comment);
        }
        else throw new ItemNotFoundException(itemId);
    }

    @Override
    public void deleteComment(Long commentId) {
        if (mItemRepository.getCommentByCommentId(commentId).isPresent()) {
            mItemRepository.deleteCommentById(commentId);
        }
        else throw new CommentNotFoundException(commentId);
    }
}
