package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.utilities.Readconfig;

public class BaseClass {
	Readconfig readdata = new Readconfig();

	public String BaseUrl = readdata.getApplicationURL();
	public String Username = readdata.getUsername();
	public String Password = readdata.getPassword();
	public static Logger logger;

	/* WebDriver is already Initiated here */
	public static WebDriver driver;

	//@Parameters("browser") // "browser" same variable used in xml file
	//@BeforeClass
	/*
	 * Setup() will take the parameters from testng.xml file to read the
	 * browser.
	 */
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		/*System.getProperty("path.separator"); The getProperty method returns a string containing the value of the property. If
		the property does not exist, this version of getProperty returns null.
									 */

		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readdata.getchromeDriver());
			/*
			 * Create the object of the chromeDriver class and Lanunch the
			 * chrome Browser
			 */
			driver = new ChromeDriver();
		}

		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readdata.getfirefoxDriver());
			/*
			 * Create the object of the chromeDriver class and Lanunch the
			 * chrome Browser
			 */
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
			driver = new FirefoxDriver();
		}

		else if (br.equals("ie")) {

			System.setProperty("webdriver.ie.driver", readdata.getIEDriver());
			driver = new InternetExplorerDriver();
		}
		driver.get(BaseUrl);

		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileHandler.copy(Source, target);
		System.out.println("Screenshot taken");

	}
	
}
