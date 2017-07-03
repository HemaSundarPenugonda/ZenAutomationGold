package com.znalytics.enrollment.tx.api.entity.billingaccount;

public class ContractList {
    private Integer ContractTerm;
    private String ServiceTypeName;
    private String ContractStartDate;
    private String ContractEndDate;
    private String ContractSignedDate;
    private String ContractNumber;
    private Boolean IsCreditRequirement;
    private Boolean IsLateFee;

    public ContractList() {

    }

    public ContractList(Integer contractTerm, String serviceTypeName,
	    String contractStartDate, String contractEndDate,
	    String contractSignedDate, String contractNumber,
	    Boolean isCreditRequirement, Boolean isLateFee) {
	this.ContractTerm = contractTerm;
	this.ServiceTypeName = serviceTypeName;
	this.ContractStartDate = contractStartDate;
	this.ContractEndDate = contractEndDate;
	this.ContractSignedDate = contractSignedDate;
	this.ContractNumber = contractNumber;
	this.IsCreditRequirement = isCreditRequirement;
	this.IsLateFee = isLateFee;
    }

    public Integer getContractTerm() {
	return ContractTerm;
    }

    public void setContractTerm(Integer contractTerm) {
	this.ContractTerm = contractTerm;
    }

    public String getServiceTypeName() {
	return ServiceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
	this.ServiceTypeName = serviceTypeName;
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

    public String getContractSignedDate() {
	return ContractSignedDate;
    }

    public void setContractSignedDate(String contractSignedDate) {
	this.ContractSignedDate = contractSignedDate;
    }

    public String getContractNumber() {
	return ContractNumber;
    }

    public void setContractNumber(String contractNumber) {
	this.ContractNumber = contractNumber;
    }

    public Boolean getIsCreditRequirement() {
	return IsCreditRequirement;
    }

    public void setIsCreditRequirement(Boolean isCreditRequirement) {
	this.IsCreditRequirement = isCreditRequirement;
    }

    public Boolean getIsLateFee() {
	return IsLateFee;
    }

    public void setIsLateFee(Boolean isLateFee) {
	this.IsLateFee = isLateFee;
    }

}
