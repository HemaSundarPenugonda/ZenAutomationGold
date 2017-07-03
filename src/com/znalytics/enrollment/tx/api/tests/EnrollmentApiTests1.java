package com.znalytics.enrollment.tx.api.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.znalytics.enrollment.tx.api.entity.serviceaccount.ContractRateSchedule;
import com.znalytics.enrollment.tx.api.util.CreateJson;
import com.znalytics.enrollment.tx.api.util.CreateJson1;
import com.znalytics.framework.core.Constants;
import com.znalytics.framework.core.DataSource;
import com.znalytics.framework.core.Logs;
import com.znalytics.framework.core.XLWriter;
import com.znalytics.framework.utility.Utils;
import com.znalytics.productmanagement.tests.ProductUtility;

public class EnrollmentApiTests1 {

    String rowNo = "";
    String runFlag = "";
    String scenario = "";
    String positiveTest = "";
    String description = "";
    String baCount = "";
    String saCount = "";
    String mlCount = "";

    String result = "";
    String custId = "";
    String custName = "";
    String outboundTransactionId = "";

    String tokenResponse = "";
    String enrollmentResponse = "";
    boolean passFlagPositive = false;
    boolean passFlagDbValidation = false;

    StringBuilder commentMessage = new StringBuilder();
    String userName = "";
    String password = "";
    ContractRateSchedule contractRateSchedule = null;
    String CustomerId = "";
    String CustomerName = "";

    public EnrollmentApiTests1() {
	System.out.println("Inside EnrollmentApiTests EMPTY Constructor");
	this.userName = Enrollment.app.get("username");
	this.password = Enrollment.app.get("password");

    }

    @Factory(dataProviderClass = com.znalytics.framework.core.XLReader.class, dataProvider = "ExcelDataLoaderEnrollment")
    public EnrollmentApiTests1(String rowNo, String runFlag, String scenario,
	    String description, String baCount, String saCount, String mlCount,
	    String positiveTest, String result, String custId, String custName,
	    String outboundTransactionId) {

	this.rowNo = rowNo;
	this.runFlag = runFlag;
	this.scenario = scenario;
	this.description = description;
	this.baCount = baCount;
	this.saCount = saCount;
	this.mlCount = mlCount;
	this.positiveTest = positiveTest;

	this.result = result;
	this.custId = custId;
	this.custName = custName;
	this.outboundTransactionId = outboundTransactionId;
	this.userName = Enrollment.app.get("username");
	this.password = Enrollment.app.get("password");

	System.out.println("Inside EnrollmentApiTests Constructor");
	// System.out.println("Inside EnrollmentApiTests Constructor");

    }

    @Test(groups = { "napower" })
    public void testEnrollmentAPI() throws IOException {

	// EnrollmentUtility functions and othurlParametersthods will be used
	// here to test scenarios.
	System.out.println("Inside testEnrollmentAPI method");
	System.out.println("rowNo= " + rowNo);
	System.out.println("runFlag= " + runFlag);

	System.out.println("scenario= " + scenario);
	System.out.println("description= " + description);
	System.out.println("baCount= " + baCount);
	System.out.println("saCount= " + saCount);
	System.out.println("mlCount= " + mlCount);
	System.out.println("positiveTest= " + positiveTest);
	System.out.println("userName= " + userName);
	// String tokenUrl="http://qa.znergysuite.com/api/sso/v1/token";

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

	// filePath=System.getProperty("user.dir")+"/Resources/Testmodules/enrollment/enrollment091515.json";
	// String productCode="120022331";
	// String productCode=CreateJson.ProductCode;
	/*
	 * Logs.LOGGER.info("ProductCode for the test case is= " + productCode);
	 * String isActive=EnrollmentUtility.getProductIsActive(productCode);
	 * System.out.println("isActive= " + isActive); if (isActive=="1"){
	 * passFlagDbValidation=true;
	 * System.out.println("passFlagDbValidation= " + passFlagDbValidation);
	 * } else{ passFlagDbValidation=false;
	 * System.out.println("passFlagDbValidation= " + passFlagDbValidation);
	 * }
	 */

	// Get Authorization code for APIs.
	String urlParameters = "username="
		+ userName
		+ "&password="
		+ password
		+ "&grant_type=password&client_id=znalyticstenant1.onmicrosoft.com"
		+ "&scope=internalUser";

	String tokenUrl = (Enrollment.app.get("test.host") + Enrollment.app
		.get("token.api")).replaceAll("env",
		DataSource.globalConfig.get("env"));
	String enrollUrl = (Enrollment.app.get("test.host") + Enrollment.app
		.get("enrollment.api")).replaceAll("env",
		DataSource.globalConfig.get("env"));

	System.out.println("tokenUrl= " + tokenUrl);
	System.out.println("urlParameters= " + urlParameters);
	System.out.println("enrollUrl= " + enrollUrl);
	System.out.println("urlParameters= " + urlParameters);

	tokenResponse = ProductUtility.getResposePOST(tokenUrl, urlParameters);
	System.out.println("tokenResponse= " + tokenResponse);

	PostToken Token = gson.fromJson(tokenResponse, PostToken.class);
	String authCode = "Bearer " + Token.access_token.toString();
	Logs.LOGGER.info("Auth Code generated: " + authCode);
	System.out.println("authCode= " + authCode);

	String jsonFile = System.getProperty("user.dir")
		+ "/Resources/Testmodules/enrollment/Json_Generated/Enrollment"
		+ Utils.getTodayDateTime() + ".json";

	CreateJson1.buildEnrollmentJson(Enrollment.clStart, Enrollment.clEnd,
		Enrollment.baStart, Enrollment.baEnd, Enrollment.saStart,
		Enrollment.saEnd, Enrollment.mlStart, Enrollment.mlEnd,
		Enrollment.crslStart, Enrollment.crslEnd, jsonFile);

	String productCode = CreateJson.ProductCode;
	Logs.LOGGER.info("ProductCode for the test case is= " + productCode);
	System.out.println("productCode= " + productCode);
	String isActive = EnrollmentUtility.getProductIsActive(productCode);
	System.out.println("isActive= " + isActive);
	/*
	 * if (isActive.equalsIgnoreCase("1")){ passFlagDbValidation=true;
	 * System.out.println("passFlagDbValidation= " + passFlagDbValidation);
	 * } else{ passFlagDbValidation=false;
	 * System.out.println("passFlagDbValidation= " + passFlagDbValidation);
	 * }
	 */

	//CustomerName = CreateJson.CustomerName;
	//System.out.println("customerName= " + CustomerName);

	if (runFlag.toLowerCase().contains("y")) {
	    System.out.println("Executing Enrollment POST method");
	    filePath = jsonFile;
	    BufferedReader br = new BufferedReader(new FileReader(filePath));
	    JsonParser jsonParser = new JsonParser();
	    JsonObject jznObject = jsonParser.parse(br).getAsJsonObject();

	    String data = jznObject.toString();
	    System.out.println("data=" + data);

	    HttpResponse enrollmentResponseJson = EnrollmentUtility
		    .getResponsePOST(enrollUrl, data, authCode);
	    int responseStatusCode = enrollmentResponseJson.getStatusLine()
		    .getStatusCode();
	    System.out.println("responseStatusCode= " + responseStatusCode);
	    enrollmentResponse = EntityUtils.toString(
		    enrollmentResponseJson.getEntity(), "UTF-8");
	    System.out.println("enrollmentResponse as String= "
		    + enrollmentResponse);

	    CustomerId = EnrollmentUtility.getCustId(CustomerName);
	    System.out.println("CustomerId generated= " + CustomerId);
	    if (CustomerId != "") {
		passFlagDbValidation = true;
		System.out.println("passFlagDbValidation= "
			+ passFlagDbValidation);
	    } else {
		passFlagDbValidation = false;
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
	commentMessage.append("");

    }

    @AfterMethod(alwaysRun = true)
    public void updateResult() {
	XLWriter xw = new XLWriter();
	if (passFlagDbValidation) {
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Test Passed", Integer.parseInt(rowNo) - 1, 7);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    CustomerId, Integer.parseInt(rowNo) - 1, 8);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    CustomerName, Integer.parseInt(rowNo) - 1, 9);

	    commentMessage
		    .append("Enrollment test case passed and Customer Record created. ");
	} else {
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Test Failed", Integer.parseInt(rowNo) - 1, 7);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Not Created", Integer.parseInt(rowNo) - 1, 8);
	    xw.updateExcelData(Constants.DATAFILE, Constants.DATASHEET,
		    "Not Created", Integer.parseInt(rowNo) - 1, 9);
	    commentMessage.append("Enrollment test case failed. ");
	}
    }

    /**
     * Class for accessing value of token from PostUserNamePassword API
     * 
     * @author abhinay.srikant
     *
     */
    static class PostToken {
	String access_token;
    }
}
