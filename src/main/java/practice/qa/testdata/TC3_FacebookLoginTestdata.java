package practice.qa.testdata;

import practice.qa.util.Xls_Reader;

public class TC3_FacebookLoginTestdata {

	public Xls_Reader fb = new Xls_Reader(System.getProperty("user.dir")+"\\FrameworkTest.xlsx");
	public String wrongEmail = fb.getCellData("LoginTest", 1, 2);
	public String wrongPassword = fb.getCellData("LoginTest", 1, 3);
	public String FBMainErr = fb.getCellData("LoginTest", 1, 9);
}
