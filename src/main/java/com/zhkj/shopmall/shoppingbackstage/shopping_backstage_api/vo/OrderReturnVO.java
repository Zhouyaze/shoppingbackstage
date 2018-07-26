package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;

import java.util.List;

public class OrderReturnVO {
   private List<FormShopDTOList> fromShopDtoList;
   private int  harvestAddressId;
    private String orderNumber;
    private int messageType;

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public List<FormShopDTOList> getFromShopDtoList() {
        return fromShopDtoList;
    }

    public void setFromShopDtoList(List<FormShopDTOList> fromShopDtoList) {
        this.fromShopDtoList = fromShopDtoList;
    }

    public int getHarvestAddressId() {
        return harvestAddressId;
    }

    public void setHarvestAddressId(int harvestAddressId) {
        this.harvestAddressId = harvestAddressId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
