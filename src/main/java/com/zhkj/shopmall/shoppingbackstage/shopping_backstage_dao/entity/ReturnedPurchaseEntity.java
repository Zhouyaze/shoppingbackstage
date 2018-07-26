package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class ReturnedPurchaseEntity {
    private int id;
    private Integer messageType;
    private String manifest;
    private Integer operatingStatus;
    private String returnUserName;
    private String returnUserAddress;
    private String returnCommodityName;
    private int specificationsId;

    public int getSpecificationsId() {
        return specificationsId;
    }

    public void setSpecificationsId(int specificationsId) {
        this.specificationsId = specificationsId;
    }

    private String backstageHandlersint;
    private String purchaseHandlersint;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp messageCreateTime;
    private int inventory;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    private String specification1;
    private String specification2;
    private String specification3;
    private String specification4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getManifest() {
        return manifest;
    }

    public void setManifest(String manifest) {
        this.manifest = manifest;
    }

    public Integer getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getReturnUserName() {
        return returnUserName;
    }

    public void setReturnUserName(String returnUserName) {
        this.returnUserName = returnUserName;
    }

    public String getReturnUserAddress() {
        return returnUserAddress;
    }

    public void setReturnUserAddress(String returnUserAddress) {
        this.returnUserAddress = returnUserAddress;
    }

    public String getReturnCommodityName() {
        return returnCommodityName;
    }

    public void setReturnCommodityName(String returnCommodityName) {
        this.returnCommodityName = returnCommodityName;
    }


    public String getBackstageHandlersint() {
        return backstageHandlersint;
    }

    public void setBackstageHandlersint(String backstageHandlersint) {
        this.backstageHandlersint = backstageHandlersint;
    }

    public String getPurchaseHandlersint() {
        return purchaseHandlersint;
    }

    public void setPurchaseHandlersint(String purchaseHandlersint) {
        this.purchaseHandlersint = purchaseHandlersint;
    }

    public Timestamp getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Timestamp messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public String getSpecification1() {
        return specification1;
    }

    public void setSpecification1(String specification1) {
        this.specification1 = specification1;
    }

    public String getSpecification2() {
        return specification2;
    }

    public void setSpecification2(String specification2) {
        this.specification2 = specification2;
    }

    public String getSpecification3() {
        return specification3;
    }

    public void setSpecification3(String specification3) {
        this.specification3 = specification3;
    }

    public String getSpecification4() {
        return specification4;
    }

    public void setSpecification4(String specification4) {
        this.specification4 = specification4;
    }
}
