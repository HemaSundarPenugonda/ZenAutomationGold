package com.znalytics.enrollment.tx.api.entity.common;

public class AuthorizedContactEmailList {
    private Boolean IsPrimary;
    private ContactEmail ContactEmail;

    public AuthorizedContactEmailList() {
    }

    public AuthorizedContactEmailList(Boolean isPrimary,
	    ContactEmail contactEmail) {
	this.IsPrimary = isPrimary;
	this.ContactEmail = contactEmail;
    }

    public Boolean getIsPrimary() {
	return IsPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
	this.IsPrimary = isPrimary;
    }

    public ContactEmail getContactEmail() {
	return ContactEmail;
    }

    public void setContactEmail(ContactEmail contactEmail) {
	this.ContactEmail = contactEmail;
    }

}
