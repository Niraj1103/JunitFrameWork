package practice.qa.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TC1_GoogleSearchTest.class, 
	TC2_ScotiaLoginTest.class, 
	TC3_FacebookLoginTest.class 
	})

public class TestsSuiteRunner {

}
