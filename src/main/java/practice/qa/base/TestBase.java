package practice.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import practice.qa.util.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports reports;
//	Logger print = Logger.getLogger("junitTest");
	
public void openBrowser() throws IOException {

		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practice\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(f);
		
//		print.debug("Opeing Browser Window");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",prop.getProperty("jarLocation")+"\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("jarLocation")+"\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("Browser can not be open , Add browser name into properties");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	}
	
	public void closeBrowser() {
//		print.debug("Closing Browser Window");
		driver.quit();
	}
	
	public static ExtentReports getReports() {
		if(reports == null) {
			reports = new ExtentReports();
			
			//init the report folder
			Date d = new Date();
			String FolderName = d.toString().replaceAll(":", "-");
			String reportFolder = System.getProperty("user.dir")+"//extent-reports"+FolderName;
			File f = new File(reportFolder);
			f.mkdir();  //create dynamic report folder
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolder);
			sparkReporter.config().setReportName("Amazon Testing - TestNG FrameWork");
			sparkReporter.config().setDocumentTitle("FrameWork Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");
			
			reports.attachReporter(sparkReporter);
		}
		
		return reports;
	}
	
}
