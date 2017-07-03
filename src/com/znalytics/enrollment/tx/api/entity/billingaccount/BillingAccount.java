package com.znalytics.enrollment.tx.api.entity.billingaccount;

import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactList;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ServiceAccount;

import java.util.List;

public class BillingAccount {
    private List<AuthorizedContactList> AuthorizedContactList;
    private List<ContractList> ContractList;
    private MailAddress MailAddress;
    private SecondaryNotificationAddress SecondaryNotificationAddress;
    private List<ServiceAccount> ServiceAccount;
    private String BillFormatName;
    private String BillTypeName;
    private String BillingAccountNumber;
    private String ContractSource;
    private String BillDate;
    private String PaymentTermOverride;
    private String SoldDate;
    private String DocumentDeliveryMethod;

    public BillingAccount() {

    }

    public BillingAccount(List<AuthorizedContactList> authorizedContactList,
	    List<ContractList> contractList, MailAddress mailAddress,
	    SecondaryNotificationAddress secondaryNotificationAddress,
	    List<ServiceAccount> serviceAccount, String billFormatName,
	    String billTypeName, String billingAccountNumber,
	    String contractSource, String billDate, String paymentTermOverride,
	    String soldDate, String documentDeliveryMethod) {
	this.AuthorizedContactList = authorizedContactList;
	this.ContractList = contractList;
	this.MailAddress = mailAddress;
	this.SecondaryNotificationAddress = secondaryNotificationAddress;
	this.ServiceAccount = serviceAccount;
	this.BillFormatName = billFormatName;
	this.BillTypeName = billTypeName;
	this.BillingAccountNumber = billingAccountNumber;
	this.ContractSource = contractSource;
	this.BillDate = billDate;
	this.PaymentTermOverride = paymentTermOverride;
	this.SoldDate = soldDate;
	this.DocumentDeliveryMethod = documentDeliveryMethod;
    }

    public List<AuthorizedContactList> getAuthorizedContactList() {
	return AuthorizedContactList;
    }

    public void setAuthorizedContactList(
	    List<AuthorizedContactList> authorizedContactList) {
	this.AuthorizedContactList = authorizedContactList;
    }

    public List<ContractList> getContractList() {
	return ContractList;
    }

    public void setContractList(List<ContractList> contractList) {
	this.ContractList = contractList;
    }

    public MailAddress getMailAddress() {
	return MailAddress;
    }

    public void setMailAddress(MailAddress mailAddress) {
	this.MailAddress = mailAddress;
    }

    public SecondaryNotificationAddress getSecondaryNotificationAddress() {
	return SecondaryNotificationAddress;
    }

    public void setSecondaryNotificationAddress(
	    SecondaryNotificationAddress secondaryNotificationAddress) {
	this.SecondaryNotificationAddress = secondaryNotificationAddress;
    }

    public List<ServiceAccount> getServiceAccount() {
	return ServiceAccount;
    }

    public void setServiceAccount(List<ServiceAccount> serviceAccount) {
	this.ServiceAccount = serviceAccount;
    }

    public String getBillFormatName() {
	return BillFormatName;
    }

    public void setBillFormatName(String billFormatName) {
	this.BillFormatName = billFormatName;
    }

    public String getBillTypeName() {
	return BillTypeName;
    }

    public void setBillTypeName(String billTypeName) {
	this.BillTypeName = billTypeName;
    }

    public String getBillingAccountNumber() {
	return BillingAccountNumber;
    }

    public void setBillingAccountNumber(String billingAccountNumber) {
	this.BillingAccountNumber = billingAccountNumber;
    }

    public String getContractSource() {
	return ContractSource;
    }

    public void setContractSource(String contractSource) {
	this.ContractSource = contractSource;
    }

    public String getBillDate() {
	return BillDate;
    }

    public void setBillDate(String billDate) {
	this.BillDate = billDate;
    }

    public String getPaymentTermOverride() {
	return PaymentTermOverride;
    }

    public void setPaymentTermOverride(String paymentTermOverride) {
	this.PaymentTermOverride = paymentTermOverride;
    }

    public String getSoldDate() {
	return SoldDate;
    }

    public void setSoldDate(String soldDate) {
	this.SoldDate = soldDate;
    }

    public String getDocumentDeliveryMethod() {
	return DocumentDeliveryMethod;
    }

    public void setDocumentDeliveryMethod(String documentDeliveryMethod) {
	this.DocumentDeliveryMethod = documentDeliveryMethod;
    }
}
