package com.testcases;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageobject.Login;
import com.utilities.XLUtils;

	public class TC_LoginDDT_002 extends BaseClass
	{

		@Test(dataProvider="LoginData")
		public void loginDDT(String user,String pwd) throws InterruptedException
		{
			Login lp=new Login(driver);
			lp.setUserName(Username);
			lp.setUserPassword(Password);
			lp.submitBtn();
		}
			
			
		@DataProvider(name="LoginData")
		String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/testData/LoginData.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}
		
	}


