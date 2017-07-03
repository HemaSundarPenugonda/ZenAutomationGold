package com.znalytics.enrollment.tx.api.entity.serviceaccount;

import java.util.List;

public class ContractRateSegmentList {
    private String PassThroughTemplateDetail;
    private String Term;
    private String ContractStartDate;
    private String ContractEndDate;
    private String RateCode;
    private List<ContractSegmentDetailList> ContractSegmentDetailList;

    public ContractRateSegmentList() {

    }

    public ContractRateSegmentList(String passThroughTemplateDetail,
	    String term, String contractStartDate, String contractEndDate,
	    String rateCode,
	    List<ContractSegmentDetailList> contractSegmentDetailList) {
	this.PassThroughTemplateDetail = passThroughTemplateDetail;
	this.Term = term;
	this.ContractStartDate = contractStartDate;
	this.ContractEndDate = contractEndDate;
	this.RateCode = rateCode;
	this.ContractSegmentDetailList = contractSegmentDetailList;
    }

    public String getPassThroughTemplateDetail() {
	return PassThroughTemplateDetail;
    }

    public void setPassThroughTemplateDetail(String passThroughTemplateDetail) {
	this.PassThroughTemplateDetail = passThroughTemplateDetail;
    }

    public String getTerm() {
	return Term;
    }

    public void setTerm(String term) {
	this.Term = term;
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

    public String getRateCode() {
	return RateCode;
    }

    public void setRateCode(String rateCode) {
	this.RateCode = rateCode;
    }

    public List<ContractSegmentDetailList> getContractSegmentDetailList() {
	return ContractSegmentDetailList;
    }

    public void setContractSegmentDetailList(
	    List<ContractSegmentDetailList> contractSegmentDetailList) {
	this.ContractSegmentDetailList = contractSegmentDetailList;
    }

}

