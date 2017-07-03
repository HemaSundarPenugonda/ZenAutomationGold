package com.znalytics.enrollment.tx.api.entity.common;

public class AuthorizedContactPhoneList {
    private Boolean IsPrimary;
    private ContactPhone ContactPhone;

    public AuthorizedContactPhoneList() {
    }

    public AuthorizedContactPhoneList(Boolean isPrimary,
	    ContactPhone contactPhone) {
	this.IsPrimary = isPrimary;
	this.ContactPhone = contactPhone;
    }

    public Boolean getIsPrimary() {
	return IsPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
	this.IsPrimary = isPrimary;
    }

    public ContactPhone getContactPhone() {
	return ContactPhone;
    }

    public void setContactPhone(ContactPhone contactPhone) {
	this.ContactPhone = contactPhone;
    }

}