package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class CommodityevaluationEntity {
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp evaluationTime;
    private String evaluationContent;
    private int evaluationTypeId;
    private int userId;
    private int commodityId;
    private String commodityName;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    private String nickName;
    private String loginName;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Timestamp evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public int getEvaluationTypeId() {
        return evaluationTypeId;
    }

    public void setEvaluationTypeId(int evaluationTypeId) {
        this.evaluationTypeId = evaluationTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }
}
