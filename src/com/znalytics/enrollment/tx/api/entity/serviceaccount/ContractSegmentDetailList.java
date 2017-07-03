package com.znalytics.enrollment.tx.api.entity.serviceaccount;

public class ContractSegmentDetailList {
    private String DescriptionType;
    private String RateCalculatorName;
    private String IndexType;
    private Double RateAmount;
    private String UOM;
    private String MeterRegisterType;
    private Integer BlendPercent;
    private Integer UsageRangeMax;
    private Integer UsageRangeMin;
    private Integer DaysRangeMax;
    private Integer DaysRangeMin;
    private Boolean IsUseRateCode;
    private Boolean IsIncludesGRT;
    private Boolean IsIncludesSalesTax;
    private Boolean IsTaxable;

    public ContractSegmentDetailList() {

    }

    public ContractSegmentDetailList(String descriptionType,
	    String rateCalculatorName, String indexType, Double rateAmount,
	    String uOM, String meterRegisterType, Integer blendPercent,
	    Integer usageRangeMax, Integer usageRangeMin, Integer daysRangeMax,
	    Integer daysRangeMin, Boolean isUseRateCode, Boolean isIncludesGRT,
	    Boolean isIncludesSalesTax, Boolean isTaxable) {
	this.DescriptionType = descriptionType;
	this.RateCalculatorName = rateCalculatorName;
	this.IndexType = indexType;
	this.RateAmount = rateAmount;
	this.UOM = uOM;
	this.MeterRegisterType = meterRegisterType;
	this.BlendPercent = blendPercent;
	this.UsageRangeMax = usageRangeMax;
	this.UsageRangeMin = usageRangeMin;
	this.DaysRangeMax = daysRangeMax;
	this.DaysRangeMin = daysRangeMin;
	this.IsUseRateCode = isUseRateCode;
	this.IsIncludesGRT = isIncludesGRT;
	this.IsIncludesSalesTax = isIncludesSalesTax;
	this.IsTaxable = isTaxable;
    }

    public String getDescriptionType() {
	return DescriptionType;
    }

    public void setDescriptionType(String descriptionType) {
	this.DescriptionType = descriptionType;
    }

    public String getRateCalculatorName() {
	return RateCalculatorName;
    }

    public void setRateCalculatorName(String rateCalculatorName) {
	this.RateCalculatorName = rateCalculatorName;
    }

    public String getIndexType() {
	return IndexType;
    }

    public void setIndexType(String indexType) {
	this.IndexType = indexType;
    }

    public Double getRateAmount() {
	return RateAmount;
    }

    public void setRateAmount(Double rateAmount) {
	this.RateAmount = rateAmount;
    }

    public String getUOM() {
	return UOM;
    }

    public void setUOM(String uOM) {
	this.UOM = uOM;
    }

    public String getMeterRegisterType() {
	return MeterRegisterType;
    }

    public void setMeterRegisterType(String meterRegisterType) {
	this.MeterRegisterType = meterRegisterType;
    }

    public Integer getBlendPercent() {
	return BlendPercent;
    }

    public void setBlendPercent(Integer blendPercent) {
	this.BlendPercent = blendPercent;
    }

    public Integer getUsageRangeMax() {
	return UsageRangeMax;
    }

    public void setUsageRangeMax(Integer usageRangeMax) {
	this.UsageRangeMax = usageRangeMax;
    }

    public Integer getUsageRangeMin() {
	return UsageRangeMin;
    }

    public void setUsageRangeMin(Integer usageRangeMin) {
	this.UsageRangeMin = usageRangeMin;
    }

    public Integer getDaysRangeMax() {
	return DaysRangeMax;
    }

    public void setDaysRangeMax(Integer daysRangeMax) {
	this.DaysRangeMax = daysRangeMax;
    }

    public Integer getDaysRangeMin() {
	return DaysRangeMin;
    }

    public void setDaysRangeMin(Integer daysRangeMin) {
	this.DaysRangeMin = daysRangeMin;
    }

    public Boolean getIsUseRateCode() {
	return IsUseRateCode;
    }

    public void setIsUseRateCode(Boolean isUseRateCode) {
	this.IsUseRateCode = isUseRateCode;
    }

    public Boolean getIsIncludesGRT() {
	return IsIncludesGRT;
    }

    public void setIsIncludesGRT(Boolean isIncludesGRT) {
	this.IsIncludesGRT = isIncludesGRT;
    }

    public Boolean getIsIncludesSalesTax() {
	return IsIncludesSalesTax;
    }

    public void setIsIncludesSalesTax(Boolean isIncludesSalesTax) {
	this.IsIncludesSalesTax = isIncludesSalesTax;
    }

    public Boolean getIsTaxable() {
	return IsTaxable;
    }

    public void setIsTaxable(Boolean isTaxable) {
	this.IsTaxable = isTaxable;
    }

}
