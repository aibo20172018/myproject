package com.example.springboot.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ProcessElement {
    /**
     * 
     */
    private Long cId;

    /**
     * Ԫ
     */
    private String cElcode;

    /**
     * Ԫ
     */
    private String cElname;

    /**
     * Ԥ
     */
    private String cPrevalue;

    /**
     * ģ
     */
    private String cDatatype;

    /**
     * 
     */
    private String cGroupcode;

    /**
     * 
     */
    private String cTemplete;

    /**
     * Y:
     */
    private String cLable;

    /**
     * 
     */
    private Integer cSort;

    /**
     * 
     */
    private String createdBy;

    /**
     * 
     */
    private Date createdTime;

    /**
     * 
     */
    private String updateBy;

    /**
     * 
     */
    private Date updateTime;


    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcElcode() {
        return cElcode;
    }

    public void setcElcode(String cElcode) {
        this.cElcode = cElcode;
    }

    public String getcElname() {
        return cElname;
    }

    public void setcElname(String cElname) {
        this.cElname = cElname;
    }

    public String getcPrevalue() {
        return cPrevalue;
    }

    public void setcPrevalue(String cPrevalue) {
        this.cPrevalue = cPrevalue;
    }

    public String getcDatatype() {
        return cDatatype;
    }

    public void setcDatatype(String cDatatype) {
        this.cDatatype = cDatatype;
    }

    public String getcGroupcode() {
        return cGroupcode;
    }

    public void setcGroupcode(String cGroupcode) {
        this.cGroupcode = cGroupcode;
    }

    public String getcTemplete() {
        return cTemplete;
    }

    public void setcTemplete(String cTemplete) {
        this.cTemplete = cTemplete;
    }

    public String getcLable() {
        return cLable;
    }

    public void setcLable(String cLable) {
        this.cLable = cLable;
    }

    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}