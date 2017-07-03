/**
 * Copyright - Znalytics (http://www.Znalytics.com/)
 */
package com.znalytics.productmanagement.tests;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.znalytics.common.pages.LoginPage;
import com.znalytics.framework.core.DataBase;
import com.znalytics.framework.core.DataSource;
import com.znalytics.framework.core.Logs;
import com.znalytics.framework.core.ScreenShot;

/**
 * Contains all common functions related to product management module.
 * 
 * @author: abhinay.srikant
 * @mail: asrikant@znalytics.com
 * @date: 4/10/2015
 */

@SuppressWarnings("deprecation")
public class ProductUtility {

	static DataBase db = null;

	/**
	 * For login into application.
	 * 
	 * @param: WebDriver
	 */
	public static void loginToApplication(WebDriver browser) {
		LoginPage login = PageFactory.initElements(browser, LoginPage.class);
		String url = ProductManagement.app.get("test.url");
		Logs.LOGGER.info("Open Url: " + ProductManagement.app.get("test.url"));
		browser.get(url);
		login.setUserName(ProductManagement.app.get("username"));
		login.setPassword(ProductManagement.app.get("password"));
		login.getSignIn().click();
		ScreenShot.capture(true);
	}

	/**
	 * Execute and return the values from APIs having GET method.
	 * 
	 * @param url
	 *            The URL of API
	 * @param your_auth_code
	 *            Authorization token
	 * @param positiveTest
	 *            Boolean value to decide positive and negative test.
	 * @return List : values of status and response of request.
	 */
	@SuppressWarnings("resource")
	public static List getResposeGET(String url, String your_auth_code,
			Boolean positiveTest) {
		List messageText = new List();
		Hashtable<String, String> headerValue = new Hashtable<String, String>();
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-type", "application/json");
		httpGet.addHeader("authorization", your_auth_code);
		httpGet.addHeader("cache-control", "no-cache");
		Header[] d = httpGet.getAllHeaders();
		for (int i = 0; i < d.length; i++) {
			headerValue.put(d[i].getName(), d[i].getValue());
		}
		Logs.LOGGER.info("Header Sent in Request : " + headerValue.toString());
		try {
			HttpResponse response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (positiveTest) {
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream inputStream = entity.getContent();
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(inputStream));
					String line;
					while ((line = reader.readLine()) != null) {
						stringBuilder.append(line);
					}
					inputStream.close();
					messageText.add("Pass");
					messageText.add(stringBuilder.toString());
				} else {
					messageText.add("Fail");
					messageText.add("Error code: " + statusCode + ". Message: "
							+ statusLine);
				}
			} else {
				if (statusCode == 200) {
					messageText.add("Fail");
					messageText.add("Returned sucess message code: "
							+ statusCode + " for negative testing.");
				} else {
					messageText.add("Pass");
					messageText.add("Error code: " + statusCode + ". Message: "
							+ statusLine);
				}
			}
		} catch (Exception e) {
			messageText.add("Exception");
			messageText.add(e.getMessage());
		}
		return messageText;
	}

	/**
	 * Execute and return the values from APIs having POST method.
	 * 
	 * @param postUrl
	 *            The URL of API
	 * @param urlParameters
	 *            Request Body
	 * @return String : The String representation of JSON response.
	 * 
	 */
	@SuppressWarnings("resource")
	public static String getResposePOST(String postUrl, String urlParameters) {
		String json = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(postUrl);
			StringEntity postingString = new StringEntity(urlParameters);
			post.setEntity(postingString);
			post.setHeader("Content-type", "application/json");
			HttpResponse response = httpClient.execute(post);
			json = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Execute and return the values from APIs having POST method.
	 * 
	 * @param postUrl
	 *            The URL of API
	 * @param urlParameters
	 *            Request Body
	 * @return String The String representation of JSON response.
	 * 
	 * @param your_auth_code
	 *            Authorization token
	 * @return String : The String representation of JSON response.
	 */
	@SuppressWarnings("resource")
	public static String getResposePOST(String postUrl, String urlParameters,
			String your_auth_code) {
		String json = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(postUrl);
			StringEntity postingString = new StringEntity(urlParameters);
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization", your_auth_code);
			post.setHeader("Cache-Control", "no-cache");
			post.setEntity(postingString);
			HttpResponse response = httpClient.execute(post);
			json = EntityUtils.toString(response.getEntity(), "UTF-8");
			System.out.println("Final json response= "+json);			 
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Execute and return the values from APIs having PUT method.
	 * 
	 * @param postUrl
	 *            The URL of API
	 * @param urlParameters
	 *            Request Body
	 * @return String : The String representation of JSON response.
	 */
	@SuppressWarnings("resource")
	public static String getResposePUT(String postUrl, String urlParameters) {
		String json = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPut post = new HttpPut(postUrl);
			StringEntity postingString = new StringEntity(urlParameters);
			post.setHeader("Content-type", "application/json");
			post.setHeader("Cache-Control", "no-cache");
			post.setEntity(postingString);
			HttpResponse response = httpClient.execute(post);
			json = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Execute and return the values from APIs having PUT method.
	 * 
	 * @param postUrl
	 *            The URL of API
	 * @param urlParameters
	 *            Request Body
	 * @param your_auth_code
	 *            Authorization token
	 * @return String : The String representation of JSON response.
	 */
	@SuppressWarnings("resource")
	public static String getResposePUT(String postUrl, String urlParameters,
			String your_auth_code) {
		String json = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPut post = new HttpPut(postUrl);
			StringEntity postingString = new StringEntity(urlParameters);
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization", your_auth_code);
			post.setHeader("Cache-Control", "no-cache");
			post.setEntity(postingString);
			HttpResponse response = httpClient.execute(post);
			json = EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Get the data from database and matches the value against response.
	 * 
	 * @param sql
	 *            The Query
	 * @param response
	 *            The API response
	 * @return true if both value matched else false.
	 */
	public static boolean verifyResults(String sql,
			Hashtable<String, String> response) {
		Hashtable<String, String> dbValue = new Hashtable<String, String>();
		if (db == null) {
			db = new DataBase();
		}
		ResultSet rs = db.getData(sql);
		try {
			while (rs.next()) {
				dbValue.put(rs.getString(1), rs.getString(2));
			}
			Logs.LOGGER.info(dbValue.toString());
		} catch (SQLException e) {
			Logs.LOGGER.info(e.getMessage());
		}
		if (dbValue.equals(response)) {
			return true;
		}
		return false;
	}

	/**
	 * Get the values from database for specified query.
	 * 
	 * @param sql
	 *            The Query
	 * @return Hashtable : with data if true, else null.
	 */
	public static Hashtable<String, Hashtable<String, String>> getDatabaseValue(
			String sql) {
		Hashtable<String, Hashtable<String, String>> dbValue = new Hashtable<String, Hashtable<String, String>>();
		if (db == null) {
			db = new DataBase();
		}
		ResultSet rs = db.getData(sql);
		try {
			int colCount = rs.getMetaData().getColumnCount();
			int rowNo = 0;
			while (rs.next()) {
				Hashtable<String, String> colValue = new Hashtable<String, String>();
				rowNo++;
				for (int i = 1; i <= colCount; i++) {
					colValue.put(rs.getMetaData().getColumnLabel(i),
							rs.getString(i));
				}
				dbValue.put(Integer.toString(rowNo), colValue);
			}
			Logs.LOGGER.info("From Database " + dbValue.toString());
			return dbValue;
		} catch (SQLException e) {
			Logs.LOGGER.info(e.getMessage());
		}
		return null;
	}

	static class getMarkets {
		String text;
		String value;
	}

	static class getCustomerTypes {
		String text;
		String value;
	}

	static class getCommissionTypes {
		String text;
		String value;
	}

	static class getContractSources {
		String text;
		String value;
	}

	static class getProductAttributeTypes {
		String productAttributeTypeId;
		String productAttributeTypeName;
	}

	static class getProductByProductId {
		String name;
		String code;
	}

	static class getProductByProductCode {
		String productId;
		String name;
	}

	static class getProductTermsInMonths {
		String text;
		String value;
	}

	static class getProductTypes {
		String text;
		String value;
	}

	static class getRolloverProducts {
		String text;
		String value;
	}

	static class getSalesChannels {
		String text;
		String value;
	}

	static class getSegments {
		String text;
		String value;
	}

	static class getUtilities {
		String text;
		String value;
	}

	static class getZones {
		String text;
		String value;
	}

	static class searchProductResult {
		String productId;
		String code;
		String name;
		String type;
		String serviceType;
		String effectiveDate;
		String isPromosAllowed;
		String expirationDate;
		String linkedRateSchedulesCount;
		String isActive;
	}

	static class searchProduct {
		String NameOrCode;
		String[] MarketIds;
		String[] UtilityIds;
		String[] ZoneIds;
		String[] SegmentIds;
		String[] SalesChannelIds;
		String[] ContractSourceIds;
	}

	static class addProduct {
		int ProductId;
		String Name;
		String Code;
		int TypeId;
		String Description;
		String Tagline;
		int TermsId;
		int ServiceTypeId;
		int ContractSourceId;
		int PricingAssignmentMethodId;
		int RolloverProductId;
		int CommissionTypeId;
		int CommissionAmount;
		String IsPromoAllowed;
		String IsEnrollmentOnly;
		boolean IsAutoRenewOnly;
		boolean HasLinkedRateDetails;
		String EffectiveDate;
		String ExpirationDate;
		int[] SalesChannelIds;
		int[] CustomerTypeIds;
		@SuppressWarnings("rawtypes")
		java.util.List ProductAttributeValues;
	}

	static class addProductResult {
		int productId;
		String name;
		String code;
	}

	static class editProductResult {
		int productId;
		String name;
		String code;
	}

	/**
	 * Get the random product id from product table.
	 * 
	 * @return product id if found else blank string.
	 */
	public static String getProductId() {
		if (db == null) {
			db = new DataBase();
		}
		String sql = "Select Top 1 (ProductId) from PRD.B_Product Order By NewId()";
		ResultSet rs = db.getData(sql);
		try {
			if (rs.next()) {
				return rs.getString("ProductId");
			} else {
				return "";
			}
		} catch (SQLException e) {
			Logs.LOGGER.info(e.getMessage());
		}
		return "";
	}

	/**
	 * Get the random product code from product table.
	 * 
	 * @return product code if found else blank string.
	 */
	public static String getProductCode() {
		if (db == null) {
			db = new DataBase();
		}
		String sql = "Select Top 1 (ProductCode) from PRD.B_Product Order By NewId()";
		ResultSet rs = db.getData(sql);
		try {
			if (rs.next()) {
				return rs.getString("ProductCode");
			} else {
				return "";
			}
		} catch (SQLException e) {
			Logs.LOGGER.info(e.getMessage());
		}
		return "";
	}

}
