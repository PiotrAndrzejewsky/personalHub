package com.Itransition.personalHub.Item;

import javax.persistence.*;

@Table(name = "comments")
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "item_id")
    private Long mItemId;

    @Column(name = "comment")
    private String mComment;

    public CommentEntity() {
    }

    public CommentEntity(String comment) {
        mComment = comment;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getItemId() {
        return mItemId;
    }

    public void setItemId(Long itemId) {
        mItemId = itemId;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
