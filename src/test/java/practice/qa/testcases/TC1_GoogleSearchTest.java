package practice.qa.testcases;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import practice.qa.base.TestBase;
import practice.qa.pages.TC1_GoogleSearchPage;
import practice.qa.testdata.TC1_GoogleSearchTestdata;

public class TC1_GoogleSearchTest extends TestBase {

	TC1_GoogleSearchTestdata td1 = new TC1_GoogleSearchTestdata();
	TC1_GoogleSearchPage tc1 = new TC1_GoogleSearchPage();
	static ExtentTest Test1;
	static ExtentReports reports;
	
	@org.junit.BeforeClass
	public static void beforeClass() {
		reports = getReports();
		Test1 = reports.createTest("TC1GoogleSearchTest");
	}
	
	@org.junit.AfterClass
	public static void afterClass() {
		reports.flush();
	}
	
	@Before
	public void openWindow() throws IOException {
		Test1.log(Status.INFO, "Opening Browser and Google Page");
		openBrowser();
		tc1.openGooglePage();
		tc1.clickStoreLink();
	}
	
	@After
	public void closeWindow() {
		closeBrowser();
	}
	
	@Test 
	public void search1() {
		Test1.log(Status.INFO, "Searching For Phone on Google Store");
		tc1.search(td1.search1);
		Assert.assertEquals(td1.searchresult1, tc1.searchResult());
	}
	
	@Test
	public void search2() {
		Test1.log(Status.INFO, "Searching For Laptop on Google Store");
		tc1.search(td1.search2);
		Assert.assertEquals(td1.searchresult2, tc1.searchResult());
	}
	
	@Test
	public void search3() {
		Test1.log(Status.INFO, "Searching For EarPhone on Google Store");
		tc1.search(td1.search3);
		Assert.assertEquals(td1.searchresult3, tc1.searchResult());
	}
}
