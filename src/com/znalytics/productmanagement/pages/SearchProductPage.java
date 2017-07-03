// Copyright - Znalytics (http://www.Znalytics.com/)

package com.znalytics.productmanagement.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.znalytics.framework.utility.Element;

/**
 * The Class SearchProductPage.
 *
 * @author: Yogi Garg
 * @mail: ygarg@znalytics.com
 * @date: Mar 18, 2015
 * @purpose: purpose of this class is to store all the pages object related to
 *           Search Product Page.
 */

public class SearchProductPage {

	private WebDriver driver;

	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Finding object Partial Product Name or Code
	@FindBy(xpath = "//input[@id='searchProductCodeOrName']")
	private WebElement searchProductCodeOrName;

	// Finding object Markets
	@FindBy(xpath = "//div[@id='multiple_select_searchMarkets']//input[@type='text']")
	private WebElement selectMarkets;

	// Finding object utility
	@FindBy(xpath = "//div[@id='multiple_select_searchUtilities']//input[@type='text']")
	private WebElement selectUtility;

	// Finding object search utility drop down value
	@FindBy(xpath = "//div[@id='multiple_select_searchUtilities']")
	private WebElement selectUtilityOption;

	// Finding object search market drop down value
	@FindBy(xpath = "//div[@id='multiple_select_searchMarkets']")
	private WebElement selectMarketOption;

	// Finding object search market drop down value
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-0')]")
	private List<WebElement> selectMarketOptionElement;

	// Finding object search utilities drop down value
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-1')]")
	private List<WebElement> selectUtilityOptionElement;

	// Finding object search zones drop down value
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-2')]")
	private List<WebElement> selectZoneOptionElement;

	// Finding object search segment drop down value
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-3')]")
	private List<WebElement> selectSegmentOptionElement;

	// Finding object search sales channel drop down value
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-4')]")
	private List<WebElement> selectSalesChannelOptionElement;

	// Finding object search Contract Sources drop down value
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-5')]")
	private List<WebElement> selectContractSourcesOptionElement;

	// Finding object search zone drop down value
	@FindBy(xpath = "//div[@id='multiple_select_searchZones']")
	private WebElement selectZoneOption;

	// Finding object search search Segments drop down value
	@FindBy(xpath = "//div[@id='multiple_select_searchSegments']")
	private WebElement selectSegmentOption;

	// Finding object search Sales Channels drop down value
	@FindBy(xpath = "//div[@id='multiple_select_searchSalesChannels']")
	private WebElement selectSalesChannelOption;

	// Finding object search Contract Sources drop down value
	@FindBy(xpath = "//div[@id='multiple_select_searchContractSources']")
	private WebElement selectContractSourcesOption;

	// Finding object zone
	@FindBy(xpath = "//div[@id='multiple_select_searchZones']//input[@type='text']")
	private WebElement selectZone;

	// Finding object segment
	@FindBy(xpath = "//div[@id='multiple_select_searchSegments']//input[@type='text']")
	private WebElement selectSegment;

	// Finding object Sales channel
	@FindBy(xpath = "//div[@id='multiple_select_searchSalesChannels']//input[@type='text']")
	private WebElement selectChannel;

	// Finding object Contract Sources
	@FindBy(xpath = "//div[@id='multiple_select_searchContractSources']//input[@type='text']")
	private WebElement selectContractSource;

	// Finding object Search Promo Allowed Activate
	@FindBy(xpath = "//span[@aria-label='Select box activate']")
	private WebElement searchPromoAllowedActivate;

	// Finding object Promo Allowed
	@FindBy(xpath = "//div[@id='single_select_searchPromoAllowed']/input[@type='text']")
	private WebElement selectPromoAllowed;

	// Finding object Promo Allowed select
	@FindBy(xpath = "//input[contains(@id,'ui-select-choices-row-6')]/a")
	private WebElement searchPromoAllowed;

	// Finding object Search
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Search')]")
	private WebElement selectSearch;

	// Finding object reset
	@FindBy(xpath = "//button[@type='button' and contains(text(),'Clear')]")
	private WebElement selectReset;

	// Finding object Product Code
	@FindBy(xpath = "//th[@data-title='Product Code']")
	private WebElement productCode;

	// Finding object Product Name
	@FindBy(xpath = "//th[@data-title='Product Name']")
	private WebElement productName;

	// Finding object Product Type
	@FindBy(xpath = "//th[@data-title='Product Type']")
	private WebElement productType;

	// Finding object Service Type
	@FindBy(xpath = "//th[@data-title='Service Type']")
	private WebElement serviceType;

	// Finding object Effective Date
	@FindBy(xpath = "//th[@data-title='Effective Date']")
	private WebElement effectiveDate;

	// Finding object Expiration Date
	@FindBy(xpath = "//th[@data-title='Expiration Date']")
	private WebElement expirationDate;

	// Finding object Promo Allowed
	@FindBy(xpath = "//th[@data-title='Promo Allowed']")
	private WebElement promoAllowedWebTable;

	// Finding object Linked Rate Schedules
	@FindBy(xpath = "//th[@data-title='Linked Rate Schedules']")
	private WebElement linkedRateSchedules;

	// Finding object drop target
	@FindBy(xpath = "//div[@data-role='droptarget']")
	private WebElement dropTarget;

	// Finding object Active
	@FindBy(xpath = "//th[@data-title='Active']")
	private WebElement active;

	// Finding object Webtable result unlocked
	@FindBy(xpath = "//div[@class='k-grid-content']/table[@role='grid']/tbody")
	private WebElement webtable;

	// Finding object Webtable result locked
	@FindBy(xpath = "//div[@class='k-grid-content-locked']/table/tbody")
	private WebElement webtablelocked;

	// Finding object Webtable header Locked
	@FindBy(xpath = "//div[@class='k-grid-header']//thead")
	private WebElement webTableHeaderLocked;

	// Finding object Webtable header wrap
	@FindBy(xpath = "//div[@class='k-grid-header-wrap']//thead")
	private WebElement webTableHeaderWrap;

	// Finding object Error select one search criteria
	@FindBy(xpath = "//div[contains(@class,'k-widget') and @data-role='draggable']//span[contains(text(),'Error')]")
	private WebElement errorSelectSearchcriteria;

	// Finding object Information pop when no matching record found
	@FindBy(xpath = "//span[contains(.,'Information')]")
	private WebElement informationPopUpErrorMessage;

	// Finding object Error pop up message
	@FindBy(xpath = "//div[contains(@class,'k-widget') and @data-role='draggable']//td/span[contains(@class,'error-msg-icon')]/ancestor::td/following-sibling::td")
	private WebElement errorMessage;

	// Finding object Information pop up message
	@FindBy(xpath = "//td[@class='p-md ng-binding']")
	private WebElement infoMessage;

	// Finding object Error pop up message close
	@FindBy(xpath = "//span[contains(text(),'Error')]/following-sibling::div/a/span[contains(text(),'Close')]")
	private WebElement errorMessageClose;

	// Finding object Information pop up message close
	@FindBy(xpath = "//span[contains(text(),'Information')]/following-sibling::div/a/span[contains(text(),'Close')]")
	private WebElement infoMessageClose;

	// Finding object Group By delete
	@FindBy(xpath = "//div[@id='productSearchResults']//span[contains(@class,'k-group-delete')]")
	private WebElement errorGroupDelete;

	// Finding object Export to excel
	@FindBy(xpath = "//a[contains(text(),'Export to Excel') and contains(@class,'k-grid-excel')]")
	private WebElement exportToExcel;

	// Finding object label product to filter
	@FindBy(xpath = "//div[contains(text(),'Product Filter Criteria')]")
	private WebElement productFilterCriteria;

	// Finding Page label product search
	@FindBy(xpath = "//h4[contains(text(),'Product Search')]")
	private WebElement productSearchLabel;

	// Setting up productName
	public void setProductName(String productName) {
		searchProductCodeOrName.clear();
		searchProductCodeOrName.sendKeys(productName);
	}

	// Getting element productName
	public WebElement getProductNameElement() {
		return searchProductCodeOrName;
	}

	// Get Product Search Label
	public WebElement getProductSearchLabel() {
		return productSearchLabel;
	}

	// Getting element product Filter Criteria
	public WebElement getProductFilterCriteria() {
		return productFilterCriteria;
	}

	// Getting element market
	public WebElement getSelectMarketsElement() {
		return selectMarketOption;
	}

	// Getting element market text box
	public WebElement getSelectMarketsElementTextBox() {
		return selectMarkets;
	}

	// Getting element market option value
	public List<WebElement> getSelectMarketsOptionElement() {
		return selectMarketOptionElement;
	}

	// Getting element utility option value
	public List<WebElement> getSelectUtilityOptionElement() {
		return selectUtilityOptionElement;
	}

	// Getting element zone option value
	public List<WebElement> getSelectZoneOptionElement() {
		return selectZoneOptionElement;
	}

	// Getting element segment option value
	public List<WebElement> getSelectSegmentOptionElement() {
		return selectSegmentOptionElement;
	}

	// Getting element Sales Channel option value
	public List<WebElement> getSelectSalesChannelOptionElement() {
		return selectSalesChannelOptionElement;
	}

	// Getting element Contract Sources option value
	public List<WebElement> getSelectContractSourcesOptionElement() {
		return selectContractSourcesOptionElement;
	}

	// Getting element utility
	public WebElement getSelectUtilitiesElement() {
		return selectUtilityOption;
	}

	// Getting element utility text box
	public WebElement getSelectUtilitiesElementTextBox() {
		return selectUtility;
	}

	// Getting element zone text box
	public WebElement getSelectZoneElementTextBox() {
		return selectZone;
	}

	// Getting element zone
	public WebElement getSelectZonesElement() {
		return selectZoneOption;
	}

	// Getting element segment
	public WebElement getSelectSegmentElement() {
		return selectSegmentOption;
	}

	// Getting element segment text box
	public WebElement getSelectSegmentElementTextBox() {
		return selectSegment;
	}

	// Getting element sales channel
	public WebElement getSelectSalesChannelElement() {
		return selectSalesChannelOption;
	}

	// Getting element sales channel text box
	public WebElement getSelectSalesChannelElementTextBox() {
		return selectChannel;
	}

	// Getting element contract source text box
	public WebElement getSelectContractSourceElementTextBox() {
		return selectContractSource;
	}

	// Getting element Contract Sources
	public WebElement getSelectContractSourcesElement() {
		return selectContractSourcesOption;
	}

	// Getting element Promo Allowed
	public WebElement getselectPromoAllowedElement() {
		searchPromoAllowedActivate.click();
		return selectPromoAllowed;
	}

	// Getting element Search
	public WebElement getSelectSearchElement() {
		return selectSearch;
	}

	// Getting element WebTable
	public WebElement getWebTable() {
		return webtable;
	}

	// Getting element WebTable locked result
	public WebElement getWebTableLocked() {
		return webtablelocked;
	}

	// Getting element Dropobject
	public WebElement getDropObject() {
		return dropTarget;
	}

	// Getting element Reset
	public void clickReset() {
		selectReset.click();
	}

	// Getting element table Header locked
	public WebElement getWebTableHeaderLocked() {
		return webTableHeaderLocked;
	}

	// Getting element table Header wrap
	public WebElement getWebTableHeaderWrap() {
		return webTableHeaderWrap;
	}

	// Getting element Market Div
	public WebElement getMarketDiv() {
		return selectMarketOption;
	}

	// Getting Export to Excel
	public WebElement getExportToExcel() {
		return exportToExcel;
	}

	// Getting element Utility Div
	public WebElement getUtilityDiv() {
		return selectUtilityOption;
	}

	// Getting element Zone Div
	public WebElement getZoneDiv() {
		return selectZoneOption;
	}

	// Getting element Segment Div
	public WebElement getSegmentDiv() {
		return selectSegmentOption;
	}

	// Getting element Sales Channel Div
	public WebElement getSalesChannelDiv() {
		return selectSalesChannelOption;
	}

	// Getting element Contract Source Div
	public WebElement getContractSourceDiv() {
		return selectContractSourcesOption;
	}

	// Clear Drop Down Form Element
	public void clearDropDownElement(WebElement div, String value) {
		div.findElement(
				By.xpath("//span[contains(text(),'" + value
						+ "')]/../preceding-sibling::span")).click();
	}

	// Angular Result table Column removal header option
	public void columnRemovalHeader(WebElement ColumnHeader) {
		ColumnHeader.findElement(
				By.xpath("/a/span[contains(@class,'arrowhead')]")).click();
		if (Element
				.isVisible(
						driver,
						By.xpath("//span[contains(text(),'Columns')]/span[contains(@class,'arrow')]"))) {
			driver.findElement(
					By.xpath("//span[contains(text(),'Columns')]/span[contains(@class,'arrow')]"))
					.click();
		}
	}

	// Clear Drop Target Element Exist
	public boolean chkDropTargetElementExist(String value) {
		if (Element.isVisible(
				driver,
				dropTarget.findElement(By.xpath("div[@data-title='" + value
						+ "']")))) {
			return true;
		} else {
			return false;
		}
	}

	// Getting element Error message when no field selected for search
	public boolean getNoFieldSelectedErrorMessageElement(String errorMsg) {
		if (Element.isVisible(driver, errorSelectSearchcriteria)
				&& errorMessage.getText().contains(errorMsg))
			return true;
		else
			return false;
	}

	// Getting element Information pop up if result returns 0 records
	public boolean getNoFieldSelectedInformationMessageElement(String infoMsg) {
		if (Element.isVisible(driver, informationPopUpErrorMessage)
				&& infoMessage.getText().contains(infoMsg))
			return true;
		else
			return false;
	}

	// Getting Error Element

	public WebElement getErrorElement() {
		return errorMessageClose;
	}

	// Getting info element

	public WebElement getInfoElement() {
		return infoMessageClose;
	}

	// Getting element error message close
	public void getErrorClose() {
		try {
			while (Element.isVisible(driver, errorMessageClose)) {
				Element.clickJS(driver, errorMessageClose);
				if (!errorMessageClose.isDisplayed()) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	// Getting element information message close
	public void getInfoClose() {
		try {
			while (Element.isVisible(driver, infoMessageClose)) {
				Element.clickJS(driver, infoMessageClose);
				if (!infoMessageClose.isDisplayed()) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	// Getting element group delete
	public void getGroupDelete() {
		if (Element.isVisible(driver, errorGroupDelete)) {
			errorGroupDelete.click();
		}
	}

}
