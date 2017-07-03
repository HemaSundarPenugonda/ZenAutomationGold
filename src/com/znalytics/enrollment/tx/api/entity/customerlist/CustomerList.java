package com.znalytics.enrollment.tx.api.entity.customerlist;

import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactList;
import com.znalytics.enrollment.tx.api.entity.billingaccount.BillingAccount;

import java.util.List;

public class CustomerList {
    private List<AuthorizedContactList> AuthorizedContactList;
    private List<BillingAccount> BillingAccount;
    private CustomerCommercial CustomerCommercial;
    private CustomerIndividual CustomerIndividual;
    private LegalAddress LegalAddress;
    private String CustomerType;
    private String Language;
    private Integer CustomerNumber;
    private String CustomerName;
    private String PassCode;
    private Boolean IsVIP;
    private String CustomerSegment;

    public CustomerList() {
    }

    public CustomerList(List<AuthorizedContactList> authorizedContactList,
	    List<BillingAccount> billingAccount,
	    CustomerCommercial customerCommercial,
	    CustomerIndividual customerIndividual, LegalAddress legalAddress,
	    String customerType, String language, Integer customerNumber,
	    String customerName, String passCode, Boolean isVIP,
	    String customerSegment) {
	this.AuthorizedContactList = authorizedContactList;
	this.BillingAccount = billingAccount;
	this.CustomerCommercial = customerCommercial;
	this.CustomerIndividual = customerIndividual;
	this.LegalAddress = legalAddress;
	this.CustomerType = customerType;
	this.Language = language;
	this.CustomerNumber = customerNumber;
	this.CustomerName = customerName;
	this.PassCode = passCode;
	this.IsVIP = isVIP;
	this.CustomerSegment = customerSegment;
    }

    public List<AuthorizedContactList> getAuthorizedContactList() {
	return AuthorizedContactList;
    }

    public void setAuthorizedContactList(
	    List<AuthorizedContactList> authorizedContactList) {
	this.AuthorizedContactList = authorizedContactList;
    }

    public List<BillingAccount> getBillingAccount() {
	return BillingAccount;
    }

    public void setBillingAccount(List<BillingAccount> billingAccount) {
	this.BillingAccount = billingAccount;
    }

    public CustomerCommercial getCustomerCommercial() {
	return CustomerCommercial;
    }

    public void setCustomerCommercial(CustomerCommercial customerCommercial) {
	this.CustomerCommercial = customerCommercial;
    }

    public CustomerIndividual getCustomerIndividual() {
	return CustomerIndividual;
    }

    public void setCustomerIndividual(CustomerIndividual customerIndividual) {
	this.CustomerIndividual = customerIndividual;
    }

    public LegalAddress getLegalAddress() {
	return LegalAddress;
    }

    public void setLegalAddress(LegalAddress legalAddress) {
	this.LegalAddress = legalAddress;
    }

    public String getCustomerType() {
	return CustomerType;
    }

    public void setCustomerType(String customerType) {
	this.CustomerType = customerType;
    }

    public String getLanguage() {
	return Language;
    }

    public void setLanguage(String language) {
	this.Language = language;
    }

    public Integer getCustomerNumber() {
	return CustomerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
	this.CustomerNumber = customerNumber;
    }

    public String getCustomerName() {
	return CustomerName;
    }

    public void setCustomerName(String customerName) {
	this.CustomerName = customerName;
    }

    public String getPassCode() {
	return PassCode;
    }

    public void setPassCode(String passCode) {
	this.PassCode = passCode;
    }

    public Boolean getIsVIP() {
	return IsVIP;
    }

    public void setIsVIP(Boolean isVIP) {
	this.IsVIP = isVIP;
    }

    public String getCustomerSegment() {
	return CustomerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
	this.CustomerSegment = customerSegment;
    }

}
