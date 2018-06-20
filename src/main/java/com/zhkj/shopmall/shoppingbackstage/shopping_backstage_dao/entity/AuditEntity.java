package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class AuditEntity {
    private int id;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer status;
    private int auditGoodsId;
    private int type;
    private AuditgoodsEntity auditgoodsEntity;

    public AuditgoodsEntity getAuditgoodsEntity() {
        return auditgoodsEntity;
    }

    public void setAuditgoodsEntity(AuditgoodsEntity auditgoodsEntity) {
        this.auditgoodsEntity = auditgoodsEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getAuditGoodsId() {
        return auditGoodsId;
    }

    public void setAuditGoodsId(int auditGoodsId) {
        this.auditGoodsId = auditGoodsId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditEntity that = (AuditEntity) o;
        return id == that.id &&
                auditGoodsId == that.auditGoodsId &&
                type == that.type &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startTime, endTime, status, auditGoodsId, type);
    }
}
