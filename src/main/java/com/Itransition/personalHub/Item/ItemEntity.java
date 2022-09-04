package com.Itransition.personalHub.Item;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "collection_id")
    private Long mCollectionId;

    @Column(name = "name")
    private String mName;

    @Column(name = "creation_time")
    private LocalDateTime mCreationTime;

    @Column(name = "image")
    private String mImage;

    public ItemEntity() {
    }

    public ItemEntity(Long collectionId, String name) {
        mCollectionId = collectionId;
        mName = name;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getCollectionId() {
        return mCollectionId;
    }

    public void setCollectionId(Long collectionId) {
        mCollectionId = collectionId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public LocalDateTime getCreationTime() {
        return mCreationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        mCreationTime = creationTime;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}
