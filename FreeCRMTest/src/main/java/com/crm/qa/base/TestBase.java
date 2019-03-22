package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
				prop=new Properties();
				FileInputStream	fis = new FileInputStream("C:\\Users\\bmunagala\\git\\.git\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(fis);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	
	public static void initialization() {
		
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Samsung_Automation\\TestInputs\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "D:\\Samsung_Automation\\TestInputs\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\Samsung_Automation\\TestInputs\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else {
			
			System.out.println("Please set appropriate driver to launch URL");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	
}
