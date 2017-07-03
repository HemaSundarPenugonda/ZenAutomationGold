package com.znalytics.enrollment.tx.api.entity.meterlist;

public class MeterOwnerEntity {
    private Integer MeterOwnerType;
    private Integer MeterOwnerID;
    private String MeterOwnerText;

    public MeterOwnerEntity() {

    }

    public MeterOwnerEntity(Integer meterOwnerType, Integer meterOwnerID,
	    String meterOwnerText) {
	this.MeterOwnerType = meterOwnerType;
	this.MeterOwnerID = meterOwnerID;
	this.MeterOwnerText = meterOwnerText;
    }

    public Integer getMeterOwnerType() {
	return MeterOwnerType;
    }

    public void setMeterOwnerType(Integer meterOwnerType) {
	this.MeterOwnerType = meterOwnerType;
    }

    public Integer getMeterOwnerID() {
	return MeterOwnerID;
    }

    public void setMeterOwnerID(Integer meterOwnerID) {
	this.MeterOwnerID = meterOwnerID;
    }

    public String getMeterOwnerText() {
	return MeterOwnerText;
    }

    public void setMeterOwnerText(String meterOwnerText) {
	this.MeterOwnerText = meterOwnerText;
    }

}

