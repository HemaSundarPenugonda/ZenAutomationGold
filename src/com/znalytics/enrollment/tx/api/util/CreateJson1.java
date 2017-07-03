package com.znalytics.enrollment.tx.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.znalytics.enrollment.tx.api.entity.billingaccount.BillingAccount;
import com.znalytics.enrollment.tx.api.entity.billingaccount.ContractList;
import com.znalytics.enrollment.tx.api.entity.billingaccount.MailAddress;
import com.znalytics.enrollment.tx.api.entity.billingaccount.SecondaryNotificationAddress;
import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactEmailList;
import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactList;
import com.znalytics.enrollment.tx.api.entity.common.AuthorizedContactPhoneList;
import com.znalytics.enrollment.tx.api.entity.common.ContactEmail;
import com.znalytics.enrollment.tx.api.entity.common.ContactPhone;
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
import com.znalytics.enrollment.tx.api.tests.Enrollment;
import com.znalytics.framework.core.Constants;
import com.znalytics.framework.core.XLReader;
import com.znalytics.framework.utility.Utils;

public class CreateJson1 {
    public static String CustomerName;
    public static String ProductCode;
    public static String ContractNumber;
    public static String ContractStartDate;
    public static String ContractEndDate;
    public static String ContractSignedDate;
    public static String SoldDate;
    public static String UtilityAccountNumber;
    public static Boolean IsOnHold;
    public static String Term = "24";
    public static String ScheduledTransactionReleaseDate;
    public static String RequestedEffectiveDate;
    public static String EstimatedEffectiveDate;

    public static String Address3 = null;
    public static String County = null;

    public static void buildEnrollmentJson(int clStart, int clEnd, int baStart,
	    int baEnd, int saStart, int saEnd, int mlStart, int mlEnd,
	    int crslStart, int crslEnd, String jsonFile) {

	MainJson mJson = null;
	List<CustomerList> custList = new ArrayList<CustomerList>();
	List<AuthorizedContactList> aContactListCL = new ArrayList<AuthorizedContactList>();
	List<AuthorizedContactPhoneList> aContactPhoneListCL = new ArrayList<AuthorizedContactPhoneList>();
	ContactPhone cPhoneCL = null;
	List<AuthorizedContactEmailList> aContactEmailListCL = new ArrayList<AuthorizedContactEmailList>();
	ContactEmail cEmailCL = null;
	CustomerCommercial custCommercial = null;
	CustomerIndividual custIndividual = null;
	LegalAddress legalAdd = null;
	List<BillingAccount> billingAc = new ArrayList<BillingAccount>();
	List<AuthorizedContactList> aContactListBA = new ArrayList<AuthorizedContactList>();
	List<AuthorizedContactPhoneList> aContactPhoneListBA = new ArrayList<AuthorizedContactPhoneList>();
	ContactPhone cPhoneBA = null;
	List<AuthorizedContactEmailList> aContactEmailListBA = new ArrayList<AuthorizedContactEmailList>();
	ContactEmail cEmailBA = null;
	List<ContractList> contractList = new ArrayList<ContractList>();
	MailAddress mailingAdd = null;
	SecondaryNotificationAddress secondaryNotificationAdd = null;
	List<ServiceAccount> serviceAc = new ArrayList<ServiceAccount>();
	List<AuthorizedContactList> aContactListSA = new ArrayList<AuthorizedContactList>();
	List<AuthorizedContactPhoneList> aContactPhoneListSA = new ArrayList<AuthorizedContactPhoneList>();
	ContactPhone cPhoneSA = null;
	List<AuthorizedContactEmailList> aContactEmailListSA = new ArrayList<AuthorizedContactEmailList>();
	ContactEmail cEmailSA = null;
	List<ContractDetailList> contractDetailList = new ArrayList<ContractDetailList>();
	ContractRateSchedule contractRateSchedule = null;
	List<ContractRateSegmentList> contractRateSegmentList = new ArrayList<ContractRateSegmentList>();
	List<ContractSegmentDetailList> contractSegmentDetailList = new ArrayList<ContractSegmentDetailList>();
	List<MarketingInfo> marketingInfo = new ArrayList<MarketingInfo>();
	List<MeterList> meterList = new ArrayList<MeterList>();
	List<MeterOwnerEntity> meterOwnerEntity = new ArrayList<MeterOwnerEntity>();
	TaxExemption taxExemption = null;
	ServiceAddress serviceAddress = null;
	SpecialNeedsAddress splNeedsAddress = null;
	List<Survey> survey = new ArrayList<Survey>();
	List<TransactionList> transactionList = new ArrayList<TransactionList>();

	try {

	    FileInputStream fis = new FileInputStream(new File(
		    Constants.DATAFILE));
	    // Constants.DATAFILE=
	    // Resources/testmodules/enrollment/Enrollment.xlsx
	    String fileName = (Constants.DATAFILE).substring(33);

	    Workbook workbook = XLReader.getWorkbookObj(fis, fileName);

	    // Sheet sheetScenario = workbook.getSheetAt(0);
	    Sheet sheetCustomerList = workbook.getSheetAt(1);
	    Sheet sheetBillingAccount = workbook.getSheetAt(2);
	    Sheet sheetServiceAccount = workbook.getSheetAt(3);
	    Sheet sheetMeterList = workbook.getSheetAt(4);
	    Sheet sheetContractRateSegmentList = workbook.getSheetAt(5);

	    // int customerListRowStart = 2;
	    // int customerListRowEnd = 2;
	    // int billingAcRowStart = 2;
	    // int billingAcRowEnd = 3;
	    // int serviceAcRowStart = 2;
	    // int serviceAcRowEnd = 3;
	    // int meterListRowStart = 2;
	    // int meterListRowEnd = 3;
	    // int contractRateSegmentListRowStart = 2;
	    // int contractRateSegmentListRowEnd = 2;

	    int customerListRowStart = clStart;
	    int customerListRowEnd = clEnd;
	    int billingAcRowStart = baStart;
	    int billingAcRowEnd = baEnd;
	    int serviceAcRowStart = saStart;
	    int serviceAcRowEnd = saEnd;
	    int meterListRowStart = mlStart;
	    int meterListRowEnd = mlEnd;
	    int contractRateSegmentListRowStart = crslStart;
	    int contractRateSegmentListRowEnd = crslEnd;

	    String authContactEmailListIsPrimary = Enrollment.app
		    .get("AuthorizedContactEmailList.IsPrimary");
	    String contactEmailEmailTypeName = Enrollment.app
		    .get("EmailTypeNameLegal");
	    Boolean isPrimary = Boolean
		    .valueOf(Enrollment.app.get("IsPrimary"));
	    String emailAddress = Enrollment.app.get("EmailAddress");

	    String phoneTypeName = Enrollment.app.get("PhoneTypeName");
	    int phoneCountryCode = Integer.parseInt(Enrollment.app
		    .get("PhoneCountryCode"));
	    int phoneAreaCode = Integer.parseInt(Enrollment.app
		    .get("PhoneAreaCode"));
	    int phoneNumber = Integer.parseInt(Enrollment.app
		    .get("PhoneNumber"));
	    int phoneExtension = Integer.parseInt(Enrollment.app
		    .get("PhoneExtension"));
	    Boolean isSMSAllowed = Boolean.valueOf(Enrollment.app
		    .get("IsSMSAllowed"));
	    Boolean isDoNotCall = Boolean.valueOf(Enrollment.app
		    .get("IsDoNotCall"));

	    String contactTypeName = Enrollment.app.get("ContactTypeName");
	    String contactName = Enrollment.app.get("ContactName");
	    String birthDate = Enrollment.app.get("BirthDate");

	    String addressTypeName = Enrollment.app.get("AddressTypeName");
	    String addressTypeNameLegal = Enrollment.app
		    .get("AddressTypeNameLegal");
	    String attentionTo = Enrollment.app.get("AttentionTo");
	    String secondaryAttentionTo = Enrollment.app
		    .get("SecondaryAttentionTo");
	    String address1 = Enrollment.app.get("Address1");
	    String address2 = Enrollment.app.get("Address2");
	    // String address3 = Enrollment.app.get("Address3");
	    String city = Enrollment.app.get("City");
	    String state = Enrollment.app.get("State");
	    String zip5 = Enrollment.app.get("Zip5");
	    String zip4 = Enrollment.app.get("Zip4");
	    String country = Enrollment.app.get("Country");

	    String surveyQuestionNumber = Enrollment.app.get("QuestionNumber");
	    String surveyResponse = Enrollment.app.get("Response");

	    CustomerName = Enrollment.app.get("CustomerName")
		    + Utils.getTodayDateTime();
	    ContractNumber = Enrollment.app.get("ContractNumber")
		    + Utils.getTodayDateTime();
	    ContractSignedDate = Utils.getPreviousDateTime(5);
	    SoldDate = ContractSignedDate;
	    ContractStartDate = Utils.getNextDateTime(3);
	    ContractEndDate = Utils.getNextDateTime(733);
	    ScheduledTransactionReleaseDate = Utils.getNextDateTime(2);
	    RequestedEffectiveDate = Utils.getNextDateTime(3);
	    EstimatedEffectiveDate = RequestedEffectiveDate;

	    UtilityAccountNumber = Enrollment.app.get("UtilityAccountNumber")
		    + Utils.getTodayDateTime();
	    IsOnHold = Boolean.valueOf(Enrollment.app.get("IsOnHold"));

	    String depositAmountTypeName = null;
	    int depositAmount = 0;

	    String companyName = Enrollment.app.get("CompanyName");
	    String dba = Enrollment.app.get("Dba");
	    int taxId = Integer.parseInt(Enrollment.app.get("TaxId"));

	    String driverLicenseStateProvince = Enrollment.app
		    .get("DriverLicenseStateProvince");
	    String prefix = null;
	    String firstName = Enrollment.app.get("FirstName");
	    String middleName = Enrollment.app.get("MiddleName");
	    String lastName = Enrollment.app.get("LastName");
	    String suffix = null;
	    Boolean isDomesticViolence = Boolean.valueOf(Enrollment.app
		    .get("IsDomesticViolence"));
	    Boolean isSenior = Boolean.valueOf(Enrollment.app.get("IsSenior"));
	    Boolean isEmployee = Boolean.valueOf(Enrollment.app
		    .get("IsEmployee"));
	    String motherMaidenName = Enrollment.app.get("MotherMaidenName");
	    int last4SSN = Integer.parseInt(Enrollment.app.get("Last4SSN"));
	    int driverLicenseNumber = Integer.parseInt(Enrollment.app
		    .get("DriverLicenseNumber"));

	    GenerateDataForJson gs = new GenerateDataForJson();

	    for (int i = customerListRowStart; i <= customerListRowEnd; i++) {
		for (int j = billingAcRowStart; j <= billingAcRowEnd; j++) {

		    if (!aContactEmailListBA.isEmpty()) {
			aContactEmailListBA.clear();
		    }
		    if (!aContactPhoneListBA.isEmpty()) {
			aContactPhoneListBA.clear();
		    }
		    if (!aContactListBA.isEmpty()) {
			aContactListBA.clear();
		    }
		    if (!contractList.isEmpty()) {
			contractList.clear();
		    }
		    cEmailBA = new ContactEmail(contactEmailEmailTypeName,
			    isPrimary, emailAddress);
		    aContactEmailListBA.add(new AuthorizedContactEmailList(
			    isPrimary, cEmailBA));
		    cPhoneBA = new ContactPhone(phoneTypeName, isPrimary,
			    phoneCountryCode, phoneAreaCode, phoneNumber,
			    phoneExtension, isSMSAllowed, isDoNotCall);

		    aContactPhoneListBA.add(new AuthorizedContactPhoneList(
			    isPrimary, cPhoneBA));
		    aContactListBA.add(new AuthorizedContactList(
			    contactTypeName, contactName, birthDate, isPrimary,
			    isSMSAllowed, aContactPhoneListBA,
			    aContactEmailListBA));
		    contractList.add(gs.generateDataForContractList(
			    sheetBillingAccount, j, 8));
		    mailingAdd = new MailAddress(addressTypeName, attentionTo,
			    address1, address2, Address3, city, County, state,
			    zip5, zip4, country);
		    secondaryNotificationAdd = new SecondaryNotificationAddress(
			    addressTypeName, secondaryAttentionTo, address1,
			    address2, Address3, city, County, state, zip5,
			    zip4, country);

		    if (!serviceAc.isEmpty()) {
			serviceAc.clear();
		    }
		    for (int k = serviceAcRowStart; k <= serviceAcRowEnd; k++) {

			if (!aContactListSA.isEmpty()) {
			    aContactListSA.clear();
			}
			if (!aContactEmailListSA.isEmpty()) {
			    aContactEmailListSA.clear();
			}
			if (!aContactPhoneListSA.isEmpty()) {
			    aContactPhoneListSA.clear();
			}
			cEmailSA = new ContactEmail(contactEmailEmailTypeName,
				isPrimary, emailAddress);
			aContactEmailListSA.add(new AuthorizedContactEmailList(
				isPrimary, cEmailSA));
			cPhoneSA = new ContactPhone(phoneTypeName, isPrimary,
				phoneCountryCode, phoneAreaCode, phoneNumber,
				phoneExtension, isSMSAllowed, isDoNotCall);
			aContactPhoneListSA.add(new AuthorizedContactPhoneList(
				isPrimary, cPhoneSA));
			aContactListSA.add(new AuthorizedContactList(
				contactTypeName, contactName, birthDate,
				isPrimary, isSMSAllowed, aContactPhoneListSA,
				aContactEmailListSA));

			if (!contractRateSegmentList.isEmpty()) {
			    contractRateSegmentList.clear();
			}
			for (int l = contractRateSegmentListRowStart; l <= contractRateSegmentListRowEnd; l++) {

			    if (!contractSegmentDetailList.isEmpty()) {
				contractSegmentDetailList.clear();
			    }
			    contractSegmentDetailList
				    .add(gs.generateDataForContractSegmentDetailList(
					    sheetContractRateSegmentList, l, 5));
			    contractRateSegmentList.add(gs
				    .generateDataForContractRateSegmentList(
					    sheetContractRateSegmentList, l, 0,
					    contractSegmentDetailList));
			}
			if (!contractDetailList.isEmpty()) {
			    contractDetailList.clear();
			}
			if (!marketingInfo.isEmpty()) {
			    marketingInfo.clear();
			}
			if (!meterList.isEmpty()) {
			    meterList.clear();
			}
			contractRateSchedule = gs
				.generateDataForContractRateSchedule(
					sheetServiceAccount, k, 0,
					contractRateSegmentList);

			contractDetailList.add(new ContractDetailList(
				ContractNumber, ContractStartDate,
				ContractEndDate, depositAmountTypeName,
				depositAmount, contractRateSchedule));

			marketingInfo.add(new MarketingInfo(false, false));

			for (int m = meterListRowStart; m <= meterListRowEnd; m++) {
			    if (!meterOwnerEntity.isEmpty()) {
				meterOwnerEntity.clear();
			    }
			    meterOwnerEntity.add(gs
				    .generateDataForMeterOwnerEntity(
					    sheetMeterList, m, 6));
			    meterList.add(gs.generateDataForMeterList(
				    sheetMeterList, m, 0, meterOwnerEntity));
			}

			if (!survey.isEmpty()) {
			    survey.clear();
			}
			if (!transactionList.isEmpty()) {
			    transactionList.clear();
			}

			taxExemption = gs.generateDataForTaxExemption(
				sheetServiceAccount, k, 11);
			serviceAddress = gs.generateDataForServiceAddress(
				sheetServiceAccount, k, 20);
			splNeedsAddress = new SpecialNeedsAddress(
				addressTypeName, attentionTo, address1,
				address2, Address3, city, County, state, zip5,
				zip4, country);
			survey.add(new Survey(surveyQuestionNumber,
				surveyResponse));
			transactionList.add(gs.generateDataForTransactionList(
				sheetServiceAccount, k, 31));
			serviceAc.add(gs.generateDataForServiceAccount(
				sheetServiceAccount, k, 40, aContactListSA,
				contractDetailList, marketingInfo, meterList,
				taxExemption, serviceAddress, splNeedsAddress,
				survey, transactionList));
		    }
		    billingAc.add(gs.generateDataForBillingAccount(
			    sheetBillingAccount, j, 0, aContactListBA,
			    contractList, mailingAdd, secondaryNotificationAdd,
			    serviceAc));
		}

		cEmailCL = new ContactEmail(contactEmailEmailTypeName,
			isPrimary, emailAddress);
		aContactEmailListCL.add(new AuthorizedContactEmailList(
			isPrimary, cEmailCL));
		cPhoneCL = new ContactPhone(phoneTypeName, isPrimary,
			phoneCountryCode, phoneAreaCode, phoneNumber,
			phoneExtension, isSMSAllowed, isDoNotCall);
		aContactPhoneListCL.add(new AuthorizedContactPhoneList(
			isPrimary, cPhoneCL));
		aContactListCL.add(new AuthorizedContactList(contactTypeName,
			contactName, birthDate, isPrimary, isSMSAllowed,
			aContactPhoneListCL, aContactEmailListCL));
		legalAdd = new LegalAddress(attentionTo, addressTypeNameLegal,
			address1, address2, Address3, city, County, state,
			zip5, zip4, country);
		custIndividual = new CustomerIndividual(
			driverLicenseStateProvince, prefix, firstName,
			middleName, lastName, suffix, isDomesticViolence,
			isSenior, isEmployee, motherMaidenName, last4SSN,
			birthDate, driverLicenseNumber);
		custCommercial = new CustomerCommercial(companyName, dba, taxId);
		custList.add(gs.generateDataForCustomerList(sheetCustomerList,
			i, 3, aContactListCL, billingAc, custCommercial,
			custIndividual, legalAdd));

		mJson = gs.generateDataForMainJson(sheetCustomerList, i, 0,
			custList);

		workbook.close();

		ProductCode = contractRateSchedule.getProductCode();

		// Gson gson=new Gson();
		Gson gson = new GsonBuilder().serializeNulls().create();
		java.lang.reflect.Type type = new TypeToken<MainJson>() {
		}.getType();
		String json = gson.toJson(mJson, type);
		try {
		    // write converted json data to a file named "file.json"
		    FileWriter writer = new FileWriter(jsonFile);
		    // FileWriter writer = new FileWriter("Enrollment.json");
		    writer.write("");
		    writer.write(json);
		    writer.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		System.out.println(json);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
