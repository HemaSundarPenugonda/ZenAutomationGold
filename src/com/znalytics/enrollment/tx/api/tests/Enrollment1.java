package com.znalytics.enrollment.tx.api.tests;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.znalytics.framework.core.Constants;
import com.znalytics.framework.core.Cuanto;
import com.znalytics.framework.core.DataSource;
import com.znalytics.framework.core.Logs;
import com.znalytics.framework.core.TxtDataEngine;
import com.znalytics.framework.core.XLReader;
import com.znalytics.framework.utility.Utils;

public class Enrollment1 {
    public static Hashtable<String, String> app;
    public static Hashtable<String, String> css;
    private String testType;

    // row start and end initialization

    public static int clStart = 1, clEnd = 1;
    public static int baStart = 1, baEnd = 1;
    public static int saStart = 1, saEnd = 1;
    public static int mlStart = 1, mlEnd = 1;
    public static int crslStart = 2, crslEnd = 2;

    public Enrollment1() {
	System.out.println("Enrollment default Constructor called");
	Logs.LOGGER.info("Loading data for: " + Constants.CURRENT_TESTING);
	System.out.println("Constants.CURRENT_TESTING= "
		+ Constants.CURRENT_TESTING);
	Enrollment1.app = TxtDataEngine.readTxtFile(DataSource.globalConfig
		.get(Constants.CURRENT_TESTING + ".properties"));
	System.out.println("Enrollment.app= " + Enrollment1.app);
	Enrollment1.css = TxtDataEngine.readTxtFile(DataSource.globalConfig
		.get(Constants.CURRENT_TESTING + ".object.repo"));

    }

    public void loadData() {
	System.out.println("Enrollment loadData default Constructor called");
	Logs.LOGGER.info("Starting test --> " + Constants.CURRENT_CLIENT
		+ " : " + Constants.CURRENT_TESTING);
	this.testType = app.get("test.type");
	Logs.LOGGER.info(Constants.CURRENT_TESTING + " test type: " + testType);
	System.out.println(Constants.CURRENT_TESTING + " test type: "
		+ testType);
	try {
	    if (this.testType.toLowerCase().equals("smoke")) {
		// Add Below method
		// generateTestNGXML(this.testType);
	    } else {
		List<String> getAllModule = new ArrayList<String>();
		String[][] xlData = XLReader.getEntireData(
			DataSource.globalConfig.get(Constants.CURRENT_TESTING
				+ ".datasheet"), "Scenario");
		String[][] moduleToRun = XLReader.getValidTestData(xlData);
		for (int rowItterate = 0; rowItterate < moduleToRun.length; rowItterate++) {
		    getAllModule.add(moduleToRun[rowItterate][2]);
		}
		System.out.println("this.testType= " + this.testType);
		System.out.println("getAllModule= " + getAllModule);

		generateRegTestNGXML(this.testType, getAllModule);
	    }
	} catch (Exception e) {
	    Logs.LOGGER.log(Level.SEVERE,
		    "Something bad happened while creating TestNG.xml.", e);
	}
    }

    public void generateTestNGXML(String testType) {

    }

    public void generateRegTestNGXML(String testType, List<String> scenarioName) {
	Constants.TESTOUTPUT = Constants.TMP + "/" + Utils.getToday() + "/"
		+ Constants.CURRENT_TESTING + "_" + testType + "/";
	try {
	    // suite.
	    XmlSuite suiteRegression = new XmlSuite();
	    suiteRegression.setName(Constants.CURRENT_TESTING);
	    suiteRegression.setPreserveOrder("true");
	    suiteRegression.setVerbose(1);
	    if (Utils.containsIgnoreCase(scenarioName,
		    "EnrollNewCommercialCustomer")) {
		System.out.println("Testing Enrollment Scenario");
		XmlTest regressionTestEnrollmentAPI = new XmlTest(
			suiteRegression);

		// Add Parameter
		regressionTestEnrollmentAPI.setPreserveOrder("true");
		regressionTestEnrollmentAPI.setVerbose(1);
		// Add listener
		List<String> listnerClasses = new ArrayList<String>();
		listnerClasses
			.add("com.znalytics.framework.Listener.MethodInterceptorListener");
		listnerClasses
			.add("com.znalytics.framework.Listener.TestNGListener");
		suiteRegression.setListeners(listnerClasses);

		// Define test node
		regressionTestEnrollmentAPI
			.setName("Znalytics Execution Report - "
				+ Constants.CURRENT_TESTING + " "
				+ this.testType.toLowerCase()
				+ " Enrollment API Test");

		// get the class names for field Validation for Smoke Search
		// Product
		List<XmlClass> classes = new ArrayList<XmlClass>();
		// get list of valid class names for running the smoke tests for
		// search product
		classes = new ArrayList<XmlClass>();
		Constants.DATAFILE = DataSource.globalConfig
			.get(Constants.CURRENT_TESTING + ".datasheet");
		classes.add(new XmlClass(
			"com.znalytics.enrollment.tx.api.tests.EnrollmentApiTests"));

		regressionTestEnrollmentAPI.setXmlClasses(classes);

		// Set the Groups
		List<String> groups = new ArrayList<String>();
		groups.add(Constants.CURRENT_CLIENT);
		regressionTestEnrollmentAPI.setIncludedGroups(groups);
	    }

	    // Save the suite.
	    List<XmlSuite> suites = new ArrayList<XmlSuite>();
	    suites.add(suiteRegression);

	    // Save the file for reference.
	    String testNGXML = Constants.TMPDIR + "/"
		    + this.getClass().getSimpleName() + "_"
		    + Utils.getUniqueName() + ".xml";
	    FileWriter writer = new FileWriter(new File(testNGXML));
	    writer.write(suiteRegression.toXml());
	    writer.flush();
	    writer.close();

	    // log the xml into log file.
	    Logs.LOGGER.info(suiteRegression.toXml());

	    DataSource.report.add(Constants.TESTOUTPUT + ";"
		    + suiteRegression.toXml() + ";" + Constants.CURRENT_TESTING
		    + ";" + testType + ";" + app.get("test.url"));
	    DataSource.report.trimToSize();

	    TestNG testng = new TestNG();
	    testng.setOutputDirectory(Constants.TESTOUTPUT);
	    testng.addListener(new Cuanto().getCuantoListener());
	    testng.setXmlSuites(suites);
	    System.out.println("Before testng.run method");
	    testng.run();
	    System.out.println("AFter testng.run method");
	    System.out.println("AFter testng.run method");
	} catch (Exception e) {
	    Logs.LOGGER.log(Level.SEVERE, "Problem in generating XML file.", e);
	}
    }

}
