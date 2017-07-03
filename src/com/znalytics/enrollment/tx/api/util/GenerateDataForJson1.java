package com.znalytics.enrollment.tx.api.util;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.znalytics.enrollment.tx.api.entity.billingaccount.BillingAccount;
import com.znalytics.enrollment.tx.api.entity.billingaccount.ContractList;
import com.znalytics.enrollment.tx.api.entity.billingaccount.MailAddress;
import com.znalytics.enrollment.tx.api.entity.billingaccount.SecondaryNotificationAddress;
import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactList;
import com.znalytics.enrollment.tx.api.entity.customerlist.CustomerCommercial;
import com.znalytics.enrollment.tx.api.entity.customerlist.CustomerIndividual;
import com.znalytics.enrollment.tx.api.entity.customerlist.CustomerList;
import com.znalytics.enrollment.tx.api.entity.customerlist.LegalAddress;
import com.znalytics.enrollment.tx.api.entity.customerlist.MainJson;
import com.znalytics.enrollment.tx.api.entity.meterlist.MeterList;
import com.znalytics.enrollment.tx.api.entity.meterlist.MeterOwnerEntity;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ContractDetailList;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ContractRateSchedule;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ContractRateSegmentList;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ContractSegmentDetailList;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.MarketingInfo;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ServiceAccount;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ServiceAddress;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.SpecialNeedsAddress;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.Survey;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.TaxExemption;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.TransactionList;

public class GenerateDataForJson1 {

    private MainJson mainJson;
    private CustomerList customerList;
    private BillingAccount billingAccount;
    private ContractList contractList;
    private ServiceAccount serviceAccount;
    private ServiceAddress serviceAddress;
    private TransactionList transactionList;
    private TaxExemption taxExemption;
    private MeterList meterList;
    private MeterOwnerEntity meterOwnerEntity;
    private ContractRateSchedule contractRateSchedule;
    private ContractRateSegmentList contractRateSegmentList;
    private ContractSegmentDetailList contractSegmentDetailList;

    public MainJson generateDataForMainJson(Sheet sheet, int row, int col,
	    List<CustomerList> custList) {
	mainJson = new MainJson();
	try {
	    mainJson.setSaleType(getStringValue(sheet, row, col));
	    mainJson.setCreateParent(getBooleanValue(sheet, row, col = col + 1));
	    mainJson.setParentCustomerNumber(getIntegerValue(sheet, row,
		    col = col + 1));

	    mainJson.setCustomerList(custList);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return mainJson;
    }

    public CustomerList generateDataForCustomerList(Sheet sheet, int row,
	    int col, List<AuthorizedContactList> authorizedContactList,
	    List<BillingAccount> billingAccount,
	    CustomerCommercial customerCommercial,
	    CustomerIndividual customerIndividual, LegalAddress legalAddress) {
	customerList = new CustomerList();
	String cName = null;
	try {
	    customerList.setAuthorizedContactList(authorizedContactList);
	    customerList.setBillingAccount(billingAccount);
	    customerList.setCustomerCommercial(customerCommercial);
	    customerList.setCustomerIndividual(customerIndividual);
	    customerList.setLegalAddress(legalAddress);
	    customerList.setCustomerType(getStringValue(sheet, row, col));
	    customerList.setLanguage(getStringValue(sheet, row, col = col + 1));
	    customerList.setCustomerNumber(getIntegerValue(sheet, row,
		    col = col + 1));
	    cName = getStringValue(sheet, row, col = col + 1);

	    if (!cName.equalsIgnoreCase("blank")) {
		customerList.setCustomerName(cName);
	    } else {
		customerList.setCustomerName("ZAutoCust_dateTimeStamp");
	    }
	    //customerList.setCustomerName(CreateJson.CustomerName);
	    customerList.setPassCode(getStringValue(sheet, row, col = col + 1));
	    customerList.setIsVIP(getBooleanValue(sheet, row, col = col + 1));
	    customerList.setCustomerSegment(getStringValue(sheet, row,
		    col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return customerList;
    }

    public BillingAccount generateDataForBillingAccount(Sheet sheet, int row,
	    int col, List<AuthorizedContactList> authorizedContactList,
	    List<ContractList> contractList, MailAddress mailAddress,
	    SecondaryNotificationAddress secondaryNotificationAddress,
	    List<ServiceAccount> serviceAccount) {
	billingAccount = new BillingAccount();
	try {
	    billingAccount.setAuthorizedContactList(authorizedContactList);
	    billingAccount.setContractList(contractList);
	    billingAccount.setMailAddress(mailAddress);
	    billingAccount
		    .setSecondaryNotificationAddress(secondaryNotificationAddress);
	    billingAccount.setServiceAccount(serviceAccount);
	    billingAccount.setBillFormatName(getStringValue(sheet, row, col));
	    billingAccount.setBillTypeName(getStringValue(sheet, row,
		    col = col + 1));
	    billingAccount.setBillingAccountNumber(getStringValue(sheet, row,
		    col = col + 1));
	    billingAccount.setContractSource(getStringValue(sheet, row,
		    col = col + 1));
	    billingAccount
		    .setBillDate(getStringValue(sheet, row, col = col + 1));
	    billingAccount.setPaymentTermOverride(getStringValue(sheet, row,
		    col = col + 1));
	    // billingAccount.setSoldDate(getStringValue(sheet, row, col = col +
	    // 1));
	    billingAccount.setSoldDate(CreateJson.SoldDate);
	    billingAccount.setDocumentDeliveryMethod(getStringValue(sheet, row,
		    col = col + 2));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return billingAccount;
    }

    public ContractList generateDataForContractList(Sheet sheet, int row,
	    int col) {
	contractList = new ContractList();
	try {
	    contractList.setContractTerm(getIntegerValue(sheet, row, col));

	    contractList.setServiceTypeName(getStringValue(sheet, row,
		    col = col + 1));
	    // contractList.setContractStartDate(getStringValue(sheet, row, col
	    // = col + 1));
	    contractList.setContractStartDate(CreateJson.ContractStartDate);
	    // contractList.setContractEndDate(getStringValue(sheet, row, col =
	    // col + 1));
	    contractList.setContractEndDate(CreateJson.ContractEndDate);
	    // contractList.setContractSignedDate(getStringValue(sheet, row, col
	    // = col + 1));
	    contractList.setContractSignedDate(CreateJson.ContractSignedDate);
	    // contractList.setContractNumber(getStringValue(sheet, row, col =
	    // col + 1));
	    contractList.setContractNumber(CreateJson.ContractNumber);
	    contractList.setIsCreditRequirement(getBooleanValue(sheet, row,
		    col = col + 5));
	    contractList
		    .setIsLateFee(getBooleanValue(sheet, row, col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return contractList;
    }

    public ServiceAccount generateDataForServiceAccount(Sheet sheet, int row,
	    int col, List<AuthorizedContactList> authorizedContactList,
	    List<ContractDetailList> contractDetailList,
	    List<MarketingInfo> marketingInfo, List<MeterList> meterList,
	    TaxExemption taxExemption, ServiceAddress serviceAddress,
	    SpecialNeedsAddress specialNeedsAddress, List<Survey> survey,
	    List<TransactionList> transactionList) {
	serviceAccount = new ServiceAccount();
	try {
	    serviceAccount.setAuthorizedContactList(authorizedContactList);
	    serviceAccount.setContractDetailList(contractDetailList);
	    serviceAccount.setMarketingInfo(marketingInfo);
	    serviceAccount.setMeterList(meterList);
	    serviceAccount.setTaxExemption(taxExemption);
	    serviceAccount.setServiceAddress(serviceAddress);
	    serviceAccount.setSpecialNeedsAddress(specialNeedsAddress);
	    serviceAccount.setSurvey(survey);
	    serviceAccount.setTransactionList(transactionList);
	    // serviceAccount.setTransactionList(transactionList);
	    serviceAccount.setDivisionName(getStringValue(sheet, row, col));
	    serviceAccount.setTradingPartner(getIntegerValue(sheet, row,
		    col = col + 1));
	    // serviceAccount.setUtilityAccountNumber(getStringValue(sheet, row,
	    // col = col + 1));
	    serviceAccount
		    .setUtilityAccountNumber(CreateJson.UtilityAccountNumber);
	    serviceAccount.setUtilityName(getStringValue(sheet, row,
		    col = col + 2));
	    serviceAccount.setTaxDistrict(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setIsLowIncome(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setApplyLateFees(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setLateFeeOverride(getIntegerValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setLateFeePercentOverride(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setTransportServiceType(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setGasSupplySource(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setMonthlyAvgDailyUse(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setServiceDeliveryPoint(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setIsAggregation(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setServiceType(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount
		    .setIsSolar(getBooleanValue(sheet, row, col = col + 1));
	    serviceAccount.setAggregationType(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setAggregationCode(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setParticipatingInterest(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount
		    .setNameKey(getStringValue(sheet, row, col = col + 1));
	    serviceAccount.setSpecialNeeds(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setIsHumanNeeds(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setRescissionWaiver(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setEnergySource(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setNominationGroup(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setPricingCategory(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setRateClass(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setNotificationWaiver(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setTempSensitiveDelivery(getBooleanValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setTransmissionService(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setGasMaxDailyQty(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setGasPoolId(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setGasSupplyServiceOption(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setGasCapacityAssignment(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAccount.setGasSupplyBalancing(getStringValue(sheet, row,
		    col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return serviceAccount;
    }

    public ServiceAddress generateDataForServiceAddress(Sheet sheet, int row,
	    int col) {
	serviceAddress = new ServiceAddress();
	try {
	    serviceAddress.setAddressTypeName(getStringValue(sheet, row, col));
	    serviceAddress.setAttentionTo(getStringValue(sheet, row,
		    col = col + 1));
	    serviceAddress
		    .setAddress1(getStringValue(sheet, row, col = col + 1));
	    serviceAddress
		    .setAddress2(getStringValue(sheet, row, col = col + 1));
	    serviceAddress
		    .setAddress3(getStringValue(sheet, row, col = col + 1));
	    serviceAddress.setCity(getStringValue(sheet, row, col = col + 1));
	    serviceAddress.setCounty(getStringValue(sheet, row, col = col + 1));
	    serviceAddress.setState(getStringValue(sheet, row, col = col + 1));
	    serviceAddress.setZip5(getStringValue(sheet, row, col = col + 1));
	    serviceAddress.setZip4(getStringValue(sheet, row, col = col + 1));
	    serviceAddress
		    .setCountry(getStringValue(sheet, row, col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return serviceAddress;
    }

    public TransactionList generateDataForTransactionList(Sheet sheet, int row,
	    int col) {
	transactionList = new TransactionList();
	try {
	    transactionList.setIsTransactionHold(getBooleanValue(sheet, row,
		    col));
	    // transactionList.setIsTransactionHold(CreateJson.IsOnHold);
	    transactionList.setHoldReasonName(getStringValue(sheet, row,
		    col = col + 1));
	    // transactionList.setScheduledTransactionReleaseDate(getStringValue(sheet,
	    // row, col = col + 1));
	    transactionList
		    .setScheduledTransactionReleaseDate(CreateJson.ScheduledTransactionReleaseDate);
	    transactionList.setTransactionRequestTypeName(getStringValue(sheet,
		    row, col = col + 2));
	    transactionList.setTransactionRequestStatusName(getStringValue(
		    sheet, row, col = col + 1));
	    // transactionList.setRequestedEffectiveDate(getStringValue(sheet,
	    // row, col = col + 1));
	    transactionList
		    .setRequestedEffectiveDate(CreateJson.RequestedEffectiveDate);
	    transactionList.setHURequestType(getStringValue(sheet, row,
		    col = col + 2));
	    // transactionList.setEstimatedEffectiveDate(getStringValue(sheet,row,
	    // col = col + 1));
	    transactionList
		    .setEstimatedEffectiveDate(CreateJson.EstimatedEffectiveDate);
	    transactionList.setAccessDescription(getStringValue(sheet, row,
		    col = col + 2));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return transactionList;
    }

    public TaxExemption generateDataForTaxExemption(Sheet sheet, int row,
	    int col) {
	taxExemption = new TaxExemption();
	try {
	    taxExemption
		    .setTaxCertificateNumber(getStringValue(sheet, row, col));
	    taxExemption.setCityTaxExemptPercent(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setCountyTaxExemptPercent(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setStateTaxExemptPercent(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setLocalTaxExemptPercent(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setGRTExemptPercent(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setPUCTaxExemptPercent(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setEffectiveDate(getStringValue(sheet, row,
		    col = col + 1));
	    taxExemption.setExpirationDate(getStringValue(sheet, row,
		    col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return taxExemption;
    }

    public MeterList generateDataForMeterList(Sheet sheet, int row, int col,
	    List<MeterOwnerEntity> meterOwnerEntity) {
	meterList = new MeterList();
	try {
	    meterList.setMeterType(getStringValue(sheet, row, col));
	    meterList.setMeterNumber(getStringValue(sheet, row, col = col + 1));
	    meterList.setIsTOU(getBooleanValue(sheet, row, col = col + 1));
	    meterList
		    .setIsUnmetered(getBooleanValue(sheet, row, col = col + 1));
	    meterList.setIsAMS(getBooleanValue(sheet, row, col = col + 1));
	    meterList.setMeterLevel(getIntegerValue(sheet, row, col = col + 1));
	    meterList.setMeterOwnerEntity(meterOwnerEntity);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return meterList;
    }

    public MeterOwnerEntity generateDataForMeterOwnerEntity(Sheet sheet,
	    int row, int col) {
	meterOwnerEntity = new MeterOwnerEntity();
	try {
	    meterOwnerEntity
		    .setMeterOwnerType(getIntegerValue(sheet, row, col));
	    meterOwnerEntity.setMeterOwnerID(getIntegerValue(sheet, row,
		    col = col + 1));
	    meterOwnerEntity.setMeterOwnerText(getStringValue(sheet, row,
		    col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return meterOwnerEntity;
    }

    public ContractRateSchedule generateDataForContractRateSchedule(
	    Sheet sheet, int row, int col,
	    List<ContractRateSegmentList> contractRateSegmentList) {
	contractRateSchedule = new ContractRateSchedule();
	try {
	    contractRateSchedule
		    .setProductCode(getStringValue(sheet, row, col));
	    contractRateSchedule.setMarket(getStringValue(sheet, row,
		    col = col + 1));
	    contractRateSchedule.setZoneName(getStringValue(sheet, row,
		    col = col + 1));
	    contractRateSchedule.setBillTypeName(getStringValue(sheet, row,
		    col = col + 1));
	    contractRateSchedule.setRateAssignmentMethodName(getStringValue(
		    sheet, row, col = col + 1));
	    contractRateSchedule.setRateScheduleTypeName(getStringValue(sheet,
		    row, col = col + 1));
	    contractRateSchedule.setNumberOfSegments(getIntegerValue(sheet,
		    row, col = col + 1));
	    contractRateSchedule.setIsApplyGasLossFactors(getBooleanValue(
		    sheet, row, col = col + 1));
	    contractRateSchedule.setIsRollupEnergyCharges(getBooleanValue(
		    sheet, row, col = col + 1));
	    contractRateSchedule.setETFCalculationTypeName(getStringValue(
		    sheet, row, col = col + 1));
	    contractRateSchedule.setETFAmount(getStringValue(sheet, row,
		    col = col + 1));
	    contractRateSchedule
		    .setContractRateSegmentList(contractRateSegmentList);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return contractRateSchedule;
    }

    public ContractRateSegmentList generateDataForContractRateSegmentList(
	    Sheet sheet, int row, int col,
	    List<ContractSegmentDetailList> contractSegmentDetailList) {
	contractRateSegmentList = new ContractRateSegmentList();
	try {
	    contractRateSegmentList
		    .setPassThroughTemplateDetail(getStringValue(sheet, row,
			    col));
	    contractRateSegmentList.setTerm(getStringValue(sheet, row,
		    col = col + 1));
	    // contractRateSegmentList.setTerm(CreateJson.Term);
	    // contractRateSegmentList.setContractStartDate(getStringValue(sheet,
	    // row, col = col + 1));
	    contractRateSegmentList
		    .setContractStartDate(CreateJson.ContractStartDate);
	    // contractRateSegmentList.setContractEndDate(getStringValue(sheet,
	    // row, col = col + 1));
	    contractRateSegmentList
		    .setContractEndDate(CreateJson.ContractEndDate);
	    contractRateSegmentList.setRateCode(getStringValue(sheet, row,
		    col = col + 3));
	    contractRateSegmentList
		    .setContractSegmentDetailList(contractSegmentDetailList);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return contractRateSegmentList;
    }

    public ContractSegmentDetailList generateDataForContractSegmentDetailList(
	    Sheet sheet, int row, int col) {
	contractSegmentDetailList = new ContractSegmentDetailList();
	try {
	    contractSegmentDetailList.setDescriptionType(getStringValue(sheet,
		    row, col));
	    contractSegmentDetailList.setRateCalculatorName(getStringValue(
		    sheet, row, col = col + 1));
	    contractSegmentDetailList.setIndexType(getStringValue(sheet, row,
		    col = col + 1));
	    contractSegmentDetailList.setRateAmount(getDoubleValue(sheet, row,
		    col = col + 1));
	    contractSegmentDetailList.setUOM(getStringValue(sheet, row,
		    col = col + 1));
	    contractSegmentDetailList.setMeterRegisterType(getStringValue(
		    sheet, row, col = col + 1));
	    contractSegmentDetailList.setBlendPercent(getIntegerValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setUsageRangeMax(getIntegerValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setUsageRangeMin(getIntegerValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setDaysRangeMax(getIntegerValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setDaysRangeMin(getIntegerValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setIsUseRateCode(getBooleanValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setIsIncludesGRT(getBooleanValue(sheet,
		    row, col = col + 1));
	    contractSegmentDetailList.setIsIncludesSalesTax(getBooleanValue(
		    sheet, row, col = col + 1));
	    contractSegmentDetailList.setIsTaxable(getBooleanValue(sheet, row,
		    col = col + 1));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return contractSegmentDetailList;
    }

    private String getStringValue(Sheet sheet, int row, int col) {
	String value = null;
	try {
	    if (sheet.getRow(row) != null) {
		if (sheet.getRow(row).getCell(col) != null) {
		    switch (sheet.getRow(row).getCell(col).getCellType()) {
		    case XSSFCell.CELL_TYPE_STRING:
			value = sheet.getRow(row).getCell(col)
				.getStringCellValue();
			if (value.equalsIgnoreCase("null")) {
			    value = null;
			}
		    }
		} else {
		    value = "blank";
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return value;
    }

    private Integer getIntegerValue(Sheet sheet, int row, int col) {
	Integer value = null;
	try {
	    if (sheet.getRow(row) != null) {
		if (sheet.getRow(row).getCell(col) != null) {
		    switch (sheet.getRow(row).getCell(col).getCellType()) {
		    case XSSFCell.CELL_TYPE_NUMERIC:
			value = (int) sheet.getRow(row).getCell(col)
				.getNumericCellValue();
		    case XSSFCell.CELL_TYPE_STRING:
			String val = sheet.getRow(row).getCell(col)
				.getStringCellValue();
			if (val.equalsIgnoreCase("null")) {
			    value = null;
			} else {
			    value = Integer.parseInt(val);
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return value;
    }

    private Double getDoubleValue(Sheet sheet, int row, int col) {
	Double value = null;
	try {
	    if (sheet.getRow(row) != null) {
		if (sheet.getRow(row).getCell(col) != null) {
		    switch (sheet.getRow(row).getCell(col).getCellType()) {
		    case XSSFCell.CELL_TYPE_NUMERIC:
			value = (Double) sheet.getRow(row).getCell(col)
				.getNumericCellValue();
		    case XSSFCell.CELL_TYPE_STRING:
			String val = sheet.getRow(row).getCell(col)
				.getStringCellValue();
			if (val.equalsIgnoreCase("null")) {
			    value = null;
			} else {
			    value = Double.parseDouble(val);
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return value;
    }

    private Boolean getBooleanValue(Sheet sheet, int row, int col) {
	Boolean value = null;
	try {
	    if (sheet.getRow(row) != null) {
		if (sheet.getRow(row).getCell(col) != null) {
		    switch (sheet.getRow(row).getCell(col).getCellType()) {
		    case XSSFCell.CELL_TYPE_BOOLEAN:
			value = sheet.getRow(row).getCell(col)
				.getBooleanCellValue();
		    case XSSFCell.CELL_TYPE_STRING:
			String val = sheet.getRow(row).getCell(col)
				.getStringCellValue();
			if (val.equalsIgnoreCase("null")) {
			    value = null;
			} else {
			    value = Boolean.parseBoolean(val);
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return value;
    }
}
