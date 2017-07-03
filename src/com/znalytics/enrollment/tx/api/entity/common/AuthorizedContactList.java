package com.znalytics.enrollment.tx.api.entity.common;

import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactEmailList;
import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactPhoneList;

import java.util.List;

public class AuthorizedContactList {
    private String ContactTypeName;
    private String ContactName;
    private String BirthDate;
    private Boolean IsPrimary;
    private Boolean IsSMSAllowed;
    private List<AuthorizedContactPhoneList> AuthorizedContactPhoneList;
    private List<AuthorizedContactEmailList> AuthorizedContactEmailList;

    public AuthorizedContactList() {
    }

    public AuthorizedContactList(String contactTypeName, String contactName,
	    String birthDate, Boolean isPrimary, Boolean isSMSAllowed,
	    List<AuthorizedContactPhoneList> authorizedContactPhoneList,
	    List<AuthorizedContactEmailList> authorizedContactEmailList) {
	this.ContactTypeName = contactTypeName;
	this.ContactName = contactName;
	this.BirthDate = birthDate;
	this.IsPrimary = isPrimary;
	this.IsSMSAllowed = isSMSAllowed;
	this.AuthorizedContactPhoneList = authorizedContactPhoneList;
	this.AuthorizedContactEmailList = authorizedContactEmailList;
    }

    public String getContactTypeName() {
	return ContactTypeName;
    }

    public void setContactTypeName(String contactTypeName) {
	this.ContactTypeName = contactTypeName;
    }

    public String getContactName() {
	return ContactName;
    }

    public void setContactName(String contactName) {
	this.ContactName = contactName;
    }

    public String getBirthDate() {
	return BirthDate;
    }

    public void setBirthDate(String birthDate) {
	this.BirthDate = birthDate;
    }

    public Boolean getIsPrimary() {
	return IsPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
	this.IsPrimary = isPrimary;
    }

    public Boolean getIsSMSAllowed() {
	return IsSMSAllowed;
    }

    public void setIsSMSAllowed(Boolean isSMSAllowed) {
	this.IsSMSAllowed = isSMSAllowed;
    }

    public List<AuthorizedContactPhoneList> getAuthorizedContactPhoneList() {
	return AuthorizedContactPhoneList;
    }

    public void setAuthorizedContactPhoneList(
	    List<AuthorizedContactPhoneList> authorizedContactPhoneList) {
	this.AuthorizedContactPhoneList = authorizedContactPhoneList;
    }

    public List<AuthorizedContactEmailList> getAuthorizedContactEmailList() {
	return AuthorizedContactEmailList;
    }

    public void setAuthorizedContactEmailList(
	    List<AuthorizedContactEmailList> authorizedContactEmailList) {
	this.AuthorizedContactEmailList = authorizedContactEmailList;
    }

}

