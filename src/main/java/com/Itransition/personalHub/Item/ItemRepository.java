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
    @Query(value = "DELETE FROM item_properties WHERE item_id = : id", nativeQuery = true)
    void deleteItemPropertiesByItemId(Long id);

    @Modifying
    @Query(value = "DELETE FROM tags WHERE item_id = : id", nativeQuery = true)
    void deleteTagsByItemId(Long id);

    @Modifying
    @Query(value = "DELETE FROM comments WHERE item_id = : id", nativeQuery = true)
    void deleteCommentsByItemId(Long id);

    @Query(value = "SELECT * FROM items WHERE collection_id = :id", nativeQuery = true)
    List<ItemEntity> getAllItemsByCollectionId(Long id);

    @Query(value = "SELECT comment FROM comments WHERE item_id = :id", nativeQuery = true)
    Optional<List<String>> getAllCommentsByItemId(Long id);

    @Query(value = "SELECT comment FROM comments WHERE id = :id", nativeQuery = true)
    Optional<String> getCommentByCommentId(Long id);

    @Modifying
    @Query(value = "INSERT INTO comments (item_id, comment) VALUES (:item_id, :comment)", nativeQuery = true)
    void saveComment(Long item_id, String comment);

    @Modifying
    @Query(value = "DELETE FROM comments WHERE id = : id", nativeQuery = true)
    void deleteCommentById(Long id);
}
