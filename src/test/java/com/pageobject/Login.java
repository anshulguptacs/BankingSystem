package com.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

		/*Step-1: Create a class/Global/Instance level variable whose type is webdriver i.e.int a Now how to initialized ldriver variable for it we are using a parameter
	    constructor concept because it have different values*/
		 
		WebDriver rdriver;
		
		  /*Step-2: Create constructor with one parameter and rdriver is a local variable*/
		   public Login(WebDriver ldriver) {
		   rdriver = ldriver;  /*this.class variable(ldriver) = Local variable(rdriver) and this keyword is used to represent a class variable.*/
								 					
           /* Step-3:PageFactory is used to initialized the webElements */
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(id = "email")
		WebElement txtname;

		@FindBy(id = "pass")
		WebElement enterpwd;

		@FindBy(id = "u_0_2")
		WebElement submitbtn;

		/* Create action methods of all above webElements */

		public void setUserName(String uname) {
			txtname.sendKeys(uname);
		}

		public void setUserPassword(String password) {
			enterpwd.sendKeys(password);
		}

		public void submitBtn() {
			submitbtn.click();
		}
	}


