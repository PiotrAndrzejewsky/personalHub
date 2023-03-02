package com.Itransition.personalHub.Collection;

import javax.persistence.*;

@Entity
@Table(name = "collection_topics")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "name")
    private String mTopic;

    public TopicEntity() {
    }

    public TopicEntity(String topic) {
        mTopic = topic;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTopic() {
        return mTopic;
    }

    public void setTopic(String topic) {
        mTopic = topic;
    }
}
