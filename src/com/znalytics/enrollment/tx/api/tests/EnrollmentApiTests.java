package com.znalytics.enrollment.tx.api.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ContractRateSchedule;
import com.znalytics.enrollment.tx.api.util.CreateJson;
import com.znalytics.framework.core.Constants;
import com.znalytics.framework.core.DataSource;
import com.znalytics.framework.core.Logs;
import com.znalytics.framework.core.XLWriter;
import com.znalytics.framework.utility.Utils;
import com.znalytics.productmanagement.tests.ProductUtility;

public class EnrollmentApiTests {

    String rowNo = "";
    String runFlag = "";
    String scenario = "";
    String positiveTest = "";
    String description = "";
    String baCount = "";
    String saCount = "";
    String mlCount = "";

    String result = "";
    String failError = "";
    String custId = "";
    String custName = "";
    String outboundTransactionId = "";

    String tokenResponse = "";
    String enrollmentResponse = "";
    boolean passFlagPositive = false;
    boolean passFlagDbValidation = false;
    boolean productValidation = false;

    StringBuilder failErrorMessage = new StringBuilder();
    String qaUsername = "";
    String qaPassword = "";
    ContractRateSchedule contractRateSchedule = null;
    String CustomerId = "";
    String CustomerName = "";

    // String JsonFileName="";

    public EnrollmentApiTests() {
	// System.out.println("Inside EnrollmentApiTests EMPTY Constructor");
	this.qaUsername = Enrollment.app.get("qa.username");
	this.qaPassword = Enrollment.app.get("qa.password");

    }

    @Factory(dataProviderClass = com.znalytics.framework.core.XLReader.class, dataProvider = "ExcelDataLoaderEnrollment")
    public EnrollmentApiTests(String rowNo, String runFlag, String scenario,
	    String description, String baCount, String saCount, String mlCount,
	    String positiveTest, String result, String failError,
	    String custId, String custName, String outboundTransactionId) {

	this.rowNo = rowNo;
	this.runFlag = runFlag;
	this.scenario = scenario;
	this.description = description;
	this.baCount = baCount;
	this.saCount = saCount;
	this.mlCount = mlCount;
	this.positiveTest = positiveTest;

	this.result = result;
	this.failError = failError;
	this.custId = custId;
	this.custName = custName;
	this.outboundTransactionId = outboundTransactionId;
	this.qaUsername = Enrollment.app.get("qa.username");
	this.qaPassword = Enrollment.app.get("qa.password");

	System.out.println("Inside EnrollmentApiTests Constructor");
	System.out.println("Inside testEnrollmentAPI method");
	System.out.println("rowNo= " + rowNo);
	System.out.println("runFlag= " + runFlag);

	System.out.println("scenario= " + scenario);
	System.out.println("description= " + description);
	System.out.println("baCount= " + baCount);
	System.out.println("saCount= " + saCount);
	System.out.println("mlCount= " + mlCount);
	System.out.println("positiveTest= " + positiveTest);

    }

    @Test(groups = { "napower" })
    public void testEnrollmentAPI() throws IOException {

	System.out.println("rowNo= " + rowNo);
	System.out.println("runFlag= " + runFlag);

	// row start and end incremental based on count

	int baCnt = Integer.parseInt(baCount);
	int saCnt = Integer.parseInt(saCount);
	int mlCnt = Integer.parseInt(mlCount);

	Enrollment.clStart = Enrollment.clStart + 1;
	Enrollment.clEnd = Enrollment.clEnd + 1;
	Enrollment.baStart = Enrollment.baEnd + 1;
	Enrollment.baEnd = Enrollment.baEnd + baCnt;
	Enrollment.saStart = Enrollment.saEnd + 1;
	Enrollment.saEnd = Enrollment.saEnd + saCnt;
	Enrollment.mlStart = Enrollment.mlEnd + 1;
	Enrollment.mlEnd = Enrollment.mlEnd + mlCnt;

	Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
		.create();
	String filePath = "";
	// String username=Enrollment.app.get("username");
	// Get Authorization code for APIs.
	String urlParameters = "username="
		+ qaUsername
		+ "&password="
		+ qaPassword
		+ "&grant_type=password&client_id=znalyticstenant1.onmicrosoft.com"
		+ "&scope=internalUser";

	String tokenUrl = (Enrollment.app.get("test.host") + Enrollment.app
		.get("token.api")).replaceAll("env",
		DataSource.globalConfig.get("env"));
	String testHost = (Enrollment.app.get("test.host"));
	System.out.println("testHost=" + testHost);
	String env = (Enrollment.app.get("env"));
	System.out.println("env=" + env);
	String envGlobal = DataSource.globalConfig.get("env");
	System.out.println("envGlobal=" + envGlobal);

	String enrollUrl = (Enrollment.app.get("test.host") + Enrollment.app
		.get("enrollment.api")).replaceAll("env",
		DataSource.globalConfig.get("env"));

	System.out.println("tokenUrl= " + tokenUrl);
	System.out.println("urlParameters= " + urlParameters);
	System.out.println("enrollUrl= " + enrollUrl);
	System.out.println("urlParameters= " + urlParameters);

	tokenResponse = ProductUtility.getResposePOST(tokenUrl, urlParameters);

	// PostToken Token = gson.fromJson(tokenResponse, PostToken.class);
	// String authCode = "Bearer " + Token.access_token.toString();
	// Logs.LOGGER.info("Auth Code generated: " + authCode);

	CreateJson.buildEnrollmentJson(Enrollment.clStart, Enrollment.clEnd,
		Enrollment.baStart, Enrollment.baEnd, Enrollment.saStart,
		Enrollment.saEnd, Enrollment.mlStart, Enrollment.mlEnd,
		Enrollment.crslStart, Enrollment.crslEnd);

	String productCode = CreateJson.ProductCode;
	System.out.println("productCode= " + productCode);
	// String
	Logs.LOGGER.info("ProductCode for the test case is= " + productCode);
	// System.out.println("productCode= " + productCode);
	/*
	 * if(productCode.equalsIgnoreCase("")){
	 * productCode=EnrollmentUtility.getActiveProduct();
	 * contractRateSchedule.setProductCode(productCode);
	 * System.out.println("ProductCode WAS BLANK SO is fetched from DB and = "
	 * + productCode); String
	 * isActive=EnrollmentUtility.getProductIsActive(productCode);
	 * 
	 * System.out.println("isActive= " + isActive);
	 * System.out.println("ProductCode is not blank and value from XL = " +
	 * productCode); if (isActive.equalsIgnoreCase("1")){
	 * productValidation=true;
	 * System.out.println("Product is an active Product "); } else{
	 * productValidation=false; System.out.println(
	 * "Product is not active, Please enter a valid product. ");
	 * failErrorMessage
	 * .append("Product is not active, Please enter a valid product. ");
	 * Assert.fail("Product is not active"); } }else{
	 * System.out.println("entered ELSE condition");
	 * productCode=EnrollmentUtility.getActiveProduct();
	 * contractRateSchedule.setProductCode(productCode);
	 * System.out.println("ProductCode WAS BLANK SO is fetched from DB and = "
	 * + productCode); }
	 */
	// CustomerList custList = new CustomerList();
	CustomerName = CreateJson.JsonCustomerName;
	System.out.println("CustomerName= " + CustomerName);
	// JsonFileName=CreateJson.JsonFilePath;

	if (runFlag.toLowerCase().contains("y")) {
	    System.out.println("Executing Enrollment POST method");
	    // filePath=System.getProperty("user.dir")+"/Enrollment_2015-09-30_093816.json";
	    // BufferedReader br = new BufferedReader(new FileReader(filePath));
	    // System.out.println("CreateJson.JsonFilePath= "+CreateJson.JsonFilePath);
	    BufferedReader br = new BufferedReader(new FileReader(
		    CreateJson.JsonFilePath));
	    JsonParser jsonParser = new JsonParser();
	    JsonObject jznObject = jsonParser.parse(br).getAsJsonObject();

	    String data = jznObject.toString();
	    System.out.println("enrollUrl=" + enrollUrl);

	    // HttpResponse enrollmentResponseJson =
	    // EnrollmentUtility.getResponsePOST(enrollUrl, data,
	    // authCode);
	    // int responseStatusCode=
	    // enrollmentResponseJson.getStatusLine().getStatusCode();
	    // Logs.LOGGER.info("Enrollment API Response Code= " +
	    // responseStatusCode);
	    // System.out.println("responseStatusCode= "+responseStatusCode);
	    // enrollmentResponse =
	    // EntityUtils.toString(enrollmentResponseJson.getEntity(),
	    // "UTF-8");
	    // Logs.LOGGER.info("Enrollment Response= " + enrollmentResponse);
	    // System.out.println("enrollmentResponse as String= "+enrollmentResponse);

	    CustomerId = EnrollmentUtility.getCustId(CustomerName);
	    Logs.LOGGER.info("CustomerId generated= " + CustomerId);
	    System.out.println("CustomerId generated= " + CustomerId);
	    if (CustomerId != "") {
		passFlagDbValidation = true;
		Logs.LOGGER.info("passFlagDbValidation= "
			+ passFlagDbValidation);
		System.out.println("passFlagDbValidation= "
			+ passFlagDbValidation);
	    } else {
		passFlagDbValidation = false;
		Logs.LOGGER.info("passFlagDbValidation= "
			+ passFlagDbValidation);
		System.out.println("passFlagDbValidation= "
			+ passFlagDbValidation);
	    }

	}

    }

    @BeforeMethod(alwaysRun = true)
    public void clearResults() {

	XLWriter xw = new XLWriter();
	xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET, "",
		Integer.parseInt(rowNo) - 1, 7);
	xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET, "",
		Integer.parseInt(rowNo) - 1, 8);
	xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET, "",
		Integer.parseInt(rowNo) - 1, 9);
	xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET, "",
		Integer.parseInt(rowNo) - 1, 10);
	// failErrorMessage.append("");

    }

    @AfterMethod(alwaysRun = true)
    public void updateResult() {

	XLWriter xw = new XLWriter();

	/*
	 * String dateTime= Utils.getTodayDateTime();
	 * dateTime=dateTime.replace(":", ""); dateTime=dateTime.replace(" ",
	 * "_"); String resultsXLFileName = System.getProperty("user.dir")+
	 * "/Download/"+ "EnrollmentTestResultsXL_"+ dateTime+ ".xlsx";
	 */

	if (passFlagDbValidation) {
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Test Passed", Integer.parseInt(rowNo) - 1, 7);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    CustomerId, Integer.parseInt(rowNo) - 1, 9);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    CustomerName, Integer.parseInt(rowNo) - 1, 10);
	    // xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
	    // JsonFileName, Integer.parseInt(rowNo) - 1, 10);

	} else {
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Test Failed", Integer.parseInt(rowNo) - 1, 7);
	    failErrorMessage.append("Enrollment test case failed. ");
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Not Created", Integer.parseInt(rowNo) - 1, 9);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Not Created", Integer.parseInt(rowNo) - 1, 10);
	    // xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
	    // JsonFileName, Integer.parseInt(rowNo) - 1, 10);

	}
	xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		failErrorMessage.toString(), Integer.parseInt(rowNo) - 1, 8);

    }

    @AfterSuite(alwaysRun = true)
    public void copyResultsToXL() {
	System.out.println("AFterSUITE method executed");
	String dateTime = Utils.getTodayDateTime();
	dateTime = dateTime.replace(":", "");
	dateTime = dateTime.replace(" ", "_");
	String resultsXLFileName = System.getProperty("user.dir")
		+ "/Download/" + "EnrollmentTestResultsXL_" + dateTime
		+ ".xlsx";
	XLWriter.copyExcelFile(Constants.DATAFILE, resultsXLFileName);
    }

    /**
     * Class for accessing value of token from PostUserNamePassword API
     * 
     *
     */
    static class PostToken {
	String access_token;
    }
}
