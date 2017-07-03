package com.znalytics.enrollment.tx.api.entity.customerlist;

public class CustomerCommercial {
    private String CompanyName;
    private String Dba;
    private Integer TaxId;

    public CustomerCommercial(String companyName, String dba, Integer taxId) {
	this.CompanyName = companyName;
	this.Dba = dba;
	this.TaxId = taxId;
    }

    public String getCompanyName() {
	return CompanyName;
    }

    public void setCompanyName(String companyName) {
	this.CompanyName = companyName;
    }

    public String getDba() {
	return Dba;
    }

    public void setDba(String dba) {
	this.Dba = dba;
    }

    public Integer getTaxId() {
	return TaxId;
    }

    public void setTaxId(Integer taxId) {
	this.TaxId = taxId;
    }

}

