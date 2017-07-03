package com.znalytics.enrollment.tx.api.entity.serviceaccount;

public class MarketingInfo {

    private Boolean LevelBillInterest;
    private Boolean SolarInterest;

    public MarketingInfo() {

    }

    public MarketingInfo(Boolean levelBillInterest, Boolean solarInterest) {
	this.LevelBillInterest = levelBillInterest;
	SolarInterest = solarInterest;
    }

    public Boolean getLevelBillInterest() {
	return LevelBillInterest;
    }

    public void setLevelBillInterest(Boolean levelBillInterest) {
	this.LevelBillInterest = levelBillInterest;
    }

    public Boolean getSolarInterest() {
	return SolarInterest;
    }

    public void setSolarInterest(Boolean solarInterest) {
	this.SolarInterest = solarInterest;
    }

}
