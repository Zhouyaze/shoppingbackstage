package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;


public class ReturnedPurchaseVO {

    // 退货标识(退货 换货,补货)
    private int messageType;
    //订单编号
    private String manifest;
    // 退货人
    private String returnUserName;
    //退货地址
    private String returnUserAddress;
    // 退货商品名称
    private String commodityName;
    //退货数量
    private int count;
    // 退货商品规格
    private String commoditySku;

    //返回  状态 通过 还是  不通过
    private int operatingStatus;

    public int getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(int operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    private String specification1;

    private String specification2;

    private String specification3;

    private String specification4;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
