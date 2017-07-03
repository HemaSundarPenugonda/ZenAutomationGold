package com.znalytics.enrollment.tx.api.entity.customerlist;

import java.util.List;

public class MainJson {
    private String SaleType;
    private Boolean CreateParent;
    private Integer ParentCustomerNumber;
    private List<CustomerList> CustomerList;

    public MainJson() {
    }

    public MainJson(String saleType, Boolean createParent,
	    Integer parentCustomerNumber, List<CustomerList> customerList) {
	this.SaleType = saleType;
	this.CreateParent = createParent;
	this.ParentCustomerNumber = parentCustomerNumber;
	this.CustomerList = customerList;
    }

    public String getSaleType() {
	return SaleType;
    }

    public void setSaleType(String saleType) {
	this.SaleType = saleType;
    }

    public Boolean getCreateParent() {
	return CreateParent;
    }

    public void setCreateParent(Boolean createParent) {
	this.CreateParent = createParent;
    }

    public Integer getParentCustomerNumber() {
	return ParentCustomerNumber;
    }

    public void setParentCustomerNumber(Integer parentCustomerNumber) {
	this.ParentCustomerNumber = parentCustomerNumber;
    }

    public List<CustomerList> getCustomerList() {
	return CustomerList;
    }

    public void setCustomerList(List<CustomerList> customerList) {
	this.CustomerList = customerList;
    }

}

