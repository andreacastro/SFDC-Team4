package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium.course.common.Globals.TIMEOUT_MIN;
import com.selenium.course.framework.DriverManager;
import static com.selenium.course.common.Globals.TIMEOUT_NORMAL;

public class CampaignEdit {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h1[contains(.,'Campaign Edit:')]")
    @CacheLookup
	WebElement campaignDetailTable;
	
	public CampaignEdit() {
		wait = DriverManager.getInstance().getWait();
		driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		try {
			wait.withTimeout(TIMEOUT_MIN, TimeUnit.SECONDS).until(
					ExpectedConditions.visibilityOf(campaignDetailTable));
		} catch (WebDriverException e) {
			throw new WebDriverException(e);
		} finally {
			wait.withTimeout(TIMEOUT_NORMAL, TimeUnit.SECONDS);
		}
	}

}
