package com.selenium.course.testng;

import com.selenium.course.pages.ChatterPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.MainApp;
import com.selenium.course.pages.PageMenuBar;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class DeletePostChat {
	private LoginPage loginPage;
	private MainApp mainApp;
	private PageMenuBar pageMenuBar;
	private ChatterPage chatterPage;

	String postContent;

	@BeforeClass
    public void setUp() {
		loginPage = new LoginPage();
		mainApp = loginPage.loginAsPrimaryUser();
        pageMenuBar = mainApp.goToPageMenuBar();
		chatterPage = pageMenuBar.clickChatter();
		postContent = "+++++++++++++++ This Post needs to be deleted ++++++++++++";
		chatterPage.createAnewPost(postContent);
		chatterPage.refreshPage();
    }
	
	@Test (groups = {"BVT, Acceptance, Funcional"})
    public void deleteLatestPost() {
		chatterPage.expandLatestDropDown();
		chatterPage.removeLatestPost();
		chatterPage.refreshPage();
		assertTrue(chatterPage.verifyNewPostIsDeleted(postContent));
	}
	
	@AfterClass
    public void tearDown() {
		chatterPage.closeDialog();
    }

}
