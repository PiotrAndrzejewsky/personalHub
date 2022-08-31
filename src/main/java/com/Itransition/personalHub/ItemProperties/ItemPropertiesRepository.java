package com.Itransition.personalHub.ItemProperties;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemPropertiesRepository extends CrudRepository<ItemPropertiesEntity, Long> {
    @Query(value = "SELECT * FROM item_properties WHERE item_id = :id", nativeQuery = true)
    Optional<ItemPropertiesEntity> findByItemId(Long id);

    @Modifying
    @Query(value = "DELETE FROM item_properties WHERE item_id = :id", nativeQuery = true)
    void deleteByItemId(Long id);
}
