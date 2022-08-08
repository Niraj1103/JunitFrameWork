package practice.qa.testcases;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import practice.qa.base.TestBase;
import practice.qa.pages.TC2_ScotiaLoginPage;
import practice.qa.testdata.TC2_ScotiaLoginTestdata;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TC2_ScotiaLoginTest extends TestBase {
	
	TC2_ScotiaLoginTestdata td2 = new TC2_ScotiaLoginTestdata();
	TC2_ScotiaLoginPage tc2 = new TC2_ScotiaLoginPage();
	
	@Before
	public void before() throws IOException {
		openBrowser();
		tc2.openLoginPage();
	}

	@After 
	public void after() {
		closeBrowser();
	}
	
	@Test
	  public void a_loginWithWrongEmailPasswordTest() {
		  tc2.login(td2.wrongEmail, td2.wrongPassword);
		  Assert.assertEquals(tc2.readGlobalErr(), td2.globalErr);
	  }
	  
	  @Test
	  public void b_loginWithSpecialCharEmailTest() {
		  tc2.login(td2.emailWithSpeacialChar,td2.wrongPassword);	  
		  Assert.assertEquals(tc2.readGlobalErr2(), td2.specialCharEmailErr);
	  }
	  
	 @Test
	  public void c_loginWithEmptyEmailTest() {
		 tc2.login("",td2.wrongPassword);
		  Assert.assertEquals(tc2.readEmailErr(), td2.emptyEmailErr);
	  }
	  
	  @Test
	  public void d_loginWithEmptyPasswordTest() {
		  tc2.login(td2.wrongEmail,"");
		  Assert.assertEquals(tc2.readPasswordErr(), td2.emptyPasswordErr);
	}
}
