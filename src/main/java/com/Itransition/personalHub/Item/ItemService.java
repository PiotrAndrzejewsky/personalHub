package com.Itransition.personalHub.Item;

import java.util.List;

public interface ItemService {

    void createItem(ItemEntity itemEntity);
    void updateItem(ItemEntity itemEntity, Long itemId);
    void deleteItem(Long itemId);
    void updateItemLikes(Long itemId, int amount);
    List<ItemEntity> getAllItemsByCollectionId(Long collectionId);
    ItemEntity getItem(Long itemId);
    List<String> getCommentsByItemId(Long itemId);
    String getCommentById(Long commentId);
    void addComment(String comment, Long itemId);
    void deleteComment(Long commentId);



}
