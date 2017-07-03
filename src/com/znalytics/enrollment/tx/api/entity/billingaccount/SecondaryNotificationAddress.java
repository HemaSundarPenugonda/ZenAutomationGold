package com.znalytics.enrollment.tx.api.entity.billingaccount;

public class SecondaryNotificationAddress {

    private String AddressTypeName;
    private String AttentionTo;
    private String Address1;
    private String Address2;
    private String Address3;
    private String City;
    private String County;
    private String State;
    private String Zip5;
    private String Zip4;
    private String Country;

    public SecondaryNotificationAddress() {

    }

    public SecondaryNotificationAddress(String addressTypeName,
	    String attentionTo, String address1, String address2,
	    String address3, String city, String county, String state,
	    String zip5, String zip4, String country) {
	this.AddressTypeName = addressTypeName;
	this.AttentionTo = attentionTo;
	this.Address1 = address1;
	this.Address2 = address2;
	this.Address3 = address3;
	this.City = city;
	this.County = county;
	this.State = state;
	this.Zip5 = zip5;
	this.Zip4 = zip4;
	this.Country = country;
    }

    public String getAddressTypeName() {
	return AddressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
	this.AddressTypeName = addressTypeName;
    }

    public String getAttentionTo() {
	return AttentionTo;
    }

    public void setAttentionTo(String attentionTo) {
	this.AttentionTo = attentionTo;
    }

    public String getAddress1() {
	return Address1;
    }

    public void setAddress1(String address1) {
	this.Address1 = address1;
    }

    public String getAddress2() {
	return Address2;
    }

    public void setAddress2(String address2) {
	this.Address2 = address2;
    }

    public String getAddress3() {
	return Address3;
    }

    public void setAddress3(String address3) {
	this.Address3 = address3;
    }

    public String getCity() {
	return City;
    }

    public void setCity(String city) {
	this.City = city;
    }

    public String getCounty() {
	return County;
    }

    public void setCounty(String county) {
	this.County = county;
    }

    public String getState() {
	return State;
    }

    public void setState(String state) {
	this.State = state;
    }

    public String getZip5() {
	return Zip5;
    }

    public void setZip5(String zip5) {
	this.Zip5 = zip5;
    }

    public String getZip4() {
	return Zip4;
    }

    public void setZip4(String zip4) {
	this.Zip4 = zip4;
    }

    public String getCountry() {
	return Country;
    }

    public void setCountry(String country) {
	this.Country = country;
    }

}