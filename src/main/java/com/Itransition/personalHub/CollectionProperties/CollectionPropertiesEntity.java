package com.Itransition.personalHub.CollectionProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "collections_properties")
public class CollectionPropertiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "collection_id")
    private Long mCollectionId;

    @Column(name = "integer1_name")
    private String mInteger1Name;

    @Column(name = "integer2_name")
    private String mInteger2Name;

    @Column(name = "integer3_name")
    private String mInteger3Name;

    @Column(name = "string1_name")
    private String mString1Name;

    @Column(name = "string2_name")
    private String mString2Name;

    @Column(name = "string3_name")
    private String mString3Name;

    @Column(name = "multiline1_name")
    private String mMultiline1Name;

    @Column(name = "multiline2_name")
    private String mMultiline2Name;

    @Column(name = "multiline3_name")
    private String mMultiline3Name;

    @Column(name = "boolean1_name")
    private String mBoolean1Name;

    @Column(name = "boolean2_name")
    private String mBoolean2Name;

    @Column(name = "boolean3_name")
    private String mBoolean3Name;

    @Column(name = "date1_name")
    private String mDate1Name;

    @Column(name = "date2_name")
    private String mDate2Name;

    @Column(name = "date3_name")
    private String mDate3Name;

    public CollectionPropertiesEntity() {
    }

    public CollectionPropertiesEntity(Long collectionId) {
        mCollectionId = collectionId;
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

    public String getInteger1Name() {
        return mInteger1Name;
    }

    public void setInteger1Name(String integer1Name) {
        mInteger1Name = integer1Name;
    }

    public String getInteger2Name() {
        return mInteger2Name;
    }

    public void setInteger2Name(String integer2Name) {
        mInteger2Name = integer2Name;
    }

    public String getInteger3Name() {
        return mInteger3Name;
    }

    public void setInteger3Name(String integer3Name) {
        mInteger3Name = integer3Name;
    }

    public String getString1Name() {
        return mString1Name;
    }

    public void setString1Name(String string1Name) {
        mString1Name = string1Name;
    }

    public String getString2Name() {
        return mString2Name;
    }

    public void setString2Name(String string2Name) {
        mString2Name = string2Name;
    }

    public String getString3Name() {
        return mString3Name;
    }

    public void setString3Name(String string3Name) {
        mString3Name = string3Name;
    }

    public String getMultiline1Name() {
        return mMultiline1Name;
    }

    public void setMultiline1Name(String multiline1Name) {
        mMultiline1Name = multiline1Name;
    }

    public String getMultiline2Name() {
        return mMultiline2Name;
    }

    public void setMultiline2Name(String multiline2Name) {
        mMultiline2Name = multiline2Name;
    }

    public String getMultiline3Name() {
        return mMultiline3Name;
    }

    public void setMultiline3Name(String multiline3Name) {
        mMultiline3Name = multiline3Name;
    }

    public String getBoolean1Name() {
        return mBoolean1Name;
    }

    public void setBoolean1Name(String boolean1Name) {
        mBoolean1Name = boolean1Name;
    }

    public String getBoolean2Name() {
        return mBoolean2Name;
    }

    public void setBoolean2Name(String boolean2Name) {
        mBoolean2Name = boolean2Name;
    }

    public String getBoolean3Name() {
        return mBoolean3Name;
    }

    public void setBoolean3Name(String boolean3Name) {
        mBoolean3Name = boolean3Name;
    }

    public String getDate1Name() {
        return mDate1Name;
    }

    public void setDate1Name(String date1Name) {
        mDate1Name = date1Name;
    }

    public String getDate2Name() {
        return mDate2Name;
    }

    public void setDate2Name(String date2Name) {
        mDate2Name = date2Name;
    }

    public String getDate3Name() {
        return mDate3Name;
    }

    public void setDate3Name(String date3Name) {
        mDate3Name = date3Name;
    }
}

