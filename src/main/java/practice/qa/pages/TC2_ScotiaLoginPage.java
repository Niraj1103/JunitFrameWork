package practice.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.qa.base.TestBase;
import practice.qa.util.TestUtil;

public class TC2_ScotiaLoginPage extends TestBase {

	@FindBy(id= "usernameInput-input")
	public WebElement email;
	
	@FindBy(id = "password-input")
	public WebElement password;
	
	@FindBy(id = "signIn")
	public WebElement signIn;
	
	//@FindBy(id = "globalError")
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement globalError;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement userNameError;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordError;
	
	
	public void openLoginPage(){
		PageFactory.initElements(driver, this);
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=jL-v9FcFGzE&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJqTC12OUZjRkd6RSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjUyNTUzOTEzLCJpYXQiOjE2NTI1NTI3MTMsImp0aSI6IjAyOTViYjI3LTQ3OTItNDBlZS1hYmVhLTg0MjI5NDM0ZmQ2ZiIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.ZQ0pwjALzLD4tECphutYvY3IkAmx6TnfkfBILA60QxRXUXH3CiBuhOHAnk8Pgukmwv_lKTCAJXJVTT4JBVz-e1ee_aKmPM5jFEEFacR9hAQdFXdduqaX_FZE5AYoeRgHubm7EbZES_IOVGg7wD5BWrJyujETndQGIlv3L3pDAEcf5Vmb0KoUJEQVlqY97af6khKIkFq1x4mcgQfrCnF392WmGxHXTSizJAc8_wglNz6fKOPmahbCXtFvlm3OXRaDMm2yHqYeYQpwuyFykNbKnG_5u-CPd5Rjx5hN5NUdYBBEmKgkpOPYAzmOdTiu2q1FBOcfcEmwvBWo52DPuQu2Gg&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIMEOUT));
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) {
		email.sendKeys(a);
		password.sendKeys(b);
		signIn.click();
	}
	
	public String readGlobalErr() {
		String actualErr = driver.findElement(By.xpath("//div[@class='_34WxBISkwjz3EHuywThA6R']//h1")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readGlobalErr2() {
		String actualErr = globalError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readEmailErr() {
		String actualErr = userNameError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readPasswordErr() {
		String actualErr = passwordError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
