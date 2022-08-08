package practice.qa.testdata;

import practice.qa.util.Xls_Reader;

public class TC1_GoogleSearchTestdata {

	public Xls_Reader lt = new Xls_Reader(System.getProperty("user.dir")+"\\FrameworkTest.xlsx");
	public String search1 = lt.getCellData("LoginTest", 1, 11);
	public String search2 = lt.getCellData("LoginTest", 1, 12);
	public String search3 = lt.getCellData("LoginTest", 1, 13);
	public String searchresult1 = lt.getCellData("LoginTest", 1, 14);
	public String searchresult2 = lt.getCellData("LoginTest", 1, 15);
	public String searchresult3 = lt.getCellData("LoginTest", 1, 16);
}
