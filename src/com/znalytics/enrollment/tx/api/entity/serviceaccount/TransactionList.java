package com.znalytics.enrollment.tx.api.entity.serviceaccount;

public class TransactionList {
    private Boolean IsTransactionHold;
    private String HoldReasonName;
    private String ScheduledTransactionReleaseDate;
    private String TransactionRequestTypeName;
    private String TransactionRequestStatusName;
    private String RequestedEffectiveDate;
    private String HURequestType;
    private String EstimatedEffectiveDate;
    private String AccessDescription;

    public TransactionList() {

    }

    public TransactionList(Boolean isTransactionHold, String holdReasonName,
	    String scheduledTransactionReleaseDate,
	    String transactionRequestTypeName,
	    String transactionRequestStatusName, String requestedEffectiveDate,
	    String hURequestType, String estimatedEffectiveDate,
	    String accessDescription) {
	this.IsTransactionHold = isTransactionHold;
	this.HoldReasonName = holdReasonName;
	this.ScheduledTransactionReleaseDate = scheduledTransactionReleaseDate;
	this.TransactionRequestTypeName = transactionRequestTypeName;
	this.TransactionRequestStatusName = transactionRequestStatusName;
	this.RequestedEffectiveDate = requestedEffectiveDate;
	this.HURequestType = hURequestType;
	this.EstimatedEffectiveDate = estimatedEffectiveDate;
	this.AccessDescription = accessDescription;
    }

    public Boolean getIsTransactionHold() {
	return IsTransactionHold;
    }

    public void setIsTransactionHold(Boolean isTransactionHold) {
	this.IsTransactionHold = isTransactionHold;
    }

    public String getHoldReasonName() {
	return HoldReasonName;
    }

    public void setHoldReasonName(String holdReasonName) {
	this.HoldReasonName = holdReasonName;
    }

    public String getScheduledTransactionReleaseDate() {
	return ScheduledTransactionReleaseDate;
    }

    public void setScheduledTransactionReleaseDate(
	    String scheduledTransactionReleaseDate) {
	this.ScheduledTransactionReleaseDate = scheduledTransactionReleaseDate;
    }

    public String getTransactionRequestTypeName() {
	return TransactionRequestTypeName;
    }

    public void setTransactionRequestTypeName(String transactionRequestTypeName) {
	this.TransactionRequestTypeName = transactionRequestTypeName;
    }

    public String getTransactionRequestStatusName() {
	return TransactionRequestStatusName;
    }

    public void setTransactionRequestStatusName(
	    String transactionRequestStatusName) {
	this.TransactionRequestStatusName = transactionRequestStatusName;
    }

    public String getRequestedEffectiveDate() {
	return RequestedEffectiveDate;
    }

    public void setRequestedEffectiveDate(String requestedEffectiveDate) {
	this.RequestedEffectiveDate = requestedEffectiveDate;
    }

    public String getHURequestType() {
	return HURequestType;
    }

    public void setHURequestType(String hURequestType) {
	this.HURequestType = hURequestType;
    }

    public String getEstimatedEffectiveDate() {
	return EstimatedEffectiveDate;
    }

    public void setEstimatedEffectiveDate(String estimatedEffectiveDate) {
	this.EstimatedEffectiveDate = estimatedEffectiveDate;
    }

    public String getAccessDescription() {
	return AccessDescription;
    }

    public void setAccessDescription(String accessDescription) {
	this.AccessDescription = accessDescription;
    }

}

