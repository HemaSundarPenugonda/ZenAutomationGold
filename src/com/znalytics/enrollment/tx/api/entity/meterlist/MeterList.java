package com.znalytics.enrollment.tx.api.entity.meterlist;

import java.util.List;

public class MeterList {
    private String MeterType;
    private String MeterNumber;
    private Boolean IsTOU;
    private Boolean IsUnmetered;
    private Boolean IsAMS;
    private Integer MeterLevel;
    private List<MeterOwnerEntity> MeterOwnerEntity;

    public MeterList() {

    }

    public MeterList(String meterType, String meterNumber, Boolean isTOU,
	    Boolean isUnmetered, Boolean isAMS, Integer meterLevel,
	    List<MeterOwnerEntity> meterOwnerEntity) {
	this.MeterType = meterType;
	this.MeterNumber = meterNumber;
	this.IsTOU = isTOU;
	this.IsUnmetered = isUnmetered;
	this.IsAMS = isAMS;
	this.MeterLevel = meterLevel;
	this.MeterOwnerEntity = meterOwnerEntity;
    }

    public String getMeterType() {
	return MeterType;
    }

    public void setMeterType(String meterType) {
	this.MeterType = meterType;
    }

    public String getMeterNumber() {
	return MeterNumber;
    }

    public void setMeterNumber(String meterNumber) {
	this.MeterNumber = meterNumber;
    }

    public Boolean getIsTOU() {
	return IsTOU;
    }

    public void setIsTOU(Boolean isTOU) {
	this.IsTOU = isTOU;
    }

    public Boolean getIsUnmetered() {
	return IsUnmetered;
    }

    public void setIsUnmetered(Boolean isUnmetered) {
	this.IsUnmetered = isUnmetered;
    }

    public Boolean getIsAMS() {
	return IsAMS;
    }

    public void setIsAMS(Boolean isAMS) {
	this.IsAMS = isAMS;
    }

    public Integer getMeterLevel() {
	return MeterLevel;
    }

    public void setMeterLevel(Integer meterLevel) {
	this.MeterLevel = meterLevel;
    }

    public List<MeterOwnerEntity> getMeterOwnerEntity() {
	return MeterOwnerEntity;
    }

    public void setMeterOwnerEntity(List<MeterOwnerEntity> meterOwnerEntity) {
	this.MeterOwnerEntity = meterOwnerEntity;
    }

}

