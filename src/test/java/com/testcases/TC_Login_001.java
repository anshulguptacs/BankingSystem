package com.testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.pageobject.Login;

public class TC_Login_001 extends BaseClass {
	

		@Test
		public void loginTest() throws IOException {
			/*Step:1 Launch the website*/
			/*This Line we can write in a Baseclass so removed from here*/
			//driver.get(BaseUrl);
			
			//used to log the action
			logger.info("URL is opened");
			/*Create object of login.java class because all page objects/Elements and Methods are present in pageobject class*/
			Login lp = new Login(driver);
			
			/*Calling methods one by one as per our steps and paased the Username,Password and submitBtn from Base class*/
			lp.setUserName(Username);
			logger.info("Entered username");
			
			lp.setUserPassword(Password);
			logger.info("Entered password");
			lp.submitBtn();
			logger.info("clickonsubmitbutton");
		
	}
}


