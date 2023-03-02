package com.Itransition.personalHub.Item;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    @Query(value = "SELECT * FROM comments WHERE item_id = :id", nativeQuery = true)
    Optional<List<CommentEntity>> getAllCommentsByItemId(Long id);

    @Query(value = "SELECT * FROM comments WHERE id = :id", nativeQuery = true)
    Optional<CommentEntity> getCommentByCommentId(Long id);

    @Modifying
    @Query(value = "INSERT INTO comments (item_id, comment) VALUES (:item_id, :comment)", nativeQuery = true)
    void saveComment(Long item_id, String comment);

    @Modifying
    @Query(value = "DELETE FROM comments WHERE id = :id", nativeQuery = true)
    void deleteCommentById(Long id);

    @Modifying
    @Query(value = "DELETE FROM comments WHERE item_id = :itemId", nativeQuery = true)
    void deleteAllCommentsByItemId(Long itemId);
}
