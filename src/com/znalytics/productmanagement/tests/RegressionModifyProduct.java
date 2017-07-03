// Copyright - Znalytics (http://www.Znalytics.com/)

package com.znalytics.productmanagement.tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.znalytics.common.pages.NavigationPage;
import com.znalytics.framework.core.Constants;
import com.znalytics.framework.core.DataBase;
import com.znalytics.framework.core.DataSource;
import com.znalytics.framework.core.Logs;
import com.znalytics.framework.core.ScreenShot;
import com.znalytics.framework.core.Setup;
import com.znalytics.framework.core.XLWriter;
import com.znalytics.framework.utility.AngularDropDown;
import com.znalytics.framework.utility.Element;
import com.znalytics.framework.utility.Utils;
import com.znalytics.framework.utility.WaitUtils;
import com.znalytics.framework.utility.WebPage;
import com.znalytics.framework.utility.WebTable;
import com.znalytics.productmanagement.pages.CreateProductPage;
import com.znalytics.productmanagement.pages.SearchProductPage;

/**
 * @author: Yogi Garg
 * @mail: ygarg@znalytics.com
 * @date: May 25, 2015
 *
 */
public class RegressionModifyProduct {

	WebDriver browser = Setup.getInstance().getDriver();
	DataBase db = new DataBase();
	XLWriter xlUpdate = new XLWriter();
	NavigationPage navigate = PageFactory.initElements(browser,
			NavigationPage.class);
	CreateProductPage createProduct = PageFactory.initElements(browser,
			CreateProductPage.class);
	SearchProductPage searchProduct = PageFactory.initElements(browser,
			SearchProductPage.class);
	AngularDropDown DropDown = new AngularDropDown();
	// Product related values.
	String pdSrno;
	String pdCode;
	String pdName;
	String pdDescription;
	String pdTagLine;
	String pdEffictiveDate;
	String pdExpDate;
	boolean pdNoExpDate;
	String pdContractSource;
	String pdType;
	String pdServiceType;
	String pdPricingAssignMethod;
	String pdRolloverProduct;
	String pdTermsInMonths;
	String pdPromoAllowed;
	String pdEnrollmentOnly;
	String pdAutoRenewOnly;
	String pdGuaranteedSavings;
	String pdRenewables;
	String pdSalesChannels;
	String pdCustomerTypes;
	String pdCommissionType;
	String pdCommissionAmount;
	String pdProductID;
	String pdUtility;
	String pdMarketName;
	String pdZoneName;
	WebTable webTabLocked = new WebTable(searchProduct.getWebTableLocked(),
			browser);
	StringBuilder pass = new StringBuilder();
	StringBuilder fail = new StringBuilder();
	String eol = System.getProperty("line.separator");

	@Factory(dataProviderClass = com.znalytics.framework.core.XLReader.class, dataProvider = "ExcelDataLoaderProductManagement")
	public RegressionModifyProduct(String srno, String runFlag,
			String productID, String status, String pdCode, String pdName,
			String pdDescription, String pdTagLine, String pdEffictiveDate,
			String pdExpDate, String pdContractSource, String pdType,
			String pdServiceType, String pdPricingAssignMethod,
			String pdRolloverProduct, String pdTermsInMonths,
			String pdPromoAllowed, String pdEnrollmentOnly,
			String pdAutoRenewOnly, String pdGuaranteedSavings,
			String pdRenewables, String pdSalesChannels,
			String pdCustomerTypes, String pdCommissionType,
			String pdCommissionAmount) {
		this.pdProductID = productID;
		this.pdSrno = srno;
		this.pdCode = pdCode;
		if (this.pdCode.equalsIgnoreCase("")) {
			this.pdCode = "Zbra_ProductCode" + Utils.getUniqueName();
		}

		this.pdName = pdName;
		if (pdName.equalsIgnoreCase("")) {
			this.pdName = "Zbra_ProductName" + Utils.getUniqueName();
		}
		this.pdDescription = pdDescription;
		if (pdDescription.equalsIgnoreCase("")) {
			this.pdDescription = "Zbra_ProductDescription"
					+ Utils.getUniqueName();
		}
		this.pdTagLine = pdTagLine;
		if (pdTagLine.equalsIgnoreCase("")) {
			this.pdTagLine = Utils.generateString(10);
		}
		String dateInString = pdEffictiveDate;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		if (pdEffictiveDate.equalsIgnoreCase("")) {
			this.pdEffictiveDate = Utils.getToday("MM/dd/YYYY");
		} else {
			this.pdEffictiveDate = pdEffictiveDate;
			try {
				formatter.parse(dateInString);
			} catch (Exception e) {
				throw new SkipException(
						"Effective date is not set in correct format , it should be MM/dd/YYYY format."
								+ e.getMessage());
			}
		}
		this.pdExpDate = pdExpDate;
		if (pdExpDate.equals("")) {
			this.pdNoExpDate = true;
		} else {
			dateInString = this.pdExpDate;
			try {
				formatter.parse(dateInString);
			} catch (Exception e) {
				throw new SkipException(
						"Expiration date is not set in correct format , it should be MM/dd/YYYY format."
								+ e.getMessage());
			}
		}
		this.pdContractSource = pdContractSource;
		this.pdType = pdType;
		this.pdServiceType = pdServiceType;
		this.pdPricingAssignMethod = pdPricingAssignMethod;
		this.pdRolloverProduct = pdRolloverProduct;
		this.pdTermsInMonths = pdTermsInMonths;
		if (pdPromoAllowed.equalsIgnoreCase("true")
				|| pdPromoAllowed.equalsIgnoreCase("false")
				|| pdPromoAllowed.equalsIgnoreCase("")) {
			this.pdPromoAllowed = pdPromoAllowed;
		} else {
			throw new SkipException(
					"Promo Allowed value are only true or false, wrong data set in the xls for this column.");
		}
		if (pdEnrollmentOnly.equalsIgnoreCase("true")
				|| pdEnrollmentOnly.equalsIgnoreCase("false")
				|| pdEnrollmentOnly.equalsIgnoreCase("")) {
			this.pdEnrollmentOnly = pdEnrollmentOnly;
		} else {
			throw new SkipException(
					"Product Enrollment only value are only true or false, wrong data set in the xls for this column.");
		}
		if (pdAutoRenewOnly.equalsIgnoreCase("true")
				|| pdAutoRenewOnly.equalsIgnoreCase("false")
				|| pdAutoRenewOnly.equalsIgnoreCase("")) {
			this.pdAutoRenewOnly = pdAutoRenewOnly;
		} else {
			throw new SkipException(
					"Auto renew only flag value are only true or false, wrong data set in the xls for this column.");
		}
		this.pdGuaranteedSavings = pdGuaranteedSavings;
		this.pdRenewables = pdRenewables;
		this.pdSalesChannels = pdSalesChannels;
		this.pdCustomerTypes = pdCustomerTypes;
		this.pdCommissionType = pdCommissionType;
		this.pdCommissionAmount = pdCommissionAmount;
	}

	/**
	 * @purpose:Initating Modify product process.
	 */

	@Test(groups = { "napower" })
	public void testInitiateModifyProduct() {
		Reporter.log("Exceution for Row number: " + this.pdSrno
				+ " Kicked off .");
		Logs.LOGGER.info("Exceution for Row number: " + this.pdSrno
				+ " Kicked off .");
		String sql = "";
		if (this.pdProductID.equalsIgnoreCase("")) {
			sql = "select Top 1 * from PRD.B_product ORDER BY NEWID()";
			Logs.LOGGER
					.info("No ProductId mentioned in excel data sheet ,hence"
							+ " script is fetching random product ID.");

		} else {
			sql = "select * from PRD.B_product where ProductId='"
					+ this.pdProductID + "'";
		}
		ResultSet rs = db.getData(sql);

		Logs.LOGGER.info("Exceuted sql for product db verification as " + sql
				+ " .");
		try {
			if (rs.next()) {
				if (rs.getInt("ProductId") == 0) {
					xlUpdate.updateExcelData(DataSource.globalConfig
							.get(Constants.CURRENT_TESTING + ".datasheet"),
							"ModifyProduct", "Fail", Integer
									.parseInt(this.pdSrno) - 1, 2);
					Assert.fail("Product Id not exist for Serial no:"
							+ this.pdSrno + " .");
				} else {
					Logs.LOGGER.info("Randomly picked productid is "
							+ rs.getString("ProductId") + " .");
					this.pdProductID = rs.getString("ProductId");
					this.pdCode = rs.getString("ProductCode");
				}
			} else {
				xlUpdate.updateExcelData(
						DataSource.globalConfig.get(Constants.CURRENT_TESTING
								+ ".datasheet"), "AddProduct", "Fail",
						Integer.parseInt(this.pdSrno) - 1, 2);
				Assert.fail("Product Id not exist for Serial no:" + this.pdSrno
						+ " .");
			}
		} catch (Exception e) {
			Logs.LOGGER.info("Facing issue while running sql for Serial no:"
					+ this.pdSrno + " ." + e);
		}
		if (testNavigateToSearchProductPage()) {
			Reporter.log("testNavigateToSearchProductPage passed");
		}

		if (testSearchProduct()) {
			Reporter.log("testSearchProduct passed");
		}

		if (testUpdateProduct()) {
			Reporter.log("testSearchProduct passed");
		}
		if (testValidateProductInfoInUI()) {
			Reporter.log("testValidateProductInfoInUI passed");
		}
		if (testValidateProductInfoInDataBase()) {
			Reporter.log("testValidateProductInfoInDataBase passed");
		}
		browser.get(ProductManagement.app.get("test.url") + "/sso/#/dashboard");
		Reporter.log(pass.toString());
		if (pass.length() > 0) {
			xlUpdate.updateExcelData(
					DataSource.globalConfig.get(Constants.CURRENT_TESTING
							+ ".datasheet"), "ModifyProduct", "Pass",
					Integer.parseInt(this.pdSrno) - 1, 2);
		}
		if (fail.length() > 0) {
			xlUpdate.updateExcelData(
					DataSource.globalConfig.get(Constants.CURRENT_TESTING
							+ ".datasheet"), "ModifyProduct", "Fail",
					Integer.parseInt(this.pdSrno) - 1, 2);
			Assert.fail(fail.toString());
		}

	}

	/**
	 * @return: Boolean true-in case navigated successfully/false-if not
	 *          navigated.
	 * @purpose:For verification of navigation in Search product page.
	 */
	private boolean testNavigateToSearchProductPage() {
		navigate.navigateSearchProductPage();
		if (Element.isTextPresent(browser,
				searchProduct.getProductSearchLabel(), "Product Search")) {
			pass.append("Successfully navigated to modify product page." + eol);
			ScreenShot.capture(true, "testNavigateToSearchProductPage");
			return true;
		} else {
			fail.append("Not able to navigate to modify product page." + eol);
			return false;
		}
	}

	/**
	 * @return: Boolean true-in case Product Searched and navigates to edit
	 *          product screen successfully/false-if not navigated.
	 * @purpose:For Search product as per product id in data sheet.
	 */
	private boolean testSearchProduct() {
		Element.scrollElementIntoView(browser,
				searchProduct.getProductNameElement());
		String productCodeToSearch = this.pdCode;
		searchProduct.setProductName(productCodeToSearch);
		searchProduct.getSelectSearchElement().click();
		WebPage.waitForPageToLoad(browser);
		WebPage.waitForAngularRequestsToFinish(browser);
		if (!webTabLocked.getCellElement(0, 1).getText().contains(this.pdCode) ? true
				: false) {
			Element.isClickable(browser, webTabLocked.getCellElement(0, 0)
					.findElement(By.tagName("a")));
			Element.click(browser, webTabLocked.getCellElement(0, 0)
					.findElement(By.tagName("a")));
		} else {
			fail.append("data is not matching in webtable.");
		}
		WebPage.waitForPageToLoad(browser);
		WebPage.waitForAngularRequestsToFinish(browser);
		Element.click(browser, createProduct.getModifyProductParameter());
		WebPage.waitForPageToLoad(browser);
		if (Element.isTextPresent(browser, createProduct.getAddProductLabel(),
				"Edit Product - Step 1: Define Product Attributes")) {
			pass.append("Successfully navigated to edit product page" + eol);
			ScreenShot.capture(true, "NavigateToModifyProductPage");
			return true;
		} else {
			fail.append("Not able to navigate to modify product page." + eol);
			return false;
		}
	}

	/**
	 * @return: Boolean true-in case Product Searched and navigates to edit
	 *          product screen successfully/false-if not navigated.
	 * @purpose:For Search product as per product id in data sheet.
	 */
	private boolean testUpdateProduct() {
		WebPage.waitForPageToLoad(browser);
		AngularDropDown DropDown = new AngularDropDown();
		boolean trackPassFlag = false;

		createProduct.setProductCode(pdCode);
		createProduct.setProductName(pdName);
		createProduct.setProductDescription(pdDescription);
		createProduct.setProductTagLine(pdTagLine);
		createProduct.setEffectiveDate(pdEffictiveDate);
		if (pdNoExpDate) {
			if (createProduct.getNoExpDate().getAttribute("checked") == null) {
				createProduct.setNoExpDate();
			}
		} else {
			if (createProduct.getNoExpDate().getAttribute("checked") == null) {
				createProduct.setExpirationDate(pdExpDate);
			} else {
				createProduct.setNoExpDate();
				createProduct.setExpirationDate(pdExpDate);
			}

		}
		JavascriptExecutor executor = (JavascriptExecutor) browser;
		executor.executeScript("window.scrollTo(0,"
				+ (createProduct.getContractSourceSpanElement().getLocation().y - 70)
				+ ")");
		createProduct.getContractSourceSpanElement().click();
		if (this.pdContractSource.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getContractSourceOptions(), 1);
			this.pdContractSource = DropDown.selectedAngularDropDownValue(
					browser, "ContractSource");

		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getContractSourceOptions(),
					this.pdContractSource)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getContractSourceElement(),
						this.pdContractSource);
				Logs.LOGGER.info("Option for Contract Source is selected as "
						+ this.pdContractSource + " .");
				pass.append("Option for Contract Source is selected as "
						+ this.pdContractSource + " ." + eol);
				trackPassFlag = true;
			} else {
				trackPassFlag = false;
				fail.append(this.pdContractSource
						+ " Option for Contract Source in datasheet is not present in UI ."
						+ eol);
			}
		}
		createProduct.getProductTypeElement().click();
		if (this.pdType.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getProductTypeOptions(), 1);
			this.pdType = DropDown.selectedAngularDropDownValue(browser,
					"ProductType");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getProductTypeOptions(), this.pdType)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getProductTypeInput(), this.pdType);
				Logs.LOGGER.info("Option for Product Type is selected as "
						+ this.pdType + " .");
				pass.append("Option for Product Type is selected as "
						+ this.pdType + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdType
						+ " Option for Product Type in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		createProduct.getServiceTypeElement().click();
		if (this.pdServiceType.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getServiceTypeOptions(), 1);
			this.pdServiceType = DropDown.selectedAngularDropDownValue(browser,
					"ServiceType");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getServiceTypeOptions(), this.pdServiceType)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getServiceTypeInput(), this.pdServiceType);
				Logs.LOGGER.info("Option for Service Type is selected as "
						+ this.pdServiceType + " .");
				pass.append("Option for Service Type is selected as "
						+ this.pdServiceType + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdServiceType
						+ " Option for Service Type in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}
		createProduct.getPricingAssignmentElement().click();
		if (this.pdPricingAssignMethod.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getPricingAssignmentOptions(), 1);
			this.pdPricingAssignMethod = DropDown.selectedAngularDropDownValue(
					browser, "PricingAssignmentMethod");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getPricingAssignmentOptions(),
					this.pdPricingAssignMethod)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getPricingAssignmentInput(),
						this.pdPricingAssignMethod);
				Logs.LOGGER
						.info("Option for Pricing Assignment is selected as "
								+ this.pdPricingAssignMethod + " .");
				pass.append("Option for Pricing Assignment is selected as "
						+ this.pdPricingAssignMethod + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdPricingAssignMethod
						+ " Option for Pricing assignment in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		createProduct.getRolloverProductElement().click();
		if (this.pdRolloverProduct.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getRolloverProductOptions(), 1);
			this.pdRolloverProduct = DropDown.selectedAngularDropDownValue(
					browser, "RolloverProduct");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getRolloverProductOptions(),
					this.pdRolloverProduct)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getRolloverProductInput(),
						this.pdRolloverProduct);
				Logs.LOGGER.info("Option for Rollover product is selected as "
						+ this.pdRolloverProduct + " .");
				pass.append("Option for Rollover product is selected as "
						+ this.pdRolloverProduct + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdRolloverProduct
						+ " Option for Rollover product in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		createProduct.getProductTermsInMonthsElement().click();
		if (this.pdTermsInMonths.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getProductTermsInMonthsOptions(), 1);
			this.pdTermsInMonths = DropDown.selectedAngularDropDownValue(
					browser, "TermsInMonths");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getProductTermsInMonthsOptions(),
					this.pdTermsInMonths)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getProductTermsInMonthsInput(),
						this.pdTermsInMonths);
				Logs.LOGGER.info("Option for Product terms is selected as "
						+ this.pdTermsInMonths + " .");
				pass.append("Option for Product terms is selected as "
						+ this.pdTermsInMonths + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdTermsInMonths
						+ " Option for Product terms in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		if (this.pdPromoAllowed.equalsIgnoreCase("true")) {
			if (createProduct.getPromoAllowedElement().getAttribute("checked") == null) {
				createProduct.getPromoAllowedElement().click();
			}
		} else {
			createProduct.getPromoAllowedElement().click();
		}
		if (this.pdEnrollmentOnly.equalsIgnoreCase("true")) {
			if (createProduct.getEnrollmentOnlyElement()
					.getAttribute("checked") == null) {
				createProduct.getEnrollmentOnlyElement().click();
			}
		} else {
			createProduct.getEnrollmentOnlyElement().click();
		}

		if (this.pdAutoRenewOnly.equalsIgnoreCase("true")) {
			if (createProduct.getAutoRenewOnlyElement().getAttribute("checked") == null) {
				createProduct.getAutoRenewOnlyElement().click();
			}
		} else {
			createProduct.getAutoRenewOnlyElement().click();
		}
		createProduct.getGuaranteedSavings().clear();
		if (this.pdGuaranteedSavings.equalsIgnoreCase("")) {
			this.pdGuaranteedSavings = "123";
			createProduct.getGuaranteedSavings().sendKeys(
					this.pdGuaranteedSavings);
		} else {
			createProduct.getGuaranteedSavings().sendKeys(
					this.pdGuaranteedSavings);
		}
		createProduct.getRenewables().clear();
		if (this.pdRenewables.equalsIgnoreCase("")) {
			this.pdRenewables = "123";
			createProduct.getRenewables().sendKeys(this.pdRenewables);
		} else {
			createProduct.getRenewables().sendKeys(this.pdRenewables);
		}

		executor.executeScript("window.scrollTo(0,"
				+ (createProduct.getSalesChannelsElement().getLocation().y - 70)
				+ ")");
		try {
			DropDown.clearDropDownElement(createProduct
					.getSalesChannelsElementDiv());
		} catch (Exception e) {
			Logs.LOGGER.info("No Sales channel is selected earlier.");
		}
		try {
			DropDown.clearDropDownElement(createProduct
					.getCustomerTypeElementDiv());
		} catch (Exception e) {
			Logs.LOGGER.info("No Sales channel is selected earlier.");
		}
		//
		WebElement element = createProduct.getSalesChannelsElement();
		WaitUtils.waitForElement(browser, element);
		createProduct.getSalesChannelsElement().click();
		if (this.pdSalesChannels.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getSalesChannelsOptions(), 1);
			this.pdSalesChannels = DropDown.selectedAngularDropDownValue(
					browser, "SalesChannels");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getSalesChannelsOptions(),
					this.pdSalesChannels)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getSalesChannelsInput(),
						this.pdSalesChannels);
				Logs.LOGGER.info("Option for Sales Channels is selected as "
						+ this.pdSalesChannels + " .");
				pass.append("Option for Sales Channels is selected as "
						+ this.pdSalesChannels + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdSalesChannels
						+ " Option for Sales Channels in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		createProduct.getCustomerTypeElement().click();
		if (this.pdCustomerTypes.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getCustomerTypeOptions(), 1);
			this.pdCustomerTypes = DropDown.selectedAngularDropDownValue(
					browser, "CustomerTypes");
		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getCustomerTypeOptions(),
					this.pdCustomerTypes)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getCustomerTypeInput(),
						this.pdCustomerTypes);
				Logs.LOGGER.info("Option for Customer Type is selected as "
						+ this.pdCustomerTypes + " .");
				pass.append("Option for Customer Type is selected as "
						+ this.pdCustomerTypes + " ." + eol);
				trackPassFlag = true;
			} else {
				fail.append(this.pdCustomerTypes
						+ " Option for Customer Type in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		createProduct.getCommissionTypeElement().click();
		if (this.pdCommissionType.equalsIgnoreCase("")) {
			DropDown.selectAngularDropdownOptionByIndex(
					createProduct.getCommissionTypeOptions(), 1);
			this.pdCommissionType = DropDown.selectedAngularDropDownValue(
					browser, "CommissionType");
			WebPage.waitForAngularRequestsToFinish(browser);
			WebElement commisionAmountElement = createProduct
					.getCommissionAmountElement();
			commisionAmountElement.click();
			WebPage.waitForAngularRequestsToFinish(browser);
			if (this.pdCommissionAmount.equalsIgnoreCase("")) {
				createProduct.getCommissionAmountEditBox().clear();
				createProduct.getCommissionAmountEditBox().sendKeys("123");
			} else {
				createProduct.getCommissionAmountEditBox().clear();
				createProduct.getCommissionAmountEditBox().sendKeys(
						this.pdCommissionAmount);
			}

		} else {
			if (DropDown.isOptionTextPresentForAngularDropdown(
					createProduct.getCommissionTypeOptions(),
					this.pdCommissionType)) {
				DropDown.selectAngularDropdownOptionByValue(
						createProduct.getCommissionTypeInput(),
						this.pdCommissionType);
				Logs.LOGGER.info("Option for Commision Type is selected as "
						+ this.pdCommissionType + " .");
				pass.append("Option for Commision Type is selected as "
						+ this.pdCommissionType + " ." + eol);
				WebPage.waitForAngularRequestsToFinish(browser);
				WebElement commisionAmountElement = createProduct
						.getCommissionAmountElement();
				commisionAmountElement.click();
				WebPage.waitForAngularRequestsToFinish(browser);
				createProduct.getCommissionAmountEditBox().clear();
				if (this.pdCommissionAmount.equalsIgnoreCase("")) {
					createProduct.getCommissionAmountEditBox().sendKeys("123");
				} else {
					createProduct.getCommissionAmountEditBox().sendKeys(
							this.pdCommissionAmount);
				}
				trackPassFlag = true;
			} else {
				fail.append(this.pdCommissionType
						+ " Option for Commision Type in datasheet is not present in UI ."
						+ eol);
				trackPassFlag = false;
			}
		}

		createProduct.getNextButton().click();
		WebPage.waitForPageToLoad(browser);
		// Handled the exception, when expire date is less than effective date.
		String errorMsg = "Expiration Date should be greater than the Effective Date";

		try {
			if (createProduct.errorMessage()) {
				createProduct.verifyErrorMessageAndClose(errorMsg);
				createProduct.setNoExpDate();
				Reporter.log("Expiration date selected early from effective date,"
						+ "hence ZBRA is making it No expiration date .");
				Logs.LOGGER
						.info("Expiration date selected early from effective date,"
								+ "hence ZBRA is making it No expiration date .");
				this.pdExpDate = "";
				createProduct.getNextButton().click();
			}
		} catch (Exception e) {
			Logs.LOGGER.info("No error found.");
		}

		if (trackPassFlag) {
			ScreenShot.capture(true, "testAddProduct");
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return: Boolean true-in case Validated successfully/false-if not.
	 * @purpose:Match UI Values against inserted values.
	 */
	private boolean testValidateProductInfoInUI() {
		Logs.LOGGER.info("Performing UI validation .");
		boolean trackPassFlag = false;
		if (createProduct.matchProductCodeConfirmationScreen(this.pdCode)) {
			pass.append("Product Code " + this.pdCode
					+ " matched successfully.");
			Logs.LOGGER.info("Product Code " + this.pdCode
					+ " matched successfully." + eol);
			trackPassFlag = true;
		} else {
			fail.append("Product code is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (createProduct.matchProductNameConfirmationScreen(this.pdName)) {
			pass.append("Product Name " + this.pdName
					+ " matched successfully.");
			Logs.LOGGER.info("Product Name " + this.pdName
					+ " matched successfully." + eol);
			trackPassFlag = true;
		} else {
			fail.append("Product Name is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (createProduct
				.matchProductDescriptionConfirmationScreen(this.pdDescription)) {
			pass.append("Product Description " + this.pdDescription
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Product Description " + this.pdDescription
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Product Description is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (createProduct.matchProductTagLineConfirmationScreen(this.pdTagLine)) {
			pass.append("Product Tag Line " + this.pdTagLine
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Product Tag Line " + this.pdTagLine
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Product Tag Line is not matching in UI." + eol);
			trackPassFlag = false;
		}
		WebTable webTab = new WebTable(
				createProduct.getWebTableInProdConfirmationScreen(), browser);
		if (webTab.matchAgainstVerticalColumnLabel("Contract Source",
				this.pdContractSource)) {
			pass.append("Contract Source " + this.pdContractSource
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Contract Source " + this.pdContractSource
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Contract Source is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Product Type", this.pdType)) {
			pass.append("Product Type " + this.pdType
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Product Type " + this.pdType
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Product Type is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Service Type",
				this.pdServiceType)) {
			pass.append("Service Type " + this.pdServiceType
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Service Type " + this.pdServiceType
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Service Type is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Term Length",
				this.pdTermsInMonths)) {
			pass.append("Term Length " + this.pdTermsInMonths
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Term Length " + this.pdTermsInMonths
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Term Length is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Rollover Product",
				this.pdRolloverProduct)) {
			pass.append("Roll Over Product " + this.pdRolloverProduct
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Roll Over Product " + this.pdRolloverProduct
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Roll Over Product is not matching in UI." + eol);
			trackPassFlag = false;
		}

		String promoMatchingFlag = "";
		if (this.pdPromoAllowed.equalsIgnoreCase("true")) {
			promoMatchingFlag = "Yes";
		} else {
			promoMatchingFlag = "No";
		}

		if (webTab.matchAgainstVerticalColumnLabel("Allow Promos",
				promoMatchingFlag)) {
			pass.append("Allow Promos " + promoMatchingFlag
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Allow Promos  " + promoMatchingFlag
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Allow Promos is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Customer Types",
				this.pdCustomerTypes)) {
			pass.append("Customer Types " + this.pdCustomerTypes
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Customer Types  " + this.pdCustomerTypes
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Customer Types is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Sales Channels",
				this.pdSalesChannels)) {
			pass.append("Sales Channels " + this.pdSalesChannels
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Sales Channels " + this.pdSalesChannels
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Sales Channels  is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Renewables",
				this.pdRenewables)) {
			pass.append("Renewables " + this.pdRenewables
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Renewables " + this.pdRenewables
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Renewables is not matching in UI." + eol);
			trackPassFlag = false;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Effective Date",
				this.pdEffictiveDate)) {
			pass.append("Effective Date " + this.pdEffictiveDate
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Effective Date" + this.pdEffictiveDate
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Effective Date is not matching in UI." + eol);
			trackPassFlag = false;
		}

		String productExpirationDate;
		if (this.pdExpDate == "") {
			productExpirationDate = "Does not expire";
		} else {
			productExpirationDate = this.pdExpDate;
		}

		if (webTab.matchAgainstVerticalColumnLabel("Expiration Date",
				productExpirationDate)) {
			pass.append("Expiration Date " + this.pdExpDate
					+ " matched successfully." + eol);
			Logs.LOGGER.info("Expiration Date " + this.pdExpDate
					+ " matched successfully.");
			trackPassFlag = true;
		} else {
			fail.append("Expiration Date is not matching in UI." + eol);
			trackPassFlag = false;
		}

		WebPage.waitForAngularRequestsToFinish(browser);
		createProduct.getSaveAddProductButton().click();
		try {
			if (createProduct
					.verifyErrorMessageAndClose("Product was not modified.")) {
				ScreenShot.capture(true);
				fail.append("Product was not added ." + eol);
				Logs.LOGGER.info("Product was not added ." + eol);
				trackPassFlag = false;
			}
		} catch (Exception e) {
			Logs.LOGGER.info("Kool, No Error message found.");
		}
		try {
			if (createProduct.informationMessageBox(this.pdCode + ", "
					+ this.pdName + " Successfully Updated")) {
				ScreenShot.capture(true);
				createProduct.infoMessageClose();
				pass.append("Product updated successfully with product code "
						+ this.pdCode + "." + eol);
				Logs.LOGGER
						.info("Product updated successfully with product code "
								+ this.pdCode + ".");
				trackPassFlag = true;
			} else {
				fail.append("No Information message displayed." + eol);
				trackPassFlag = false;
			}
		} catch (Exception e) {
			fail.append("No Information message displayed." + eol);
			trackPassFlag = false;
		}

		if (trackPassFlag) {
			ScreenShot.capture(true, "testValidateProductInfoInUI");
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return: Boolean true-in case Validated successfully/false-if not.
	 * @purpose:Verify product info in DB and fetch product id and save in
	 *                 excel.
	 */
	private boolean testValidateProductInfoInDataBase() {
		Logs.LOGGER.info("Performing DB validation.");
		try {
			String sqlSalesChannel = "select SalesChannelId from [PRD].[L_SalesChannel] where SalesChannelName='"
					+ this.pdSalesChannels + "'";
			ResultSet rsSalesChannel = db.getData(sqlSalesChannel);
			String dbSalesChannelId = null;
			if (rsSalesChannel.next()) {
				dbSalesChannelId = rsSalesChannel.getString("SalesChannelId");
			} else {
				Logs.LOGGER
						.info("Not able to fetch Sales Channel Id from database .");
			}
			String sqlCustomerTypes = "select AccountTypeId from [COM].[L_AccountType] where AccountTypeName='"
					+ this.pdCustomerTypes + "'";
			ResultSet rsCustomerTypes = db.getData(sqlCustomerTypes);
			String dbCustomerTypesId = null;
			if (rsCustomerTypes.next()) {
				dbCustomerTypesId = rsCustomerTypes.getString("AccountTypeId");
			} else {
				Logs.LOGGER
						.info("Not able to fetch Customer Type from database .");
			}
			String sqlRolloverProduct = "select ProductId from PRD.B_product where ProductCode='"
					+ this.pdRolloverProduct + "'";
			ResultSet rsRolloverProduct = db.getData(sqlRolloverProduct);
			String dbRolloverProduct = null;
			if (rsRolloverProduct.next()) {
				dbRolloverProduct = rsRolloverProduct.getString("ProductId");
			} else {
				Logs.LOGGER
						.info("Not able to fetch Rollover product Id from database .");
			}
			String sql = "select * from PRD.B_product p join [PRD].[B_ProductAccountType] pat "
					+ "on p.ProductId=pat.ProductId join [PRD].[B_ProductSalesChannels] psc "
					+ "on psc.ProductId=p.ProductId where p.ProductCode='"
					+ this.pdCode
					+ "' and p.ProductName='"
					+ this.pdName
					+ "' and psc.SalesChannelId="
					+ dbSalesChannelId
					+ " and pat.AccountTypeId="
					+ dbCustomerTypesId
					+ " and p.RolloverProductId="
					+ dbRolloverProduct
					+ " and p.ProductDescription='"
					+ this.pdDescription
					+ "' and p.ProductTagLine='"
					+ this.pdTagLine
					+ "' and p.ProductId=" + this.pdProductID;
			ResultSet rs = db.getData(sql);
			if (rs.next()) {
				if (Integer.parseInt(rs.getString("ProductId")) > 1) {
					xlUpdate.updateExcelData(DataSource.globalConfig
							.get(Constants.CURRENT_TESTING + ".datasheet"),
							"ModifyProduct", rs.getString("ProductId"), Integer
									.parseInt(this.pdSrno) - 1, 1);
					pass.append("Product Code : " + this.pdCode
							+ " Found in DB successfully with ProductId as "
							+ rs.getString("ProductId") + " ." + eol);
					Logs.LOGGER.info("Product Code : " + this.pdCode
							+ " Found in DB successfully with ProductId as "
							+ rs.getString("ProductId") + " .");
					return true;
				} else {

					fail.append("Not able to find product in DB with Product code as "
							+ this.pdCode + " ." + eol);
					return false;
				}
			} else {

				fail.append("Not able to find product in DB with Product code as "
						+ this.pdCode + " ." + eol);
				return false;
			}
		} catch (SQLException e) {
			fail.append("Unable to fetch data from db for product code as "
					+ this.pdCode + " ." + eol);
			return false;
		}
	}
}
