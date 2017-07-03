package com.znalytics.enrollment.tx.api.entity.serviceaccount;

import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactList;
import com.znalytics.enrollment.tx.api.entity.meterlist.MeterList;

import java.util.List;

public class ServiceAccount {
    private List<AuthorizedContactList> AuthorizedContactList;
    private List<ContractDetailList> ContractDetailList;
    private List<MarketingInfo> MarketingInfo;
    private List<MeterList> MeterList;
    private TaxExemption TaxExemption;
    private ServiceAddress ServiceAddress;
    private SpecialNeedsAddress SpecialNeedsAddress;
    private List<Survey> Survey;
    private List<TransactionList> TransactionList;
    private String DivisionName;
    private Integer TradingPartner;
    private String UtilityAccountNumber;
    private String UtilityName;
    private String TaxDistrict;
    private Boolean IsLowIncome;
    private Boolean ApplyLateFees;
    private Integer LateFeeOverride;
    private String LateFeePercentOverride;
    private String TransportServiceType;
    private String GasSupplySource;
    private String MonthlyAvgDailyUse;
    private String ServiceDeliveryPoint;
    private Boolean IsAggregation;
    private String ServiceType;
    private Boolean IsSolar;
    private String AggregationType;
    private String AggregationCode;
    private String ParticipatingInterest;
    private String NameKey;
    private String SpecialNeeds;
    private Boolean IsHumanNeeds;
    private Boolean RescissionWaiver;
    private String EnergySource;
    private String NominationGroup;
    private String PricingCategory;
    private String RateClass;
    private Boolean NotificationWaiver;
    private Boolean TempSensitiveDelivery;
    private String TransmissionService;
    private String GasMaxDailyQty;
    private String GasPoolId;
    private String GasSupplyServiceOption;
    private String GasCapacityAssignment;
    private String GasSupplyBalancing;

    public ServiceAccount() {

    }

    public ServiceAccount(List<AuthorizedContactList> authorizedContactList,
	    List<ContractDetailList> contractDetailList,
	    List<MarketingInfo> marketingInfo, List<MeterList> meterList,
	    TaxExemption taxExemption, ServiceAddress serviceAddress,
	    SpecialNeedsAddress specialNeedsAddress, List<Survey> survey,
	    List<TransactionList> transactionList, String divisionName,
	    Integer tradingPartner, String utilityAccountNumber,
	    String utilityName, String taxDistrict, Boolean isLowIncome,
	    Boolean applyLateFees, Integer lateFeeOverride,
	    String lateFeePercentOverride, String transportServiceType,
	    String gasSupplySource, String monthlyAvgDailyUse,
	    String serviceDeliveryPoint, Boolean isAggregation,
	    String serviceType, Boolean isSolar, String aggregationType,
	    String aggregationCode, String participatingInterest,
	    String nameKey, String specialNeeds, Boolean isHumanNeeds,
	    Boolean rescissionWaiver, String energySource,
	    String nominationGroup, String pricingCategory, String rateClass,
	    Boolean notificationWaiver, Boolean tempSensitiveDelivery,
	    String transmissionService, String gasMaxDailyQty,
	    String gasPoolId, String gasSupplyServiceOption,
	    String gasCapacityAssignment, String gasSupplyBalancing) {
	this.AuthorizedContactList = authorizedContactList;
	this.ContractDetailList = contractDetailList;
	this.MarketingInfo = marketingInfo;
	this.MeterList = meterList;
	this.TaxExemption = taxExemption;
	this.ServiceAddress = serviceAddress;
	this.SpecialNeedsAddress = specialNeedsAddress;
	this.Survey = survey;
	this.TransactionList = transactionList;
	this.DivisionName = divisionName;
	this.TradingPartner = tradingPartner;
	this.UtilityAccountNumber = utilityAccountNumber;
	this.UtilityName = utilityName;
	this.TaxDistrict = taxDistrict;
	this.IsLowIncome = isLowIncome;
	this.ApplyLateFees = applyLateFees;
	this.LateFeeOverride = lateFeeOverride;
	this.LateFeePercentOverride = lateFeePercentOverride;
	this.TransportServiceType = transportServiceType;
	this.GasSupplySource = gasSupplySource;
	this.MonthlyAvgDailyUse = monthlyAvgDailyUse;
	this.ServiceDeliveryPoint = serviceDeliveryPoint;
	this.IsAggregation = isAggregation;
	this.ServiceType = serviceType;
	this.IsSolar = isSolar;
	this.AggregationType = aggregationType;
	this.AggregationCode = aggregationCode;
	this.ParticipatingInterest = participatingInterest;
	this.NameKey = nameKey;
	this.SpecialNeeds = specialNeeds;
	this.IsHumanNeeds = isHumanNeeds;
	this.RescissionWaiver = rescissionWaiver;
	this.EnergySource = energySource;
	this.NominationGroup = nominationGroup;
	this.PricingCategory = pricingCategory;
	this.RateClass = rateClass;
	this.NotificationWaiver = notificationWaiver;
	this.TempSensitiveDelivery = tempSensitiveDelivery;
	this.TransmissionService = transmissionService;
	this.GasMaxDailyQty = gasMaxDailyQty;
	this.GasPoolId = gasPoolId;
	this.GasSupplyServiceOption = gasSupplyServiceOption;
	this.GasCapacityAssignment = gasCapacityAssignment;
	this.GasSupplyBalancing = gasSupplyBalancing;
    }

    public List<AuthorizedContactList> getAuthorizedContactList() {
	return AuthorizedContactList;
    }

    public void setAuthorizedContactList(
	    List<AuthorizedContactList> authorizedContactList) {
	this.AuthorizedContactList = authorizedContactList;
    }

    public List<ContractDetailList> getContractDetailList() {
	return ContractDetailList;
    }

    public void setContractDetailList(
	    List<ContractDetailList> contractDetailList) {
	this.ContractDetailList = contractDetailList;
    }

    public List<MarketingInfo> getMarketingInfo() {
	return MarketingInfo;
    }

    public void setMarketingInfo(List<MarketingInfo> marketingInfo) {
	this.MarketingInfo = marketingInfo;
    }

    public List<MeterList> getMeterList() {
	return MeterList;
    }

    public void setMeterList(List<MeterList> meterList) {
	this.MeterList = meterList;
    }

    public TaxExemption getTaxExemption() {
	return TaxExemption;
    }

    public void setTaxExemption(TaxExemption taxExemption) {
	this.TaxExemption = taxExemption;
    }

    public ServiceAddress getServiceAddress() {
	return ServiceAddress;
    }

    public void setServiceAddress(ServiceAddress serviceAddress) {
	this.ServiceAddress = serviceAddress;
    }

    public SpecialNeedsAddress getSpecialNeedsAddress() {
	return SpecialNeedsAddress;
    }

    public void setSpecialNeedsAddress(SpecialNeedsAddress specialNeedsAddress) {
	this.SpecialNeedsAddress = specialNeedsAddress;
    }

    public List<Survey> getSurvey() {
	return Survey;
    }

    public void setSurvey(List<Survey> survey) {
	this.Survey = survey;
    }

    public List<TransactionList> getTransactionList() {
	return TransactionList;
    }

    public void setTransactionList(List<TransactionList> transactionList) {
	this.TransactionList = transactionList;
    }

    public String getDivisionName() {
	return DivisionName;
    }

    public void setDivisionName(String divisionName) {
	this.DivisionName = divisionName;
    }

    public Integer getTradingPartner() {
	return TradingPartner;
    }

    public void setTradingPartner(Integer tradingPartner) {
	this.TradingPartner = tradingPartner;
    }

    public String getUtilityAccountNumber() {
	return UtilityAccountNumber;
    }

    public void setUtilityAccountNumber(String utilityAccountNumber) {
	this.UtilityAccountNumber = utilityAccountNumber;
    }

    public String getUtilityName() {
	return UtilityName;
    }

    public void setUtilityName(String utilityName) {
	this.UtilityName = utilityName;
    }

    public String getTaxDistrict() {
	return TaxDistrict;
    }

    public void setTaxDistrict(String taxDistrict) {
	this.TaxDistrict = taxDistrict;
    }

    public Boolean getIsLowIncome() {
	return IsLowIncome;
    }

    public void setIsLowIncome(Boolean isLowIncome) {
	this.IsLowIncome = isLowIncome;
    }

    public Boolean getApplyLateFees() {
	return ApplyLateFees;
    }

    public void setApplyLateFees(Boolean applyLateFees) {
	this.ApplyLateFees = applyLateFees;
    }

    public Integer getLateFeeOverride() {
	return LateFeeOverride;
    }

    public void setLateFeeOverride(Integer lateFeeOverride) {
	this.LateFeeOverride = lateFeeOverride;
    }

    public String getLateFeePercentOverride() {
	return LateFeePercentOverride;
    }

    public void setLateFeePercentOverride(String lateFeePercentOverride) {
	this.LateFeePercentOverride = lateFeePercentOverride;
    }

    public String getTransportServiceType() {
	return TransportServiceType;
    }

    public void setTransportServiceType(String transportServiceType) {
	this.TransportServiceType = transportServiceType;
    }

    public String getGasSupplySource() {
	return GasSupplySource;
    }

    public void setGasSupplySource(String gasSupplySource) {
	this.GasSupplySource = gasSupplySource;
    }

    public String getMonthlyAvgDailyUse() {
	return MonthlyAvgDailyUse;
    }

    public void setMonthlyAvgDailyUse(String monthlyAvgDailyUse) {
	this.MonthlyAvgDailyUse = monthlyAvgDailyUse;
    }

    public String getServiceDeliveryPoint() {
	return ServiceDeliveryPoint;
    }

    public void setServiceDeliveryPoint(String serviceDeliveryPoint) {
	this.ServiceDeliveryPoint = serviceDeliveryPoint;
    }

    public Boolean getIsAggregation() {
	return IsAggregation;
    }

    public void setIsAggregation(Boolean isAggregation) {
	this.IsAggregation = isAggregation;
    }

    public String getServiceType() {
	return ServiceType;
    }

    public void setServiceType(String serviceType) {
	this.ServiceType = serviceType;
    }

    public Boolean getIsSolar() {
	return IsSolar;
    }

    public void setIsSolar(Boolean isSolar) {
	this.IsSolar = isSolar;
    }

    public String getAggregationType() {
	return AggregationType;
    }

    public void setAggregationType(String aggregationType) {
	this.AggregationType = aggregationType;
    }

    public String getAggregationCode() {
	return AggregationCode;
    }

    public void setAggregationCode(String aggregationCode) {
	this.AggregationCode = aggregationCode;
    }

    public String getParticipatingInterest() {
	return ParticipatingInterest;
    }

    public void setParticipatingInterest(String participatingInterest) {
	this.ParticipatingInterest = participatingInterest;
    }

    public String getNameKey() {
	return NameKey;
    }

    public void setNameKey(String nameKey) {
	this.NameKey = nameKey;
    }

    public String getSpecialNeeds() {
	return SpecialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
	this.SpecialNeeds = specialNeeds;
    }

    public Boolean getIsHumanNeeds() {
	return IsHumanNeeds;
    }

    public void setIsHumanNeeds(Boolean isHumanNeeds) {
	this.IsHumanNeeds = isHumanNeeds;
    }

    public Boolean getRescissionWaiver() {
	return RescissionWaiver;
    }

    public void setRescissionWaiver(Boolean rescissionWaiver) {
	this.RescissionWaiver = rescissionWaiver;
    }

    public String getEnergySource() {
	return EnergySource;
    }

    public void setEnergySource(String energySource) {
	this.EnergySource = energySource;
    }

    public String getNominationGroup() {
	return NominationGroup;
    }

    public void setNominationGroup(String nominationGroup) {
	this.NominationGroup = nominationGroup;
    }

    public String getPricingCategory() {
	return PricingCategory;
    }

    public void setPricingCategory(String pricingCategory) {
	this.PricingCategory = pricingCategory;
    }

    public String getRateClass() {
	return RateClass;
    }

    public void setRateClass(String rateClass) {
	this.RateClass = rateClass;
    }

    public Boolean getNotificationWaiver() {
	return NotificationWaiver;
    }

    public void setNotificationWaiver(Boolean notificationWaiver) {
	this.NotificationWaiver = notificationWaiver;
    }

    public Boolean getTempSensitiveDelivery() {
	return TempSensitiveDelivery;
    }

    public void setTempSensitiveDelivery(Boolean tempSensitiveDelivery) {
	this.TempSensitiveDelivery = tempSensitiveDelivery;
    }

    public String getTransmissionService() {
	return TransmissionService;
    }

    public void setTransmissionService(String transmissionService) {
	this.TransmissionService = transmissionService;
    }

    public String getGasMaxDailyQty() {
	return GasMaxDailyQty;
    }

    public void setGasMaxDailyQty(String gasMaxDailyQty) {
	this.GasMaxDailyQty = gasMaxDailyQty;
    }

    public String getGasPoolId() {
	return GasPoolId;
    }

    public void setGasPoolId(String gasPoolId) {
	this.GasPoolId = gasPoolId;
    }

    public String getGasSupplyServiceOption() {
	return GasSupplyServiceOption;
    }

    public void setGasSupplyServiceOption(String gasSupplyServiceOption) {
	this.GasSupplyServiceOption = gasSupplyServiceOption;
    }

    public String getGasCapacityAssignment() {
	return GasCapacityAssignment;
    }

    public void setGasCapacityAssignment(String gasCapacityAssignment) {
	this.GasCapacityAssignment = gasCapacityAssignment;
    }

    public String getGasSupplyBalancing() {
	return GasSupplyBalancing;
    }

    public void setGasSupplyBalancing(String gasSupplyBalancing) {
	this.GasSupplyBalancing = gasSupplyBalancing;
    }

}
