package com.znalytics.enrollment.tx.api.entity.customerlist;

public class CustomerIndividual {
    private String DriverLicenseStateProvince;
    private String Prefix;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Suffix;
    private Boolean IsDomesticViolence;
    private Boolean IsSenior;
    private Boolean IsEmployee;
    private String MotherMaidenName;
    private Integer Last4SSN;
    private String BirthDate;
    private Integer DriverLicenseNumber;

    public CustomerIndividual() {

    }

    public CustomerIndividual(String driverLicenseStateProvince, String prefix,
	    String firstName, String middleName, String lastName,
	    String suffix, Boolean isDomesticViolence, Boolean isSenior,
	    Boolean isEmployee, String motherMaidenName, Integer last4ssn,
	    String birthDate, Integer driverLicenseNumber) {
	this.DriverLicenseStateProvince = driverLicenseStateProvince;
	this.Prefix = prefix;
	this.FirstName = firstName;
	this.MiddleName = middleName;
	this.LastName = lastName;
	this.Suffix = suffix;
	this.IsDomesticViolence = isDomesticViolence;
	this.IsSenior = isSenior;
	this.IsEmployee = isEmployee;
	this.MotherMaidenName = motherMaidenName;
	this.Last4SSN = last4ssn;
	this.BirthDate = birthDate;
	this.DriverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseStateProvince() {
	return DriverLicenseStateProvince;
    }

    public void setDriverLicenseStateProvince(String driverLicenseStateProvince) {
	this.DriverLicenseStateProvince = driverLicenseStateProvince;
    }

    public String getPrefix() {
	return Prefix;
    }

    public void setPrefix(String prefix) {
	this.Prefix = prefix;
    }

    public String getFirstName() {
	return FirstName;
    }

    public void setFirstName(String firstName) {
	this.FirstName = firstName;
    }

    public String getMiddleName() {
	return MiddleName;
    }

    public void setMiddleName(String middleName) {
	this.MiddleName = middleName;
    }

    public String getLastName() {
	return LastName;
    }

    public void setLastName(String lastName) {
	this.LastName = lastName;
    }

    public String getSuffix() {
	return Suffix;
    }

    public void setSuffix(String suffix) {
	this.Suffix = suffix;
    }

    public Boolean getIsDomesticViolence() {
	return IsDomesticViolence;
    }

    public void setIsDomesticViolence(Boolean isDomesticViolence) {
	this.IsDomesticViolence = isDomesticViolence;
    }

    public Boolean getIsSenior() {
	return IsSenior;
    }

    public void setIsSenior(Boolean isSenior) {
	this.IsSenior = isSenior;
    }

    public Boolean getIsEmployee() {
	return IsEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
	this.IsEmployee = isEmployee;
    }

    public String getMotherMaidenName() {
	return MotherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
	this.MotherMaidenName = motherMaidenName;
    }

    public Integer getLast4SSN() {
	return Last4SSN;
    }

    public void setLast4SSN(Integer last4ssn) {
	this.Last4SSN = last4ssn;
    }

    public String getBirthDate() {
	return BirthDate;
    }

    public void setBirthDate(String birthDate) {
	this.BirthDate = birthDate;
    }

    public Integer getDriverLicenseNumber() {
	return DriverLicenseNumber;
    }

    public void setDriverLicenseNumber(Integer driverLicenseNumber) {
	this.DriverLicenseNumber = driverLicenseNumber;
    }

}
