package com.znalytics.enrollment.tx.api.entity.common;

public class ContactEmail {
    private String EmailTypeName;
    private Boolean IsPrimary;
    private String EmailAddress;

    public ContactEmail() {
    }

    public ContactEmail(String emailTypeName, Boolean isPrimary,
	    String emailAddress) {
	this.EmailTypeName = emailTypeName;
	this.IsPrimary = isPrimary;
	this.EmailAddress = emailAddress;
    }

    public String getEmailTypeName() {
	return EmailTypeName;
    }

    public void setEmailTypeName(String emailTypeName) {
	this.EmailTypeName = emailTypeName;
    }

    public Boolean getIsPrimary() {
	return IsPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
	this.IsPrimary = isPrimary;
    }

    public String getEmailAddress() {
	return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.EmailAddress = emailAddress;
    }

}
