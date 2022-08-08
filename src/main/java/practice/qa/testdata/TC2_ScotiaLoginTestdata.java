package practice.qa.testdata;

import practice.qa.util.Xls_Reader;

public class TC2_ScotiaLoginTestdata {
	public Xls_Reader lt = new Xls_Reader(System.getProperty("user.dir")+"\\FrameworkTest.xlsx");
	public String wrongEmail = lt.getCellData("LoginTest", 1, 2);
	public String wrongPassword = lt.getCellData("LoginTest", 1, 3);
	public String emailWithSpeacialChar = lt.getCellData("LoginTest", 1, 4);
	public String globalErr = lt.getCellData("LoginTest", 1, 5);
	public String specialCharEmailErr = lt.getCellData("LoginTest", 1, 6);
	public String emptyEmailErr = lt.getCellData("LoginTest", 1, 7);
	public String emptyPasswordErr = lt.getCellData("LoginTest", 1, 8);

}
