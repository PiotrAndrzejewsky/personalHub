package com.Itransition.personalHub.Collection;

import javax.persistence.*;

@Entity
@Table(name = "collections")
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "user_id")
    private Long mUserId;

    @Column(name = "name")
    private String mName;
    @Column(name = "description")
    private String mDescription;

    @Column(name = "collection_topic_id")
    private Long mTopic;

    @Column(name = "image")
    private String mImage;

    public CollectionEntity() {
    }

    public CollectionEntity(Long userId, String name, String description, Long topic) {
        mUserId = userId;
        mName = name;
        mDescription = description;
        mTopic = topic;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getTopic() {
        return mTopic;
    }

    public void setTopic(Long topic) {
        mTopic = topic;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }
}

