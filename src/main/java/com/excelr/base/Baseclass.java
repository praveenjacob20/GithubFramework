package com.excelr.base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	public static Properties prop;

	public void loadfileinputstream() throws IOException {
		String configpath = "./src/main/java/com/excelr/config/config.properties";
		FileInputStream fis = new FileInputStream(configpath);
		prop = new Properties();
		prop.load(fis);
	}
//--------------------------------------------------------------------------------------------
	public void initialization() throws IOException {
		loadfileinputstream();
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browsername.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
	}
//--------------------------------------------------------------------------------
	  public void capturescreenshot(String testcaseName) { 
		//casting: to change the type
		  TakesScreenshot ssc = (TakesScreenshot)driver; 
		  File file = ssc.getScreenshotAs(OutputType.FILE);
	 String fileName = "./Screenshot/" + testcaseName +".png"; 
	 try {
		 FileUtils.copyFile(file, new File(fileName));
		 } 
	 catch (IOException e) 
	 {
		 //TODO Auto-generated catch block 
		 e.printStackTrace(); 
	 		}
	 }
//----------------------------------------------------------------------------------------
	public void tearDown() {
		driver.quit();
	}
}
