package com.znalytics.enrollment.tx.api.entity.serviceaccount;

public class TaxExemption {
    private String TaxCertificateNumber;
    private String CityTaxExemptPercent;
    private String CountyTaxExemptPercent;
    private String StateTaxExemptPercent;
    private String LocalTaxExemptPercent;
    private String GRTExemptPercent;
    private String PUCTaxExemptPercent;
    private String EffectiveDate;
    private String ExpirationDate;

    public TaxExemption() {

    }

    public TaxExemption(String taxCertificateNumber,
	    String cityTaxExemptPercent, String countyTaxExemptPercent,
	    String stateTaxExemptPercent, String localTaxExemptPercent,
	    String gRTExemptPercent, String pUCTaxExemptPercent,
	    String effectiveDate, String expirationDate) {
	this.TaxCertificateNumber = taxCertificateNumber;
	this.CityTaxExemptPercent = cityTaxExemptPercent;
	this.CountyTaxExemptPercent = countyTaxExemptPercent;
	this.StateTaxExemptPercent = stateTaxExemptPercent;
	this.LocalTaxExemptPercent = localTaxExemptPercent;
	this.GRTExemptPercent = gRTExemptPercent;
	this.PUCTaxExemptPercent = pUCTaxExemptPercent;
	this.EffectiveDate = effectiveDate;
	this.ExpirationDate = expirationDate;
    }

    public String getTaxCertificateNumber() {
	return TaxCertificateNumber;
    }

    public void setTaxCertificateNumber(String taxCertificateNumber) {
	this.TaxCertificateNumber = taxCertificateNumber;
    }

    public String getCityTaxExemptPercent() {
	return CityTaxExemptPercent;
    }

    public void setCityTaxExemptPercent(String cityTaxExemptPercent) {
	this.CityTaxExemptPercent = cityTaxExemptPercent;
    }

    public String getCountyTaxExemptPercent() {
	return CountyTaxExemptPercent;
    }

    public void setCountyTaxExemptPercent(String countyTaxExemptPercent) {
	this.CountyTaxExemptPercent = countyTaxExemptPercent;
    }

    public String getStateTaxExemptPercent() {
	return StateTaxExemptPercent;
    }

    public void setStateTaxExemptPercent(String stateTaxExemptPercent) {
	this.StateTaxExemptPercent = stateTaxExemptPercent;
    }

    public String getLocalTaxExemptPercent() {
	return LocalTaxExemptPercent;
    }

    public void setLocalTaxExemptPercent(String localTaxExemptPercent) {
	this.LocalTaxExemptPercent = localTaxExemptPercent;
    }

    public String getGRTExemptPercent() {
	return GRTExemptPercent;
    }

    public void setGRTExemptPercent(String gRTExemptPercent) {
	this.GRTExemptPercent = gRTExemptPercent;
    }

    public String getPUCTaxExemptPercent() {
	return PUCTaxExemptPercent;
    }

    public void setPUCTaxExemptPercent(String pUCTaxExemptPercent) {
	this.PUCTaxExemptPercent = pUCTaxExemptPercent;
    }

    public String getEffectiveDate() {
	return EffectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
	this.EffectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
	return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
	this.ExpirationDate = expirationDate;
    }

}

