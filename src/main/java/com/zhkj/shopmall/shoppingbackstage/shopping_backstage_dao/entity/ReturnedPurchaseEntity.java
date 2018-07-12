package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class ReturnedPurchaseEntity {
    private int id;
    private Integer messageType;
    private String manifest;
    private Integer operatingStatus;
    private String returnUserName;
    private String returnUserAddress;
    private String returnCommodityName;
    private String returnCommoditySku;
    private String backstageHandlersint;
    private String purchaseHandlersint;
    private Timestamp messageCreateTime;

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

    public String getReturnCommoditySku() {
        return returnCommoditySku;
    }

    public void setReturnCommoditySku(String returnCommoditySku) {
        this.returnCommoditySku = returnCommoditySku;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnedPurchaseEntity that = (ReturnedPurchaseEntity) o;
        return id == that.id &&
                Objects.equals(messageType, that.messageType) &&
                Objects.equals(manifest, that.manifest) &&
                Objects.equals(operatingStatus, that.operatingStatus) &&
                Objects.equals(returnUserName, that.returnUserName) &&
                Objects.equals(returnUserAddress, that.returnUserAddress) &&
                Objects.equals(returnCommodityName, that.returnCommodityName) &&
                Objects.equals(returnCommoditySku, that.returnCommoditySku) &&
                Objects.equals(backstageHandlersint, that.backstageHandlersint) &&
                Objects.equals(purchaseHandlersint, that.purchaseHandlersint) &&
                Objects.equals(messageCreateTime, that.messageCreateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, messageType, manifest, operatingStatus, returnUserName, returnUserAddress, returnCommodityName, returnCommoditySku, backstageHandlersint, purchaseHandlersint, messageCreateTime);
    }
}
