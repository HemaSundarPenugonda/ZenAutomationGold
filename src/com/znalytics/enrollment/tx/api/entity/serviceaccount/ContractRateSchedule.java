package com.znalytics.enrollment.tx.api.entity.serviceaccount;

import java.util.List;

public class ContractRateSchedule {
    private String ProductCode;
    private String Market;
    private String ZoneName;
    private String BillTypeName;
    private String RateAssignmentMethodName;
    private String RateScheduleTypeName;
    private Integer NumberOfSegments;
    private Boolean IsApplyGasLossFactors;
    private Boolean IsRollupEnergyCharges;
    private String ETFCalculationTypeName;
    private String ETFAmount;
    private List<ContractRateSegmentList> ContractRateSegmentList;

    public ContractRateSchedule() {

    }

    public ContractRateSchedule(String productCode, String market,
	    String zoneName, String billTypeName,
	    String rateAssignmentMethodName, String rateScheduleTypeName,
	    Integer numberOfSegments, Boolean isApplyGasLossFactors,
	    Boolean isRollupEnergyCharges, String eTFCalculationTypeName,
	    String eTFAmount,
	    List<ContractRateSegmentList> contractRateSegmentList) {
	this.ProductCode = productCode;
	this.Market = market;
	this.ZoneName = zoneName;
	this.BillTypeName = billTypeName;
	this.RateAssignmentMethodName = rateAssignmentMethodName;
	this.RateScheduleTypeName = rateScheduleTypeName;
	this.NumberOfSegments = numberOfSegments;
	this.IsApplyGasLossFactors = isApplyGasLossFactors;
	this.IsRollupEnergyCharges = isRollupEnergyCharges;
	this.ETFCalculationTypeName = eTFCalculationTypeName;
	this.ETFAmount = eTFAmount;
	this.ContractRateSegmentList = contractRateSegmentList;
    }

    public String getProductCode() {
	return ProductCode;
    }

    public void setProductCode(String productCode) {
	this.ProductCode = productCode;
    }

    public String getMarket() {
	return Market;
    }

    public void setMarket(String market) {
	this.Market = market;
    }

    public String getZoneName() {
	return ZoneName;
    }

    public void setZoneName(String zoneName) {
	this.ZoneName = zoneName;
    }

    public String getBillTypeName() {
	return BillTypeName;
    }

    public void setBillTypeName(String billTypeName) {
	this.BillTypeName = billTypeName;
    }

    public String getRateAssignmentMethodName() {
	return RateAssignmentMethodName;
    }

    public void setRateAssignmentMethodName(String rateAssignmentMethodName) {
	this.RateAssignmentMethodName = rateAssignmentMethodName;
    }

    public String getRateScheduleTypeName() {
	return RateScheduleTypeName;
    }

    public void setRateScheduleTypeName(String rateScheduleTypeName) {
	this.RateScheduleTypeName = rateScheduleTypeName;
    }

    public Integer getNumberOfSegments() {
	return NumberOfSegments;
    }

    public void setNumberOfSegments(Integer numberOfSegments) {
	this.NumberOfSegments = numberOfSegments;
    }

    public Boolean getIsApplyGasLossFactors() {
	return IsApplyGasLossFactors;
    }

    public void setIsApplyGasLossFactors(Boolean isApplyGasLossFactors) {
	this.IsApplyGasLossFactors = isApplyGasLossFactors;
    }

    public Boolean getIsRollupEnergyCharges() {
	return IsRollupEnergyCharges;
    }

    public void setIsRollupEnergyCharges(Boolean isRollupEnergyCharges) {
	this.IsRollupEnergyCharges = isRollupEnergyCharges;
    }

    public String getETFCalculationTypeName() {
	return ETFCalculationTypeName;
    }

    public void setETFCalculationTypeName(String eTFCalculationTypeName) {
	this.ETFCalculationTypeName = eTFCalculationTypeName;
    }

    public String getETFAmount() {
	return ETFAmount;
    }

    public void setETFAmount(String eTFAmount) {
	this.ETFAmount = eTFAmount;
    }

    public List<ContractRateSegmentList> getContractRateSegmentList() {
	return ContractRateSegmentList;
    }

    public void setContractRateSegmentList(
	    List<ContractRateSegmentList> contractRateSegmentList) {
	this.ContractRateSegmentList = contractRateSegmentList;
    }

}

