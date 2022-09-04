package com.Itransition.personalHub.Item;

import java.util.List;

public interface ItemService {

    void createItem(ItemEntity itemEntity);
    void updateItem(ItemEntity itemEntity, Long itemId);
    void deleteItem(Long itemId);
    List<ItemEntity> getAllItemsByCollectionId(Long collectionId);
    ItemEntity getItem(Long itemId);
    List<CommentEntity> getCommentsByItemId(Long itemId);
    CommentEntity getCommentById(Long commentId);
    void addComment(String comment, Long itemId);
    void deleteComment(Long commentId);
    void updateLikes(Long itemId, Long userId);
    int getLikes(Long itemId);
}
