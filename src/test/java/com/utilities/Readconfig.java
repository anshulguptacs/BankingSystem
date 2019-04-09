package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties pro;

	public Readconfig() {
		File src = new File("C:\\Users\\anshul\\workspace\\BankingSystem\\Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}

	}
/*Create all methods based on all variables mentioned in properties file.getProperty("BaseUrl") "BaseUrl" is a case senstive same as 
  in property file.*/
	public String getApplicationURL() {
		String URL = pro.getProperty("BaseUrl");
		return URL;
	}

	public String getUsername() {
		String username = pro.getProperty("Username");
		return username;
	}

	public String getPassword() {
		String Password = pro.getProperty("Password");
		return Password;
	}

	public String getchromeDriver() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getfirefoxDriver() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getIEDriver() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
}
