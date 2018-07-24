package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Objects;

public class CommodityevaluationEntity {
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp evaluationTime;
    private String evaluationContent;
    private int evaluationTypeId;
    private int userId;
    private int commodityId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityevaluationEntity that = (CommodityevaluationEntity) o;
        return id == that.id &&
                evaluationTypeId == that.evaluationTypeId &&
                userId == that.userId &&
                commodityId == that.commodityId &&
                Objects.equals(evaluationTime, that.evaluationTime) &&
                Objects.equals(evaluationContent, that.evaluationContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, evaluationTime, evaluationContent, evaluationTypeId, userId, commodityId);
    }
}
