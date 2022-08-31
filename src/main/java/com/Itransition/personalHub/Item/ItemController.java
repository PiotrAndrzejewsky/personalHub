package com.Itransition.personalHub.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceImpl mItemService;

    @PostMapping("/item/save")
    public void createItem(@RequestBody ItemEntity item) {
        mItemService.createItem(item);
    }

    @PutMapping("/item/update/{itemId}")
    public void updateItem(@RequestBody ItemEntity itemEntity, @PathVariable Long itemId) {
        mItemService.updateItem(itemEntity,itemId);
    }

    @DeleteMapping("/item/delete/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        mItemService.deleteItem(itemId);
    }

    @PostMapping("/item/likes/update/{itemId}")
    public void updateItemLikes(@RequestBody int amount, @PathVariable Long itemId) {
        mItemService.updateItemLikes(itemId, amount);
    }

    @GetMapping("item/all/{collectionId}")
    public List<ItemEntity> getAllItemsByCollectionId(@PathVariable Long collectionId) {
        return mItemService.getAllItemsByCollectionId(collectionId);
    }

    @GetMapping("/item/{itemId}")
    public ItemEntity getItem(@PathVariable Long itemId) {
        return mItemService.getItem(itemId);
    }

    @GetMapping("/item/comments/{itemId}")
    public List<String> getCommentsByItemId(@PathVariable Long itemId) {
        return mItemService.getCommentsByItemId(itemId);
    }

    @GetMapping("/comment/{commentId}")
    public String getComment(@PathVariable Long commentId) {
        return mItemService.getCommentById(commentId);
    }

    @PostMapping("/item/comment/save/{itemId}")
    public void addComment(@RequestBody String comment, @PathVariable Long itemId) {
        mItemService.addComment(comment, itemId);
    }

    @DeleteMapping("/comment/delete/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        mItemService.deleteComment(commentId);
    }
}
