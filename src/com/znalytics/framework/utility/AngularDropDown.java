// Copyright - Znalytics (http://www.Znalytics.com/)

package com.znalytics.framework.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.znalytics.framework.core.Logs;

/**
 * @author: Yogi Garg
 * @mail: ygarg@znalytics.com
 * @date: Mar 31, 2015
 * 
 *        purpose of this class to provide all function related to drop down for
 *        angular JS
 * 
 * 
 */

public class AngularDropDown {
	/** The drop list. */

	/**
	 * Gets the drop down option count.
	 *
	 * @return the drop down option count make sure element should be
	 *         like.//*[contains(@id,'ui-select-choices-row-1-')]
	 */
	public int getAngularDropDownOptionCount(List<WebElement> selectElement) {
		int count = selectElement.size();
		Logs.LOGGER.info("Total # of Options in dropdown: " + count);
		return count;
	}

	/**
	 * Gets the drop down options.
	 *
	 * @return the drop down options
	 */
	public List<WebElement> getAngularDropDownOptions(List<WebElement> list) {
		for (int i = 0; i < list.size(); i++) {
			Logs.LOGGER.info("Options in dropdown: " + list.get(i).getText());
			list.add(i, list.get(i));
		}
		return list;
	}

	/**
	 * Checks if is option text present for drop down.
	 *
	 * @param textToFind
	 *            the text to find
	 * @return true, if is option text present for drop down
	 */
	public boolean isOptionTextPresentForAngularDropdown(List<WebElement> list,
			String textToFind) {
		List<WebElement> options = getAngularDropDownOptions(list);
		boolean found = false;
		if (options != null & !options.isEmpty()) {
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(textToFind)) {
					found = true;
					break;
				}
			}
		}
		return found;
	}

	/**
	 * Select drop down option by index.
	 *
	 * @param index
	 *            the index
	 */

	public void selectAngularDropdownOptionByIndex(List<WebElement> list,
			int index) {
		Logs.LOGGER.info("Selecting Dropdown option (index) : " + index);
		list.get(index - 1).click();
	}

	/**
	 * Select drop down option by value.
	 *
	 * @param index
	 *            the index
	 */

	public void selectAngularDropdownOptionByValue(WebElement selectElement,
			String optionText) {
		Logs.LOGGER.info("Selecting Dropdown option (text) : " + optionText);
		selectElement.click();
		selectElement.sendKeys(optionText);
		selectElement.sendKeys(Keys.TAB);
	}

	/**
	 * Clean Drop down value by name.
	 *
	 * @param index
	 *            the index
	 */

	public void clearDropDownElement(WebElement selectElement) {
		List<WebElement> options = selectElement
				.findElements(By
						.xpath("//span[@ng-repeat='$item in $select.selected']//span[@ng-click='$select.removeChoice($index)']"));
		if (options != null & !options.isEmpty()) {
			for (WebElement option : options) {
				option.click();
			}
		}
		Logs.LOGGER.info("Deleted all values from dropdown ");
	}

	/**
	 * Get Selected Drop down value.
	 *
	 * @param index
	 *            the index
	 */

	public String selectedAngularDropDownValue(WebDriver browser,
			String fieldName) {
		WebElement options;
		options = browser.findElement(By.xpath("//div[contains(@id,'"
				+ fieldName
				+ "')]//span[contains(@class,'ng-binding ng-scope')]"));
		return options.getText();
	}

}
