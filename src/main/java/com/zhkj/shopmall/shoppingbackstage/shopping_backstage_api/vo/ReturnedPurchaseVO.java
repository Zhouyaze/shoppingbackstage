package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;


public class ReturnedPurchaseVO {

    // 退货标识(退货 换货)
    private int messageType;
    //订单编号
    private String manifest;
    // 退货人
    private String returnUserName;
    //退货地址
    private String returnUserAddress;
    // 退货商品名称
    private String commodityName;
    // 退货商品规格
    private String commoditySku;

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getManifest() {
        return manifest;
    }

    public void setManifest(String manifest) {
        this.manifest = manifest;
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

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommoditySku() {
        return commoditySku;
    }

    public void setCommoditySku(String commoditySku) {
        this.commoditySku = commoditySku;
    }



}
