// Copyright - Znalytics (http://www.Znalytics.com/)

package com.znalytics.productmanagement.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.znalytics.framework.utility.Element;

/**
 * The Class CreateProductPage.
 *
 * @author: Yogi Garg
 * @mail: ygarg@znalytics.com
 * @date: Mar 18, 2015
 * @purpose:Purpose of this class is to store all the pages object related to
 *                  Create Product Page.
 */

public class CreateProductPage {

	private WebDriver driver;

	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Finding object Product Code.
	@FindBy(id = "ProductCode")
	private WebElement productCode;

	// Finding object Product Name.
	@FindBy(id = "ProductName")
	private WebElement productName;

	// Finding object Product Description.
	@FindBy(id = "ProductDescription")
	private WebElement productDescription;

	// Finding object Product Tag Line.
	@FindBy(id = "ProductTagLine")
	private WebElement productTagLine;

	// Finding object Effective date calendar icon.
	@FindBy(xpath = "//span[@aria-controls='dtCtrlEffectiveDate_dateview']/span[@class='k-icon k-i-calendar']")
	private WebElement effectiveDateCalendarIcon;

	// Finding object Effective date calendar div.
	@FindBy(xpath = "//div[@id='dtCtrlEffectiveDate_dateview']")
	private WebElement effectiveDateCalendarDiv;

	// Effective date Element.
	@FindBy(id = "dtCtrlEffectiveDate")
	private WebElement effectiveDate;

	// Finding object Expiration date calendar icon.
	@FindBy(xpath = "//span[@aria-controls='dtCtrlExpirationDate_dateview']/span[@class='k-icon k-i-calendar']")
	private WebElement expirationDateCalendarIcon;

	// Finding object Expiration date calendar div.
	@FindBy(xpath = "//div[@id='dtCtrlExpirationDate_dateview']")
	private WebElement expirationDateCalendarDiv;

	// Expiration date Element.
	@FindBy(id = "dtCtrlExpirationDate")
	private WebElement expirationDate;

	// Finding object select No Expiration Date.
	@FindBy(id = "checkBoxNoExpirationDate")
	private WebElement noExpirationDate;

	// Finding object search contract source click.
	@FindBy(xpath = "//div[@id='single_select_ContractSource']/input[contains(@ng-model,'$select.search')]")
	private WebElement contractSourceElement;

	// Finding object search contract source Span click.
	@FindBy(xpath = "//div[@id='single_select_ContractSource']//span[contains(@aria-label,'Select box activate')]")
	private WebElement contractSourceSpanElement;

	// Finding object select contract source.
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-7')]")
	private List<WebElement> contractSourceOptions;

	// Product Type Element Span.
	@FindBy(xpath = "//div[@id='single_select_ProductType']//span[contains(@aria-label,'Select box activate')]")
	private WebElement productTypeElementSpan;

	// Product Type Element.
	@FindBy(id = "single_select_ProductType")
	private WebElement productTypeElement;

	// Product Type Options.
	@FindBy(xpath = ".//div[contains(@id,'ui-select-choices-row-8')]")
	private List<WebElement> productTypeOptions;

	// Product Type Input.
	@FindBy(xpath = "//div[@id='single_select_ProductType']/input[contains(@ng-model,'$select.search')]")
	private WebElement productTypeInput;

	// Service Type Element.
	@FindBy(id = "single_select_ServiceType")
	private WebElement serviceTypeElement;

	// Service Type Options.
	@FindBy(xpath = ".//div[contains(@id,'ui-select-choices-row-9')]")
	private List<WebElement> serviceTypeOptions;

	// Service Type Input.
	@FindBy(xpath = "//div[@id='single_select_ServiceType']/input[contains(@ng-model,'$select.search')]")
	private WebElement serviceTypeInput;

	// Pricing Assignment Element.
	@FindBy(id = "single_select_PricingAssignmentMethod")
	private WebElement pricingAssignmentElement;

	// Pricing Assignment Options.
	@FindBy(xpath = ".//div[contains(@id,'ui-select-choices-row-10')]")
	private List<WebElement> pricingAssignmentOptions;

	// Pricing Assignment Input.
	@FindBy(xpath = "//div[@id='single_select_PricingAssignmentMethod']/input[contains(@ng-model,'$select.search')]")
	private WebElement pricingAssignmentInput;

	// Roll-over Product Element.
	@FindBy(id = "single_select_RolloverProduct")
	private WebElement rolloverProductElement;

	// Roll-over Product Options.
	@FindBy(xpath = ".//div[contains(@id,'ui-select-choices-row-11')]")
	private List<WebElement> rolloverProductOptions;

	// Roll-over Product Input.
	@FindBy(xpath = "//div[@id='single_select_RolloverProduct']/input[contains(@ng-model,'$select.search')]")
	private WebElement rolloverProductInput;

	// Product Terms In Months Element.
	@FindBy(id = "single_select_ProductTermsInMonths")
	private WebElement productTermsInMonthsElement;

	// Product Terms In Months Options.
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-12')]")
	private List<WebElement> productTermsInMonthsOptions;

	// Product Terms In Months Input.
	@FindBy(xpath = "//div[@id='single_select_ProductTermsInMonths']/input[contains(@ng-model,'$select.search')]")
	private WebElement productTermsInMonthsInput;

	// Finding object select Check box for Allow promotions.
	@FindBy(id = "AllowPromotions")
	private WebElement allowPromotions;

	// Finding object select Check box for Enrollment Only.
	@FindBy(id = "EnrollmentOnly")
	private WebElement enrollmentOnly;

	// Finding object select Check box for Auto Renew Only.
	@FindBy(id = "AutoRenewOnly")
	private WebElement autoRenewOnly;

	// Guaranteed Savings Element.
	@FindBy(id = "Guaranteed Savings")
	private WebElement guaranteedSavings;

	// Guaranteed Savings Element.
	@FindBy(id = "Renewables")
	private WebElement renewables;

	// Sales channel Element.
	@FindBy(id = "multiple_select_SalesChannels")
	private WebElement salesChannelElement;

	// Sales channel Element Div.
	@FindBy(id = "//div[@id='multiple_select_SalesChannels']")
	private WebElement salesChannelElementDiv;

	// Sales channel Options.
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-13')]")
	private List<WebElement> salesChannelOptions;

	// Sales channel Input.
	@FindBy(xpath = "//div[@id='multiple_select_SalesChannels']/div/input[contains(@ng-model,'$select.search')]")
	private WebElement salesChannelInput;

	// Customer Type Element.
	@FindBy(id = "multiple_select_CustomerTypes")
	private WebElement custTypeElement;

	// Customer Type Element Div.
	@FindBy(xpath = "//div[@id='multiple_select_CustomerTypes']")
	private WebElement custTypeElementDiv;

	// Customer Type Options.
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-14')]")
	private List<WebElement> custTypeOptions;

	// Customer Type Input.
	@FindBy(xpath = "//div[@id='multiple_select_CustomerTypes']/div/input[contains(@ng-model,'$select.search')]")
	private WebElement custTypeInput;

	// Commission Type Element.
	@FindBy(id = "single_select_CommissionType")
	private WebElement commissionTypeElement;

	// Finding object select Commission Type.
	@FindBy(xpath = "//div[contains(@id,'ui-select-choices-row-15')]")
	private List<WebElement> commissionTypeOptions;

	// Finding object select Commission Type Input.
	@FindBy(xpath = "//div[@id='single_select_CommissionType']/input[contains(@ng-model,'$select.search')]")
	private WebElement commissionTypeInput;

	// Finding object Commission Amount.
	@FindBy(id = "CommissionAmount")
	private WebElement commissionAmount;

	@FindBy(xpath = "//label[contains(text(),'Commission Amount')]/..//input[1]")
	private WebElement commissionAmountInput;

	// Finding object select Link Rate Details.
	@FindBy(id = "LinkRateDetails")
	private WebElement linkRateDetails;

	// Next Button.
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Next')]")
	private WebElement nextButton;

	// Cancel Button.
	@FindBy(xpath = "//button[@type='button' and contains(text(),'Cancel')]")
	private WebElement cancelButton;

	// Cancel Add Product Button.
	@FindBy(xpath = "//button[contains(text(),'Cancel Product Add')]")
	private WebElement cancelAddProductButton;

	// Save Add Product Button.
	@FindBy(xpath = "//button[contains(text(),'Save Product')]")
	private WebElement saveAddProductButton;

	// button[contains(text(),'Cancel Product Add')]

	// Error message.
	@FindBy(xpath = "//span[contains(text(),'Error')]")
	private WebElement errorMessage;

	// Error message close icon.
	@FindBy(xpath = "//span[contains(text(),'Close')]/..")
	private WebElement errorMessageCloseIcon;

	// Error message text.
	@FindBy(xpath = "//span[contains(text(),'Error')]/../following-sibling::div//td[2]")
	private WebElement errorMessageText;

	// Add product label.
	@FindBy(xpath = "//h4[contains(@class,'no-margin ng-binding ng-scope')]")
	private WebElement addProductlabel;

	// Finding object Information pop when no matching record found.
	@FindBy(xpath = "//span[contains(.,'Information')]")
	private WebElement informationPopUpErrorMessage;

	// Finding object Information pop up message.
	@FindBy(xpath = "//td[@class='p-md ng-binding']")
	private WebElement infoMessage;

	// Finding object Information pop up message close.
	@FindBy(xpath = "//span[contains(text(),'Information')]/following-sibling::div/a/span[contains(text(),'Close')]")
	private WebElement infoMessageClose;

	// Finding object Product code in product details confirmation page.
	@FindBy(xpath = "//h4[contains(.,'Product Code:')]")
	private WebElement productCodeConfirmationPage;

	// Finding object Product name in product details confirmation page.
	@FindBy(xpath = "//h4[contains(.,'Product Name:')]")
	private WebElement productNameConfirmationPage;

	// Finding object Product Description in product details confirmation page.
	@FindBy(xpath = "//h5[contains(.,'Product Description')]/following-sibling::small[contains(@class,'ng-binding')]")
	private WebElement productDescriptionConfirmationPage;

	// Finding object Product Tag Line in product details confirmation page.
	@FindBy(xpath = "//h5[contains(.,'Product Tag Line')]/following-sibling::small[contains(@class,'ng-binding')]")
	private WebElement productTagLineConfirmationPage;

	// Finding object Product Confirmation page Webtable.
	@FindBy(xpath = "//table[contains(@class,'table table-bordered')]/tbody")
	private WebElement webtableConfirmationScreen;

	// Finding object modify product attributes.
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Modify Product Attributes')]")
	private WebElement modifyProductAttributes;

	// set product code.
	public void setProductCode(String var) {
		productCode.clear();
		productCode.sendKeys(var);
	}

	// get add product label.
	public WebElement getAddProductLabel() {
		return addProductlabel;
	}

	// get product code.
	public WebElement getProductCode() {
		return productCode;
	}

	// set product name.
	public void setProductName(String var) {
		productName.clear();
		productName.sendKeys(var);
	}

	// get product name.
	public WebElement getProductName() {
		return productName;
	}

	// get product description.
	public WebElement getProductDescription() {
		return productDescription;
	}

	// get Renewables.
	public WebElement getRenewables() {
		return renewables;
	}

	// get GuaranteedSaving.
	public WebElement getGuaranteedSavings() {
		return guaranteedSavings;
	}

	// set product description.
	public void setProductDescription(String var) {
		productDescription.clear();
		productDescription.sendKeys(var);
	}

	// get product tag line
	public WebElement getProductTagLine() {
		return productTagLine;
	}

	// set product Tag Line.
	public void setProductTagLine(String var) {
		productTagLine.clear();
		productTagLine.sendKeys(var);
	}

	// get effective date calendar icon.
	public WebElement getEffectiveDateCalendarIcon() {
		return effectiveDateCalendarIcon;
	}

	// set effective date calendar icon.
	public void setEffectiveDateCalendarIcon(String var) {
		effectiveDateCalendarDiv.findElement(
				By.xpath("//a[@data-value='" + var + "']")).click();
	}

	// set effective date.
	public void setEffectiveDate(String startDate) {
		effectiveDate.clear();
		effectiveDate.sendKeys(startDate);
	}

	// set expiration date.
	public void setExpirationDate(String endDate) {
		expirationDate.clear();
		expirationDate.sendKeys(endDate);
	}

	// select no expiration date.
	public void setNoExpDate() {
		noExpirationDate.click();
	}

	// get no expiration date check box.
	public WebElement getNoExpDate() {
		return noExpirationDate;
	}

	// get Contract Source element.
	public WebElement getContractSourceElement() {
		return contractSourceElement;
	}

	// get Contract Source Span element.
	public WebElement getContractSourceSpanElement() {
		return contractSourceSpanElement;
	}

	// get Contract Source options.
	public List<WebElement> getContractSourceOptions() {
		return contractSourceOptions;
	}

	// get Product Type element.
	public WebElement getProductTypeElement() {
		return productTypeElement;
	}

	// get Product Type span element.
	public WebElement getProductTypeSpanElement() {
		return productTypeElement;
	}

	// get Product Type options.
	public List<WebElement> getProductTypeOptions() {
		return productTypeOptions;
	}

	// get Product Type Input.
	public WebElement getProductTypeInput() {
		return productTypeInput;
	}

	// get Service Type element.
	public WebElement getServiceTypeElement() {
		return serviceTypeElement;
	}

	// get Service Type options.
	public List<WebElement> getServiceTypeOptions() {
		return serviceTypeOptions;
	}

	// get Service Type input.
	public WebElement getServiceTypeInput() {
		return serviceTypeInput;
	}

	// get Pricing Assignment element.
	public WebElement getPricingAssignmentElement() {
		return pricingAssignmentElement;
	}

	// get Pricing Assignment options.
	public List<WebElement> getPricingAssignmentOptions() {
		return pricingAssignmentOptions;
	}

	// get Pricing Assignment input.
	public WebElement getPricingAssignmentInput() {
		return pricingAssignmentInput;
	}

	// get Rollover Product element.
	public WebElement getRolloverProductElement() {
		return rolloverProductElement;
	}

	// get Rollover Product options.
	public List<WebElement> getRolloverProductOptions() {
		return rolloverProductOptions;
	}

	// get Rollover Product input.
	public WebElement getRolloverProductInput() {
		return rolloverProductInput;
	}

	// get Product Terms In Months element.
	public WebElement getProductTermsInMonthsElement() {
		return productTermsInMonthsElement;
	}

	// get Product Terms In Months options.
	public List<WebElement> getProductTermsInMonthsOptions() {
		return productTermsInMonthsOptions;
	}

	// get Product Terms In Months input.
	public WebElement getProductTermsInMonthsInput() {
		return productTermsInMonthsInput;
	}

	// get promo allowed element.
	public WebElement getPromoAllowedElement() {
		return allowPromotions;
	}

	// get enrollment only element.
	public WebElement getEnrollmentOnlyElement() {
		return enrollmentOnly;
	}

	// get auto renew only element.
	public WebElement getAutoRenewOnlyElement() {
		return autoRenewOnly;
	}

	// get sales channels element.
	public WebElement getSalesChannelsElement() {
		return salesChannelElement;
	}

	// get sales channels element div.
	public WebElement getSalesChannelsElementDiv() {
		return salesChannelElementDiv;
	}

	// get sales channels options.
	public List<WebElement> getSalesChannelsOptions() {
		return salesChannelOptions;
	}

	// get sales channels input.
	public WebElement getSalesChannelsInput() {
		return salesChannelInput;
	}

	// get customer type element.
	public WebElement getCustomerTypeElement() {
		return custTypeElement;
	}

	// get customer type div.
	public WebElement getCustomerTypeElementDiv() {
		return custTypeElementDiv;
	}

	// get customer type options.
	public List<WebElement> getCustomerTypeOptions() {
		return custTypeOptions;
	}

	// get customer type input.
	public WebElement getCustomerTypeInput() {
		return custTypeInput;
	}

	// get commission type element.
	public WebElement getCommissionTypeElement() {
		return commissionTypeElement;
	}

	// get commission type options.
	public List<WebElement> getCommissionTypeOptions() {
		return commissionTypeOptions;
	}

	// get commission type input.
	public WebElement getCommissionTypeInput() {
		return commissionTypeInput;
	}

	// get commission amount input element.
	public WebElement getCommissionAmountElement() {
		return commissionAmountInput;
	}

	// get commission amount input element.
	public WebElement getCommissionAmountEditBox() {
		return commissionAmount;
	}

	// get Next button element.
	public WebElement getNextButton() {
		return nextButton;
	}

	// get Cancel button element.
	public WebElement getCancelButton() {
		return cancelButton;
	}

	// get Cancel Add Product button element.
	public WebElement getCancelAddProductButton() {
		return cancelAddProductButton;
	}

	// get Save Add Product button element.
	public WebElement getSaveAddProductButton() {
		return saveAddProductButton;
	}

	// get all error object count.
	public boolean hasError(WebElement el) {
		if (el.findElement(By.xpath("..")).getAttribute("class")
				.contains("has-error")) {
			return true;
		}
		return false;
	}

	public String getCounterText(WebElement el) {
		return el.findElement(By.xpath("following-sibling::span")).getText();
	}

	public boolean verifyErrorMessageAndClose(String errorMsg) {
		if (errorMessage.isDisplayed()
				&& errorMessageText.getText().trim().equalsIgnoreCase(errorMsg)) {
			errorMessageCloseIcon.click();
			getErrorClose();
			return true;
		}
		return false;
	}

	// Getting element error message close.
	public void getErrorClose() {
		try {
			while (Element.isVisible(driver, errorMessageCloseIcon)) {
				Element.clickJS(driver, errorMessageCloseIcon);
				if (!errorMessageCloseIcon.isDisplayed()) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public WebElement getInputFieldForSingleSelect(WebElement el) {
		return el.findElement(By.xpath("input[1]"));
	}

	public WebElement getInputFieldForMultipleSelect(WebElement el) {
		return el.findElement(By.xpath("div/input"));
	}

	// Information message pop up, message verification.
	public boolean informationMessageBox(String infoMsg) {
		if (Element.isVisible(driver, informationPopUpErrorMessage)
				&& infoMessage.getText().contains(infoMsg))
			return true;
		else
			return false;
	}

	// Getting element information message close.
	public void infoMessageClose() {
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

	// Highlight All UI Object for Create Product Page.
	public void allUiObjectExistAddProduct() {
		Element.highlightElement(driver, productCode);
		Element.highlightElement(driver, productName);
		Element.highlightElement(driver, productDescription);
		Element.highlightElement(driver, productTagLine);
		Element.highlightElement(driver, effectiveDateCalendarIcon);
		Element.highlightElement(driver, expirationDateCalendarIcon);
		Element.highlightElement(driver, noExpirationDate);
		Element.highlightElement(driver, contractSourceElement);
		Element.highlightElement(driver, productTypeElement);
		Element.highlightElement(driver, serviceTypeElement);
		Element.highlightElement(driver, pricingAssignmentElement);
		Element.highlightElement(driver, rolloverProductElement);
		Element.highlightElement(driver, productTermsInMonthsElement);
		Element.highlightElement(driver, allowPromotions);
		Element.highlightElement(driver, enrollmentOnly);
		Element.highlightElement(driver, autoRenewOnly);
		Element.highlightElement(driver, guaranteedSavings);
		Element.highlightElement(driver, renewables);
		Element.highlightElement(driver, salesChannelElement);
		Element.highlightElement(driver, custTypeElement);
		Element.highlightElement(driver, commissionTypeElement);
		Element.highlightElement(driver, commissionAmount);
		Element.highlightElement(driver, linkRateDetails);
		Element.highlightElement(driver, nextButton);
	}

	// ---------------------Product Confirmation page object function

	/**
	 * Gets the Product Code as parameter and match with application
	 * confirmation page.
	 *
	 * @param product
	 *            text
	 * @return the true: in case code found false: in case data not found.
	 */
	public boolean matchProductCodeConfirmationScreen(String codeText) {
		if (Element.isVisible(driver, productCodeConfirmationPage)
				&& productCodeConfirmationPage.getText().trim()
						.equalsIgnoreCase("Product Code: " + codeText)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the Product Name as parameter and match with application
	 * confirmation page.
	 *
	 * @param product
	 *            text
	 * 
	 * @return the true: in case name found false: in case data not found.
	 */
	public boolean matchProductNameConfirmationScreen(String codeText) {
		if (Element.isVisible(driver, productNameConfirmationPage)
				&& productNameConfirmationPage.getText().trim()
						.equalsIgnoreCase("Product Name: " + codeText)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the Product Description as parameter and match with application
	 * confirmation page.
	 *
	 * @param product
	 *            text
	 * 
	 * @return the true: in case Description found false: in case data not
	 *         found.
	 */
	public boolean matchProductDescriptionConfirmationScreen(String codeText) {
		if (Element.isVisible(driver, productDescriptionConfirmationPage)
				&& productDescriptionConfirmationPage.getText().trim()
						.equalsIgnoreCase(codeText)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the Product Tag Line as parameter and match with application
	 * confirmation page.
	 *
	 * @param product
	 *            text
	 * 
	 * @return the true: in case Product Tag Line found false: in case data not
	 *         found.
	 */
	public boolean matchProductTagLineConfirmationScreen(String codeText) {
		if (Element.isVisible(driver, productTagLineConfirmationPage)
				&& productTagLineConfirmationPage.getText().trim()
						.equalsIgnoreCase(codeText)) {
			return true;
		}
		return false;
	}

	public WebElement getWebTableInProdConfirmationScreen() {
		return webtableConfirmationScreen;
	}

	/**
	 * Gets the Modify product parameter Element on.
	 */

	public WebElement getModifyProductParameter() {
		return modifyProductAttributes;
	}

	public boolean errorMessage() {
		// TODO Auto-generated method stub
		return errorMessage.isDisplayed();
	}
}
