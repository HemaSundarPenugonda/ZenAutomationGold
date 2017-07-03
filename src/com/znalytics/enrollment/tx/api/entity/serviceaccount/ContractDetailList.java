package com.znalytics.enrollment.tx.api.entity.serviceaccount;



public class ContractDetailList {
    private String ContractNumber;
    private String ContractStartDate;
    private String ContractEndDate;
    private String DepositAmountTypeName;
    private Integer DepositAmount;
    private ContractRateSchedule ContractRateSchedule;

    public ContractDetailList() {

    }

    public ContractDetailList(String contractNumber, String contractStartDate,
	    String contractEndDate, String depositAmountTypeName,
	    Integer depositAmount,
	    ContractRateSchedule contractRateSchedule) {
	this.ContractNumber = contractNumber;
	this.ContractStartDate = contractStartDate;
	this.ContractEndDate = contractEndDate;
	this.DepositAmountTypeName = depositAmountTypeName;
	this.DepositAmount = depositAmount;
	this.ContractRateSchedule = contractRateSchedule;
    }

    public String getContractNumber() {
	return ContractNumber;
    }

    public void setContractNumber(String contractNumber) {
	this.ContractNumber = contractNumber;
    }

    public String getContractStartDate() {
	return ContractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
	this.ContractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
	return ContractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
	this.ContractEndDate = contractEndDate;
    }

    public String getDepositAmountTypeName() {
	return DepositAmountTypeName;
    }

    public void setDepositAmountTypeName(String depositAmountTypeName) {
	this.DepositAmountTypeName = depositAmountTypeName;
    }

    public Integer getDepositAmount() {
	return DepositAmount;
    }

    public void setDepositAmount(Integer depositAmount) {
	this.DepositAmount = depositAmount;
    }

    public ContractRateSchedule getContractRateSchedule() {
	return ContractRateSchedule;
    }

    public void setContractRateSchedule(
	    ContractRateSchedule contractRateSchedule) {
	this.ContractRateSchedule = contractRateSchedule;
    }

}

