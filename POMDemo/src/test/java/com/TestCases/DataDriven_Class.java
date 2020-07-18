package com.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseClass.Library;
import com.ExcelUtility.Excel_Utility;
import com.Pages.OrangeHRM_Login_Page;




public class DataDriven_Class extends Library {
	
	@BeforeClass
	public void start() throws IOException {
		launchApp();
	}
	
	OrangeHRM_Login_Page lgn;
	
	@Test(dataProvider="orangehrm")
	public void OrangeHRMLogin(String username,String pword) throws IOException {
		lgn=new OrangeHRM_Login_Page(driver);
		lgn.Login_username(username);
		lgn.Login_password(pword);
		lgn.Login_button();
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"task-list-group-panel-menu_holder\"]/table/tbody/tr/td")).getText());
		
	}
	@DataProvider(name="orangehrm")
	public Object[][] passData() throws IOException{
		Excel_Utility read=new Excel_Utility();
		Object[][] data = read.ReadData();
		return data;
	}

	@AfterClass
	public void close() {
		closeApp();
	}
	
}
