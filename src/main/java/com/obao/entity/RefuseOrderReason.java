package com.obao.entity;

/**
 * Created by Acey on 17-4-9.
 * description:
 */
public class RefuseOrderReason {
    private Integer refuseId;
    private Integer businessId;
    private String reason;

    public Integer getRefuseId() {
        return refuseId;
    }

    public void setRefuseId(Integer refuseId) {
        this.refuseId = refuseId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
