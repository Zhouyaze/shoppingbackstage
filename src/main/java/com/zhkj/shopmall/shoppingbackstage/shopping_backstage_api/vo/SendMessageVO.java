package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;

public class SendMessageVO {
    private String messageTitle;
    private String messageContent;
    private int messageStatus;
    private int messageTypeId;
    private String sendMessageName;
    private String messageToken;

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public int getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(int messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public String getSendMessageName() {
        return sendMessageName;
    }

    public void setSendMessageName(String sendMessageName) {
        this.sendMessageName = sendMessageName;
    }

    public String getMessageToken() {
        return messageToken;
    }

    public void setMessageToken(String messageToken) {
        this.messageToken = messageToken;
    }
}
