package com.Itransition.personalHub.Item;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {

    @Modifying
    @Query(value = "UPDATE collections SET likes = likes + :amount WHERE id = :id", nativeQuery = true)
    void updateLikes(Long id, int amount);

    @Modifying
    @Query(value = "DELETE FROM item_properties WHERE item_id = :id", nativeQuery = true)
    void deleteItemPropertiesByItemId(Long id);

    @Modifying
    @Query(value = "DELETE FROM tags WHERE item_id = :id", nativeQuery = true)
    void deleteTagsByItemId(Long id);

    @Modifying
    @Query(value = "DELETE FROM comments WHERE item_id = :id", nativeQuery = true)
    void deleteCommentsByItemId(Long id);

    @Query(value = "SELECT * FROM items WHERE collection_id = :id", nativeQuery = true)
    List<ItemEntity> getAllItemsByCollectionId(Long id);

    @Query(value = "SELECT COUNT(id) FROM item_likes WHERE item_id = :id", nativeQuery = true)
    int getLikes(Long id);

    @Query(value = "SELECT COUNT(id) FROM item_likes WHERE item_id = :itemId AND user_id = :userId", nativeQuery = true)
    int getLikesByItemAndUserId(Long itemId, Long userId);

    @Modifying
    @Query(value = "INSERT INTO item_likes (item_id, user_id) VALUES (:itemId, :userId)", nativeQuery = true)
    void addNewLike(Long itemId, Long userId);

    @Modifying
    @Query(value = "DELETE FROM item_likes WHERE item_id = :itemId AND user_id = :userId", nativeQuery = true)
    void deleteLike(Long itemId, Long userId);

    @Query(value = "SELECT id FROM items WHERE collection_id =:collectionId", nativeQuery = true)
    List<Long> getItemsIdByCollectionId(Long collectionId);

    @Modifying
    @Query(value = "DELETE FROM item_likes WHERE item_id = :itemId", nativeQuery = true)
    void deleteAllItemsLikes(Long itemId);
}
