package com.Itransition.personalHub.Item;

import com.Itransition.personalHub.Collection.CollectionRepository;
import com.Itransition.personalHub.Exceptions.CollectionNotFoundException;
import com.Itransition.personalHub.Exceptions.CommentNotFoundException;
import com.Itransition.personalHub.Exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository mItemRepository;

    @Autowired
    private CollectionRepository mCollectionRepository;

    @Autowired
    private CommentRepository mCommentRepository;

    @Override
    public void createItem(ItemEntity itemEntity) {
        itemEntity.setCreationTime(LocalDateTime.now());
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
    public List<CommentEntity> getCommentsByItemId(Long itemId) {
        return mCommentRepository.getAllCommentsByItemId(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @Override
    public CommentEntity getCommentById(Long commentId) {
        return mCommentRepository.getCommentByCommentId(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    @Override
    public void addComment(String comment, Long itemId) {
        if (mItemRepository.existsById(itemId)) {
            mCommentRepository.saveComment(itemId, comment);
        }
        else throw new ItemNotFoundException(itemId);
    }

    @Override
    public void deleteComment(Long commentId) {
        if (mCommentRepository.getCommentByCommentId(commentId).isPresent()) {
            mCommentRepository.deleteCommentById(commentId);
        }
        else throw new CommentNotFoundException(commentId);
    }

    @Override
    public void updateLikes(Long itemId, Long userId) {
        int count = mItemRepository.getLikesByItemAndUserId(itemId, userId);
        if (count == 0) {
            mItemRepository.addNewLike(itemId, userId);
        }
        else {
            mItemRepository.deleteLike(itemId, userId);
        }
    }

    @Override
    public int getLikes(Long itemId) {
        return mItemRepository.getLikes(itemId);
    }
}
