package practice.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.qa.base.TestBase;
import practice.qa.util.TestUtil;

public class TC3_FacebookLoginPage extends TestBase {
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "pass")
	public WebElement password;
	
	@FindBy(name = "login")
	public WebElement login;
	
	//Wrong Id and pass
	@FindBy(className = "_9ay7")
	public WebElement MainErr;
	
	@FindBy(linkText = "Terms")
	public WebElement Terms;
	
	
	public void FacebookLogin(String a, String b) {
		email.sendKeys(a);
		password.sendKeys(b);
		login.click();
	}
	
	public String readMainErr() {
		String mainErr = MainErr.getText();
		System.out.println(mainErr);
		return mainErr;
		
	}

	public void openFacebookPage() {
		// TODO Auto-generated method stub
		PageFactory.initElements(driver, this);
		driver.get("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=120&lwc=1348028");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIMEOUT));
	}
	
	public void TermsLink() {
		Terms.click();
	}
	
	public String PageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

}
