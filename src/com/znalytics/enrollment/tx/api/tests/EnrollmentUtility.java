package com.znalytics.enrollment.tx.api.tests;

import java.awt.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.znalytics.framework.core.DataBase;
import com.znalytics.framework.core.Logs;


public class EnrollmentUtility {
	public static HttpResponse response;
	static DataBase db = null;
	
	@SuppressWarnings("resource")
	public static HttpResponse getResponsePOST(String postUrl, String urlParameters,
			String your_auth_code) {	
		 
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(postUrl);
			StringEntity postingString = new StringEntity(urlParameters);
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization", your_auth_code);
			post.setHeader("Cache-Control", "no-cache");
			post.setEntity(postingString);
			response = httpClient.execute(post);
					 
			
			} catch (ClientProtocolException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
		return response;
	}
	
	public static List getResponsePOST(String url, String your_auth_code,Boolean positiveTest) {
		List messageText = new List();
		//Execute POST method and retrieve response code will go here
		return messageText;
	}
	
	 
	
	//Get the values from database for specified query.
	public static Hashtable<String, Hashtable<String, String>> getDatabaseValue(
			String sql) {
		Hashtable<String, Hashtable<String, String>> dbValue = new Hashtable<String, Hashtable<String, String>>();
		return dbValue;
	}
	
	/**
	 * Get the active product code from product table.
	 * 
	 * @return product code if found else blank string.
	 * 
	 *  Added by Prabhakar on 09/29/2015
	 */
	public static String getActiveProduct() {
		if (db == null) {
			db = new DataBase();
		}
		
		String sql = "Select Top 1 ProductCode FROM [zen.account].[PRD].[B_Product] where IsActive=1";
		
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
	/**
	 * Get the isActive value from product table for specified ProductCode.
	 * 
	 * @return isActive value.
	 * 
	 * Added by Prabhakar on 09/29/2015
	 */
	public static String getProductIsActive(String productCode) {
		if (db == null) {
			db = new DataBase();
		}
		//String sql = "Select Top 1 (ProductCode) from PRD.B_Product Order By NewId()";
		String sql = "Select IsActive from  [zen.account].[PRD].[B_Product] where ProductCode="+"'"+productCode+"'";
		//Select IsActive from  [zen.account].[PRD].[B_Product] where ProductCode='120022331'
		ResultSet rs = db.getData(sql);
		try {
			if (rs.next()) {
				return rs.getString("IsActive");
			} else {
				return "";
			}
		} catch (SQLException e) {
			Logs.LOGGER.info(e.getMessage());
		}
		return "";
	}
	
	public static String getCustId(String customerName) {
		if (db == null) {
			db = new DataBase();
		}
		
		String sql = "Select Top 1 CustomerId from crm.B_Customer where CustomerName="+"'"+customerName+"'"+"order by CreateDate desc";
		//select CustomerId from crm.B_Customer where CustomerName='ZAutoCustomer2015-09-27 12:58:38'
		ResultSet rs = db.getData(sql);
		try {
			if (rs.next()) {
				return rs.getString("CustomerId");
			} else {
				return "";
			}
		} catch (SQLException e) {
			Logs.LOGGER.info(e.getMessage());
		}
		return "";
	}
	public static boolean verifyRequestLog(String sql) {	
		 
		return false;
	}
	
	public static String getCustomerID(String CustomerName) {
		return "";
		
	}

}
