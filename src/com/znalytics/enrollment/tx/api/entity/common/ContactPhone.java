package com.znalytics.enrollment.tx.api.entity.common;

public class ContactPhone {

    private String PhoneTypeName;
    private Boolean IsPrimary;
    private Integer PhoneCountryCode;
    private Integer PhoneAreaCode;
    private Integer PhoneNumber;
    private Integer PhoneExtension;
    private Boolean IsSMSAllowed;
    private Boolean IsDoNotCall;

    public ContactPhone() {
    }
    
    public ContactPhone(String phoneTypeName, Boolean isPrimary,
    	    Integer phoneCountryCode, Integer phoneAreaCode,
    	    Integer phoneNumber, Integer phoneExtension, Boolean isSMSAllowed
    	    ) {
    	this.PhoneTypeName = phoneTypeName;
    	this.IsPrimary = isPrimary;
    	this.PhoneCountryCode = phoneCountryCode;
    	this.PhoneAreaCode = phoneAreaCode;
    	this.PhoneNumber = phoneNumber;
    	this.PhoneExtension = phoneExtension;
    	this.IsSMSAllowed = isSMSAllowed;
    	
        }


    public ContactPhone(String phoneTypeName, Boolean isPrimary,
	    Integer phoneCountryCode, Integer phoneAreaCode,
	    Integer phoneNumber, Integer phoneExtension, Boolean isSMSAllowed,
	    Boolean isDoNotCall) {
	this.PhoneTypeName = phoneTypeName;
	this.IsPrimary = isPrimary;
	this.PhoneCountryCode = phoneCountryCode;
	this.PhoneAreaCode = phoneAreaCode;
	this.PhoneNumber = phoneNumber;
	this.PhoneExtension = phoneExtension;
	this.IsSMSAllowed = isSMSAllowed;
	this.IsDoNotCall = isDoNotCall;
    }
    
    
    public String getPhoneTypeName() {
	return PhoneTypeName;
    }

    public void setPhoneTypeName(String phoneTypeName) {
	this.PhoneTypeName = phoneTypeName;
    }

    public Boolean getIsPrimary() {
	return IsPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
	this.IsPrimary = isPrimary;
    }

    public Integer getPhoneCountryCode() {
	return PhoneCountryCode;
    }

    public void setPhoneCountryCode(Integer phoneCountryCode) {
	this.PhoneCountryCode = phoneCountryCode;
    }

    public Integer getPhoneAreaCode() {
	return PhoneAreaCode;
    }

    public void setPhoneAreaCode(Integer phoneAreaCode) {
	this.PhoneAreaCode = phoneAreaCode;
    }

    public Integer getPhoneNumber() {
	return PhoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
	this.PhoneNumber = phoneNumber;
    }

    public Integer getPhoneExtension() {
	return PhoneExtension;
    }

    public void setPhoneExtension(Integer phoneExtension) {
	this.PhoneExtension = phoneExtension;
    }

    public Boolean getIsSMSAllowed() {
	return IsSMSAllowed;
    }

    public void setIsSMSAllowed(Boolean isSMSAllowed) {
	this.IsSMSAllowed = isSMSAllowed;
    }

    public Boolean getIsDoNotCall() {
	return IsDoNotCall;
    }

    public void setIsDoNotCall(Boolean isDoNotCall) {
	this.IsDoNotCall = isDoNotCall;
    }

}
