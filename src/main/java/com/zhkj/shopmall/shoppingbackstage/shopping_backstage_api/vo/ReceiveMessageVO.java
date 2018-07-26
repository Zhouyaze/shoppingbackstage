package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;

public class ReceiveMessageVO {

    // 退货 发货标识
    private int type;
    //审核 状态
    private String  messageState;
    //处理人
    private String disposeName;
    //唯一标识
    private String messageToken;

    private int inventory;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDisposeName() {
        return disposeName;
    }

    public void setDisposeName(String disposeName) {
        this.disposeName = disposeName;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
    }

    public String getMessageToken() {
        return messageToken;
    }

    public void setMessageToken(String messageToken) {
        this.messageToken = messageToken;
    }



}
