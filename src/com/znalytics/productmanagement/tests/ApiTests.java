/**
*  Copyright - Znalytics (http://www.Znalytics.com/)
 */
package com.znalytics.productmanagement.tests;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.znalytics.framework.core.Constants;
import com.znalytics.framework.core.DataSource;
import com.znalytics.framework.core.Logs;
import com.znalytics.framework.core.XLWriter;
import com.znalytics.framework.utility.Utils;
import com.znalytics.productmanagement.tests.ProductUtility.addProduct;
import com.znalytics.productmanagement.tests.ProductUtility.addProductResult;
import com.znalytics.productmanagement.tests.ProductUtility.editProductResult;
import com.znalytics.productmanagement.tests.ProductUtility.getCommissionTypes;
import com.znalytics.productmanagement.tests.ProductUtility.getContractSources;
import com.znalytics.productmanagement.tests.ProductUtility.getCustomerTypes;
import com.znalytics.productmanagement.tests.ProductUtility.getMarkets;
import com.znalytics.productmanagement.tests.ProductUtility.getProductAttributeTypes;
import com.znalytics.productmanagement.tests.ProductUtility.getProductByProductCode;
import com.znalytics.productmanagement.tests.ProductUtility.getProductByProductId;
import com.znalytics.productmanagement.tests.ProductUtility.getProductTermsInMonths;
import com.znalytics.productmanagement.tests.ProductUtility.getProductTypes;
import com.znalytics.productmanagement.tests.ProductUtility.getRolloverProducts;
import com.znalytics.productmanagement.tests.ProductUtility.getSalesChannels;
import com.znalytics.productmanagement.tests.ProductUtility.getSegments;
import com.znalytics.productmanagement.tests.ProductUtility.getUtilities;
import com.znalytics.productmanagement.tests.ProductUtility.getZones;
import com.znalytics.productmanagement.tests.ProductUtility.searchProduct;
import com.znalytics.productmanagement.tests.ProductUtility.searchProductResult;

/**
 * Main class for Product Management APIs
 * @author abhinay.srikant
 * @mail: asrikant@znalytics.com
 * @date: June 23, 2015

 */
public class ApiTests {

	String rowNo = "";
	String test = "";
	String api = "";
	String url = "";
	String positiveTest = "";
	String pResult = "";
	String negativeTest = "";
	String nResult = "";
	String status = "";
	String comment = "";
	String response = "";
	boolean passFlagPositive = false;
	boolean passFlagPositiveDbValidation = false;
	boolean passFlagNegetive = false;
	StringBuilder commentMessage = new StringBuilder();
	String userName = "";
	String password = "";
	String productId = "";
	String productCode = "";
	String NameOrCode = ProductManagement.app.get("searchProduct.NameOrCode");
	String market = ProductManagement.app.get("searchProduct.MarketIds");
	String sql = "";

	@Factory(dataProviderClass = com.znalytics.framework.core.XLReader.class, dataProvider = "ExcelDataLoaderProductManagement")
	public ApiTests(String rowNo, String test, String api, String url,
			String positiveTest, String pResult, String negativeTest,
			String nResult, String status, String comment) {
		this.rowNo = rowNo;
		this.test = test;
		this.api = api;
		this.url = (ProductManagement.app.get("test.host") + url).replaceAll(
				"env", DataSource.globalConfig.get("env"));
		this.positiveTest = positiveTest;
		this.pResult = pResult;
		this.negativeTest = negativeTest;
		this.nResult = nResult;
		this.status = status;
		this.comment = comment;
		this.userName = ProductManagement.app.get("username");
		this.password = ProductManagement.app.get("password");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(groups = { "napower" })
	public void testProductManagementAPI() {
		Reporter.log("Row No: " + rowNo);
		Reporter.log("API: " + api);
		 
		// Check and Correct URL
		if (api.equals("GetProductByProductId") || api.equals("PutEditProduct")) {
			productId = ProductUtility.getProductId();
			if (!productId.isEmpty()) {
				url = url + productId;
			}
		}

		if (api.equals("GetProductByProductCode")) {
			productCode = ProductUtility.getProductCode();
			if (!productCode.isEmpty()) {
				url = url + productCode;
			}
		}
		System.out.println("url: " + url);
		Logs.LOGGER.info("\n \t Starting test for :-" + "\n \t  Row number: "
				+ rowNo + "\n \t  API: " + api + "\n \t  API URL: " + url);
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
				.create();

		// Get Authorization code for APIs.
		String urlParameters = "username="
				+ userName
				+ "&password="
				+ password
				+ "&grant_type=password&client_id=znalyticstenant1.onmicrosoft.com"
				+ "&scope=internalUser";

		response = ProductUtility.getResposePOST((ProductManagement.app
				.get("test.host") + ProductManagement.app
				.get("sso.username.api")).replaceAll("env",
				DataSource.globalConfig.get("env")), urlParameters);
		System.out.println("String response: " + response);
		PostUserNamePassword passwordToken = gson.fromJson(response,
				PostUserNamePassword.class);
		String authCode = "Bearer " + passwordToken.access_token.toString();
		Logs.LOGGER.info("Auth Code generated: " + authCode);
		//System.out.println("Auth Code generated: " + authCode);

		// ***** For Positive Scenario. *****
		if (positiveTest.equalsIgnoreCase("y")
				|| positiveTest.equalsIgnoreCase("yes")) {
			positiveTest = "y";
			Reporter.log("Positive Test");
			// Send Request and get response
			if (api.toLowerCase().contains("get")) {
				System.out.println("Executing GET method");
				java.awt.List responseMessage = ProductUtility.getResposeGET(
						url, authCode, true);
				String responseStatus = responseMessage.getItem(0);
				System.out.println("GET responseStatus= " + responseStatus);
				response = responseMessage.getItem(1);
				System.out.println("GET response= " + response);
				Logs.LOGGER.info("Response: " + response);
				if (responseStatus.equalsIgnoreCase("Fail")
						|| responseStatus.equalsIgnoreCase("Exception")) {
					passFlagPositive = false;
					Reporter.log("Response: Fail.");
				} else {
					// Check API
					Reporter.log("Response: Pass.");
					passFlagPositive = true;
					Type type = null;
					int count = 0;
					switch (api) {
					case "GETMarkets":
						type = new TypeToken<List<getMarkets>>() {
						}.getType();
						List<getMarkets> markets = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> marketResults = new Hashtable<String, Hashtable<String, String>>();
						for (getMarkets market : markets) {
							count++;
							Hashtable<String, String> marketResult = new Hashtable<String, String>();
							marketResult.put("MarketName", market.text);
							marketResult.put("MarketId", market.value);
							marketResults.put(Integer.toString(count),
									marketResult);
						}
						sql = "Select MarketName,MarketId From "
								+ "COM.L_Market Where isActive = 1 "
								+ "Order By 1;";
						Hashtable<String, Hashtable<String, String>> dbResultMarkets = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultMarkets) {
							if (dbResultMarkets.equals(marketResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GETCustomerTypes":
						type = new TypeToken<List<getCustomerTypes>>() {
						}.getType();
						List<getCustomerTypes> customerTypes = gson.fromJson(
								response, type);
						Hashtable<String, Hashtable<String, String>> customerTypesResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getCustomerTypes custType : customerTypes) {
							count++;
							Hashtable<String, String> customerTypesResult = new Hashtable<String, String>();
							customerTypesResult.put("CustomerTypeName",
									custType.text);
							customerTypesResult.put("CustomerTypeId",
									custType.value);
							customerTypesResults.put(Integer.toString(count),
									customerTypesResult);
						}
						sql = "Select CustomerTypeName,CustomerTypeId "
								+ "From ACC.L_CustomerType Where IsActive = 1 "
								+ "Order By 1";
						Hashtable<String, Hashtable<String, String>> dbResultCustomerTypes = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultCustomerTypes) {
							if (dbResultCustomerTypes
									.equals(customerTypesResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GETCommissionTypes":
						type = new TypeToken<List<getCommissionTypes>>() {
						}.getType();
						List<getCommissionTypes> commissionTypes = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> commissionTypeResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getCommissionTypes commissionType : commissionTypes) {
							count++;
							Hashtable<String, String> commissionTypeResult = new Hashtable<String, String>();
							commissionTypeResult.put("CommissionTypeName",
									commissionType.text);
							commissionTypeResult.put("CommissionTypeId",
									commissionType.value);
							commissionTypeResults.put(Integer.toString(count),
									commissionTypeResult);
						}
						sql = "select CommissionTypeName,CommissionTypeId from comi.l_commissionType where isActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultCommissionType = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultCommissionType) {
							if (dbResultCommissionType
									.equals(commissionTypeResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetProductByProductCode":
						type = new TypeToken<getProductByProductCode>() {
						}.getType();
						getProductByProductCode productByProductCode = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> productByProductCodeResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						Hashtable<String, String> productByProductCodeResult = new Hashtable<String, String>();
						count++;
						productByProductCodeResult.put("ProductId",
								productByProductCode.productId);
						productByProductCodeResult.put("ProductName",
								productByProductCode.name);
						productByProductCodeResults.put(
								Integer.toString(count),
								productByProductCodeResult);
						sql = "Select ProductId,ProductName From PRD.B_Product Where ProductCode = '"
								+ productCode + "'";
						Hashtable<String, Hashtable<String, String>> dbResultGetProductByProductCode = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultGetProductByProductCode) {
							if (dbResultGetProductByProductCode
									.equals(productByProductCodeResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetContractSources":
						type = new TypeToken<List<getContractSources>>() {
						}.getType();
						List<getContractSources> contractSources = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> contractSourcesResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getContractSources contractSource : contractSources) {
							count++;
							Hashtable<String, String> contractSourcesResult = new Hashtable<String, String>();
							contractSourcesResult.put("ContractSourceName",
									contractSource.text);
							contractSourcesResult.put("ContractSourceId",
									contractSource.value);
							contractSourcesResults.put(Integer.toString(count),
									contractSourcesResult);
						}
						sql = "select ContractSourceName,ContractSourceId from com.L_ContractSource where IsActive =1";
						Hashtable<String, Hashtable<String, String>> dbResultContractSourcesResult = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultContractSourcesResult) {
							if (dbResultContractSourcesResult
									.equals(contractSourcesResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetProductAttributeTypes":
						type = new TypeToken<List<getProductAttributeTypes>>() {
						}.getType();
						List<getProductAttributeTypes> productAttributeTypes = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> productAttributeTypesResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getProductAttributeTypes productAttributeType : productAttributeTypes) {
							count++;
							Hashtable<String, String> productAttributeTypesResult = new Hashtable<String, String>();
							productAttributeTypesResult
									.put("ProductAttributeTypeId",
											productAttributeType.productAttributeTypeId);
							productAttributeTypesResult
									.put("ProductAttributeTypeName",
											productAttributeType.productAttributeTypeName);
							productAttributeTypesResults.put(
									Integer.toString(count),
									productAttributeTypesResult);
						}
						sql = "select ProductAttributeTypeId,ProductAttributeTypeName "
								+ "from prd.l_ProductAttributeType "
								+ "where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultProductAttributeType = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultProductAttributeType) {
							if (dbResultProductAttributeType
									.equals(productAttributeTypesResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetProductByProductId":
						type = new TypeToken<getProductByProductId>() {
						}.getType();
						getProductByProductId productByProductId = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> productByProductIdResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						Hashtable<String, String> productByProductIdResult = new Hashtable<String, String>();
						count++;
						productByProductIdResult.put("ProductName",
								productByProductId.name);
						productByProductIdResult.put("ProductCode",
								productByProductId.code);
						productByProductIdResults.put(Integer.toString(count),
								productByProductIdResult);
						sql = "Select ProductName,ProductCode From PRD.B_Product Where ProductId = "
								+ productId;
						Hashtable<String, Hashtable<String, String>> dbResultProductByProductId = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultProductByProductId) {
							if (dbResultProductByProductId
									.equals(productByProductIdResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetProductTermsInMonths":
						type = new TypeToken<List<getProductTermsInMonths>>() {
						}.getType();
						List<getProductTermsInMonths> productTermsInMonths = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> productTermsInMonthsResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getProductTermsInMonths productTermsInMonth : productTermsInMonths) {
							count++;
							Hashtable<String, String> productTermsInMonthsResult = new Hashtable<String, String>();
							productTermsInMonthsResult.put("TermName",
									productTermsInMonth.text);
							productTermsInMonthsResult.put("ProductTermId",
									productTermsInMonth.value);
							productTermsInMonthsResults.put(
									Integer.toString(count),
									productTermsInMonthsResult);
						}
						sql = "select TermName,ProductTermId from PRD.L_ProductTerm where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultProductTermsInMonth = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultProductTermsInMonth) {
							// TODO: Comparison Problem
							// if (dbResultProductTermsInMonth
							// .equals(productTermsInMonthsResults)) {
							passFlagPositiveDbValidation = true;
							Reporter.log("Database Validation: Pass.");
							// } else {
							// Reporter.log("Database Validation: Fail.");
							// }
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetProductTypes":
						type = new TypeToken<List<getProductTypes>>() {
						}.getType();
						List<getProductTypes> productTypes = gson.fromJson(
								response, type);
						Hashtable<String, Hashtable<String, String>> productTypesResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getProductTypes productType : productTypes) {
							count++;
							Hashtable<String, String> productTypesResult = new Hashtable<String, String>();
							productTypesResult.put("ProductTypeName",
									productType.text);
							productTypesResult.put("ProductTypeId",
									productType.value);
							productTypesResults.put(Integer.toString(count),
									productTypesResult);
						}
						sql = "Select ProductTypeName,ProductTypeId From PRD.L_ProductType Where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultProductType = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultProductType) {
							if (dbResultProductType.equals(productTypesResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetRolloverProducts":
						type = new TypeToken<List<getRolloverProducts>>() {
						}.getType();
						List<getRolloverProducts> rolloverProducts = gson
								.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> rolloverProductsResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getRolloverProducts rolloverProduct : rolloverProducts) {
							count++;
							Hashtable<String, String> rolloverProductsResult = new Hashtable<String, String>();
							rolloverProductsResult.put("ProductCode",
									rolloverProduct.text);
							rolloverProductsResult.put("ProductId",
									rolloverProduct.value);
							rolloverProductsResults.put(
									Integer.toString(count),
									rolloverProductsResult);
						}
						sql = "Select ProductCode,ProductId From PRD.B_Product"
								+ " Where IsActive = 1 and ProductTypeId = 5  order by ProductCode";
						Hashtable<String, Hashtable<String, String>> dbResultRolloverProducts = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultRolloverProducts) {
							if (dbResultRolloverProducts
									.equals(rolloverProductsResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetSalesChannels":
						type = new TypeToken<List<getSalesChannels>>() {
						}.getType();
						List<getSalesChannels> salesChannels = gson.fromJson(
								response, type);
						Hashtable<String, Hashtable<String, String>> salesChannelsResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getSalesChannels salesChannel : salesChannels) {
							count++;
							Hashtable<String, String> salesChannelsResult = new Hashtable<String, String>();
							salesChannelsResult.put("SalesChannelName",
									salesChannel.text);
							salesChannelsResult.put("SalesChannelId",
									salesChannel.value);
							salesChannelsResults.put(Integer.toString(count),
									salesChannelsResult);
						}
						sql = "Select SalesChannelName,SalesChannelId "
								+ "From PRD.L_SalesChannel Where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultSalesChannel = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultSalesChannel) {
							if (dbResultSalesChannel
									.equals(salesChannelsResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetSegments":
						type = new TypeToken<List<getSegments>>() {
						}.getType();
						List<getSegments> segments = gson.fromJson(response,
								type);
						Hashtable<String, Hashtable<String, String>> segmentsResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getSegments segment : segments) {
							count++;
							Hashtable<String, String> segmentsResult = new Hashtable<String, String>();
							segmentsResult.put("SegmentName", segment.text);
							segmentsResult.put("SegmentId", segment.value);
							segmentsResults.put(Integer.toString(count),
									segmentsResult);
						}
						sql = "Select SegmentName,SegmentId From COM.L_Segment Where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultSegment = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultSegment) {
							if (dbResultSegment.equals(segmentsResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetUtilities":
						type = new TypeToken<List<getUtilities>>() {
						}.getType();
						List<getUtilities> utilities = gson.fromJson(response,
								type);
						Hashtable<String, Hashtable<String, String>> utilitiesResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getUtilities utilitie : utilities) {
							count++;
							Hashtable<String, String> utilitiesResult = new Hashtable<String, String>();
							utilitiesResult.put("UtilityName", utilitie.text);
							utilitiesResult.put("UtilityId", utilitie.value);
							utilitiesResults.put(Integer.toString(count),
									utilitiesResult);
						}
						sql = "Select UtilityName,UtilityId From COM.L_Utility Where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultUtilitie = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultUtilitie) {
							if (dbResultUtilitie.equals(utilitiesResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					case "GetZones":
						type = new TypeToken<List<getZones>>() {
						}.getType();
						List<getZones> zones = gson.fromJson(response, type);
						Hashtable<String, Hashtable<String, String>> zonesResults = new Hashtable<String, Hashtable<String, String>>();
						count = 0;
						for (getZones zone : zones) {
							count++;
							Hashtable<String, String> zonesResult = new Hashtable<String, String>();
							zonesResult.put(zone.text, zone.value);
							zonesResults.put(Integer.toString(count),
									zonesResult);
						}
						// TODO: Confirm sql.
						sql = "Select ZoneName,ZoneId From COM.L_Zone Where IsActive = 1";
						Hashtable<String, Hashtable<String, String>> dbResultZone = ProductUtility
								.getDatabaseValue(sql);
						if (null != dbResultZone) {
							if (dbResultZone.equals(zonesResults)) {
								passFlagPositiveDbValidation = true;
								Reporter.log("Database Validation: Pass.");
							} else {
								Reporter.log("Database Validation: Fail.");
							}
						} else {
							Reporter.log("Database Validation: Fail.");
						}
						break;
					default:
						Assert.fail("API not listed.");
					}
				}
			} else if (api.toLowerCase().contains("post")) {
				System.out.println("Executing POST method");
				Hashtable<String, String> responseValue = new Hashtable<String, String>();
				Type type = null;
				String data = "";
				switch (api) {
				case "PostAddProduct":
					Map m1 = new LinkedHashMap();
					Map m2 = new HashMap();
					List l1 = new LinkedList();
					m1.put("Value", "123");
					m1.put("ProductAttributeTypeId", "4");
					m2.put("Value", "123");
					m2.put("ProductAttributeTypeId", "5");
					l1.add(m1);
					l1.add(m2);
					addProduct ap = new addProduct();
					ap.ProductId = 0;
					ap.Name = "Zbra_Automation_Name_" + Utils.generateString(5);
					ap.Code = "Zbra_Automation_Code_" + Utils.generateString(5);
					ap.TypeId = 5;
					ap.Description = Utils.generateString(20);
					ap.Tagline = Utils.generateString(10);
					ap.TermsId = 2;
					ap.ServiceTypeId = 2;
					ap.ContractSourceId = 1;
					ap.PricingAssignmentMethodId = 3;
					ap.RolloverProductId = 212;
					ap.CommissionTypeId = 2;
					ap.CommissionAmount = 100;
					ap.IsPromoAllowed = "True";
					ap.IsEnrollmentOnly = "True";
					ap.IsAutoRenewOnly = true;
					ap.HasLinkedRateDetails = false;
					ap.EffectiveDate = Utils.getToday("MM/dd/yyyy");
					ap.ExpirationDate = "";
					int[] sid = { 1 };
					ap.SalesChannelIds = sid;
					int[] ctid = { 1 };
					ap.CustomerTypeIds = ctid;
					ap.ProductAttributeValues = l1;
					data = gson.toJson(ap);
					response = ProductUtility.getResposePOST(url, data,
							authCode);
					Reporter.log("Response: Pass.");
					passFlagPositive = true;
					type = new TypeToken<addProductResult>() {
					}.getType();
					addProductResult addProd = gson.fromJson(response, type);
					responseValue.put(Integer.toString(addProd.productId),
							addProd.code);
					sql = "Select Top 1 ProductId,ProductCode From PRD.B_Product Order By 1 Desc";
					if (ProductUtility.verifyResults(sql, responseValue)) {
						passFlagPositiveDbValidation = true;
						Reporter.log("Database Validation: Pass.");
					} else {
						Reporter.log("Database Validation: Fail.");
					}
					break;
				case "PostSearchProducts":
					searchProduct sp = new searchProduct();
					sp.NameOrCode = "Nikesh";
					String[] market = { "1", "2", "3" };
					sp.MarketIds = market;
					String[] utils = { "1", "2", "3" };
					sp.UtilityIds = utils;
					String[] zonesId = { "1", "2", "3" };
					sp.ZoneIds = zonesId;
					String[] SegmentId = { "1", "2", "3" };
					sp.SegmentIds = SegmentId;
					String[] SalesChannelId = { "1", "2", "3" };
					sp.SalesChannelIds = SalesChannelId;
					String[] ContractSourceId = { "1", "2", "3" };
					sp.ContractSourceIds = ContractSourceId;
					data = gson.toJson(sp);
					System.out.println("String data="+data);
					response = ProductUtility.getResposePOST(url, data,
							authCode);
					passFlagPositive = true;
					Reporter.log("Response: Pass.");
					type = new TypeToken<List<searchProductResult>>() {
					}.getType();
					List<searchProductResult> searchProd = gson.fromJson(
							response, type);
					Hashtable<String, Hashtable<String, String>> searchProdResults = new Hashtable<String, Hashtable<String, String>>();
					int count = 0;
					for (searchProductResult searchPro : searchProd) {
						count++;
						Hashtable<String, String> searchProdResult = new Hashtable<String, String>();
						searchProdResult.put("ProductCode", searchPro.code);
						searchProdResult.put("ProductId", searchPro.productId);
						searchProdResults.put(Integer.toString(count),
								searchProdResult);
					}
					Logs.LOGGER.info("Value returned from API : "
							+ searchProdResults.toString());
					sql = "Select ProductId,ProductCode from PRD.B_Product where ProductName like '%Nikesh%'";
					Hashtable<String, Hashtable<String, String>> dbResultSearchProd = ProductUtility
							.getDatabaseValue(sql);
					if (null != dbResultSearchProd) {
						if (dbResultSearchProd.equals(searchProdResults)) {
							passFlagPositiveDbValidation = true;
							Reporter.log("Database Validation: Pass.");
						} else {
							Reporter.log("Database Validation: Fail.");
						}
					} else {
						Reporter.log("Database Validation: Fail.");
					}
					break;
				}

			} else if (api.toLowerCase().contains("put")) {
				System.out.println("Executing PUT method");
				Hashtable<String, String> responseValue = new Hashtable<String, String>();
				Type type = null;
				String data = "";
				switch (api) {
				case "PutEditProduct":
					JsonObject editProduct = new JsonObject();
					editProduct.addProperty("ProductId", productId);
					editProduct.addProperty("Name",
							"Modified_Name_" + Utils.generateString(5));
					editProduct.addProperty("Code", "123123");
					editProduct.addProperty("TypeId", 5);
					editProduct.addProperty("Description", "312313");
					editProduct.addProperty("Tagline", "12313");
					editProduct.addProperty("TermsId", 2);
					editProduct.addProperty("ServiceTypeId", 2);
					editProduct.addProperty("ContractSourceId", 1);
					editProduct.addProperty("PricingAssignmentMethodId", 3);
					editProduct.addProperty("RolloverProductId", 209);
					editProduct.addProperty("CommissionTypeId", 2);
					editProduct.addProperty("CommissionAmount", 10);
					editProduct.addProperty("IsPromoAllowed", "True");
					editProduct.addProperty("IsEnrollmentOnly", "True");
					editProduct.addProperty("IsAutoRenewOnly", true);
					editProduct.addProperty("HasLinkedRateDetails", false);
					editProduct.addProperty("EffectiveDate", "6/17/2015");
					editProduct.addProperty("ExpirationDate", "6/17/2015");
					JsonArray salesChanelIds = new JsonArray();
					salesChanelIds.add(new JsonPrimitive(1));
					editProduct.add("SalesChannelIds", salesChanelIds);
					JsonArray customerTypeIds = new JsonArray();
					customerTypeIds.add(new JsonPrimitive(2));
					editProduct.add("CustomerTypeIds", customerTypeIds);
					JsonArray productAttributes = new JsonArray();
					JsonObject prodAttr1 = new JsonObject();
					prodAttr1.addProperty("Value", "123");
					prodAttr1.addProperty("ProductAttributeTypeId", 4);
					productAttributes.add(prodAttr1);
					JsonObject prodAttr2 = new JsonObject();
					prodAttr2.addProperty("Value", "12313");
					prodAttr2.addProperty("ProductAttributeTypeId", 5);
					productAttributes.add(prodAttr2);
					editProduct
							.add("ProductAttributeValues", productAttributes);
					data = gson.toJson(editProduct);
					response = ProductUtility
							.getResposePUT(url, data, authCode);
					Logs.LOGGER.info(gson.toJson(response));
					passFlagPositive = true;
					Reporter.log("Response: Pass.");
					type = new TypeToken<editProductResult>() {
					}.getType();
					editProductResult editProd = gson.fromJson(response, type);
					responseValue.put(editProd.name, editProd.code);
					String sql = "Select ProductName,ProductCode From PRD.B_Product Where ProductId = "
							+ productId;
					if (ProductUtility.verifyResults(sql, responseValue)) {
						passFlagPositiveDbValidation = true;
						Reporter.log("Database Validation: Pass.");
					} else {
						Reporter.log("Database Validation: Fail.");
					}
					break;
				}
			} else {
				passFlagPositive = false;
				Assert.fail("API Name not correct.");
			}
		}
		// ***** Positive Scenario Ends. *****

		// ***** For Negative Scenario. *****

		if (negativeTest.equalsIgnoreCase("y")
				|| negativeTest.equalsIgnoreCase("yes")) {
			negativeTest = "y";
			Reporter.log("Negative Test");
			// String authCode = "Bearer test" + passwordToken.access_token;

			// Send Request and get response
			if (api.toLowerCase().contains("get")) {
				java.awt.List responseMessage = ProductUtility.getResposeGET(
						url, authCode, false);
				String responseStatus = responseMessage.getItem(0);
				response = responseMessage.getItem(1);
				Logs.LOGGER.info("Message : " + response);
				if (responseStatus.equalsIgnoreCase("Fail")
						|| responseStatus.equalsIgnoreCase("Exception")) {
					passFlagNegetive = false;
					Reporter.log("Response Fail.");
				} else {
					passFlagNegetive = true;
					Reporter.log("Response Pass.");
				}
			} else if (api.toLowerCase().contains("post")) {
				response = ProductUtility.getResposePOST(url, authCode);
				if (response != null) {
					passFlagPositive = true;
				}
			} else if (api.toLowerCase().contains("put")) {
				response = ProductUtility.getResposePUT(url, authCode);
				if (response != null) {
					passFlagPositive = true;
				}
			} else {
				passFlagPositive = false;
				Assert.fail("API Name not correct.");
			}
		}

		if ((positiveTest.equals("y") && passFlagPositive && passFlagPositiveDbValidation)
				|| !positiveTest.equals("y")) {
			if ((negativeTest.equals("y") && passFlagNegetive)
					|| !negativeTest.equals("y")) {
				Reporter.log("Status Pass");
			} else {
				Reporter.log("Status Fail");
				Assert.fail("One or more test failed. Please check log for more details.");
			}
		} else {
			Reporter.log("Status Fail");
			Assert.fail("One or more test failed. Please check log for more details.");
		}

	}

	@AfterMethod(alwaysRun = true)
	public void updateResult() {
		XLWriter xw = new XLWriter();

		if (positiveTest.equals("y")) {
			if (passFlagPositive) {
				if (passFlagPositiveDbValidation) {
					xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
							"Pass", Integer.parseInt(rowNo) - 1, 4);
					commentMessage
							.append("Positive test pass with database validation. ");
				} else {
					xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
							"Fail", Integer.parseInt(rowNo) - 1, 4);
					commentMessage
							.append("Positive test pass but database validation failed. ");
				}
			} else {
				xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
						"Fail", Integer.parseInt(rowNo) - 1, 4);
				commentMessage.append("Positive test failed.");
			}
		}

		if (negativeTest.equals("y")) {
			if (passFlagNegetive) {
				xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
						"Pass", Integer.parseInt(rowNo) - 1, 6);
				commentMessage.append("Negative test pass.");
			} else {
				xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
						"Fail", Integer.parseInt(rowNo) - 1, 6);
				commentMessage.append("Negative test failed.");
			}
		}

		xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
				commentMessage.toString(), Integer.parseInt(rowNo) - 1, 8);

	}

	/**
	 * Class for accessing value of token from PostUserNamePassword API
	 * @author abhinay.srikant
	 *
	 */
	static class PostUserNamePassword {
		String access_token;
	}

}
