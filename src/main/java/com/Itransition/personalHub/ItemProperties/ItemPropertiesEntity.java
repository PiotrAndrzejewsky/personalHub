package com.Itransition.personalHub.ItemProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_properties")
public class ItemPropertiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "item_id")
    private Long mItemId;

    @Column(name = "integer1")
    private Integer mInteger1;

    @Column(name = "integer2")
    private Integer mInteger2;

    @Column(name = "integer3")
    private Integer mInteger3;

    @Column(name = "string1")
    private String mString1;

    @Column(name = "string2")
    private String mString2;

    @Column(name = "string3")
    private String mString3;

    @Column(name = "multiline1")
    private String mMultiline1;

    @Column(name = "multiline2")
    private String mMultiline2;

    @Column(name = "multiline3")
    private String mMultiline3;

    @Column(name = "boolean1")
    private Boolean mBoolean1;

    @Column(name = "boolean2")
    private Boolean mBoolean2;

    @Column(name = "boolean3")
    private Boolean mBoolean3;

    @Column(name = "date1")
    private LocalDateTime mDate1;

    @Column(name = "date2")
    private LocalDateTime mDate2;

    @Column(name = "date3")
    private LocalDateTime mDate3;

    public ItemPropertiesEntity() {
    }

    public ItemPropertiesEntity(Long itemId) {
        mItemId = itemId;
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

    public Integer getInteger1() {
        return mInteger1;
    }

    public void setInteger1(Integer integer1) {
        mInteger1 = integer1;
    }

    public Integer getInteger2() {
        return mInteger2;
    }

    public void setInteger2(Integer integer2) {
        mInteger2 = integer2;
    }

    public Integer getInteger3() {
        return mInteger3;
    }

    public void setInteger3(Integer integer3) {
        mInteger3 = integer3;
    }

    public String getString1() {
        return mString1;
    }

    public void setString1(String string1) {
        mString1 = string1;
    }

    public String getString2() {
        return mString2;
    }

    public void setString2(String string2) {
        mString2 = string2;
    }

    public String getString3() {
        return mString3;
    }

    public void setString3(String string3) {
        mString3 = string3;
    }

    public String getMultiline1() {
        return mMultiline1;
    }

    public void setMultiline1(String multiline1) {
        mMultiline1 = multiline1;
    }

    public String getMultiline2() {
        return mMultiline2;
    }

    public void setMultiline2(String multiline2) {
        mMultiline2 = multiline2;
    }

    public String getMultiline3() {
        return mMultiline3;
    }

    public void setMultiline3(String multiline3) {
        mMultiline3 = multiline3;
    }

    public Boolean isBoolean1() {
        return mBoolean1;
    }

    public void setBoolean1(Boolean boolean1) {
        mBoolean1 = boolean1;
    }

    public Boolean isBoolean2() {
        return mBoolean2;
    }

    public void setBoolean2(Boolean boolean2) {
        mBoolean2 = boolean2;
    }

    public Boolean isBoolean3() {
        return mBoolean3;
    }

    public void setBoolean3(Boolean boolean3) {
        mBoolean3 = boolean3;
    }

    public LocalDateTime getDate1() {
        return mDate1;
    }

    public void setDate1(LocalDateTime date1) {
        mDate1 = date1;
    }

    public LocalDateTime getDate2() {
        return mDate2;
    }

    public void setDate2(LocalDateTime date2) {
        mDate2 = date2;
    }

    public LocalDateTime getDate3() {
        return mDate3;
    }

    public void setDate3(LocalDateTime date3) {
        mDate3 = date3;
    }
}
