package com.Itransition.personalHub.CollectionProperties;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionPropertiesRepository extends CrudRepository<CollectionPropertiesEntity, Long> {

    @Query(value = "SELECT * FROM collection_properties WHERE collection_id = :id", nativeQuery = true)
    Optional<CollectionPropertiesEntity> findByCollectionId(Long id);
}
