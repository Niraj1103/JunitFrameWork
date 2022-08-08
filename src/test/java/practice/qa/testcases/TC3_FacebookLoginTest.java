package practice.qa.testcases;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import practice.qa.base.TestBase;
import practice.qa.pages.TC3_FacebookLoginPage;
import practice.qa.testdata.TC3_FacebookLoginTestdata;

public class TC3_FacebookLoginTest extends TestBase {

	TC3_FacebookLoginPage tc3 = new TC3_FacebookLoginPage();
	TC3_FacebookLoginTestdata td3 = new TC3_FacebookLoginTestdata();
	
	@Before
	public void before() throws IOException {
		openBrowser();
		tc3.openFacebookPage();
	}
	
	@After
	public void after() {
		closeBrowser();
	}
	
	@Test
	public void loginWithWrongEmailTest() {
		tc3.FacebookLogin(td3.wrongEmail, td3.wrongPassword);
		System.out.println(tc3.readMainErr());
		Assert.assertEquals(tc3.readMainErr(), td3.FBMainErr);
	}
	
	@Test
	public void loginWithEmptyEmail() {
		tc3.FacebookLogin("", td3.wrongPassword);
		System.out.println(tc3.readMainErr());
		Assert.assertEquals(tc3.readMainErr(), td3.FBMainErr);
	}
	
	@Test
	public void loginWithEmptyPass() {
		tc3.FacebookLogin(td3.wrongEmail, "");
		System.out.println(tc3.readMainErr());
		Assert.assertEquals(tc3.readMainErr(), td3.FBMainErr);
		//Assert.assertEquals(tc3.readMainErr(), "Wrong Credentials");
	}
	
	@Test
	public void clickOnLink() {
		tc3.PageTitle();
		tc3.TermsLink();
		tc3.PageTitle();
	}
}
