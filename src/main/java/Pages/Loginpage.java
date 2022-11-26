package Pages;

import org.openqa.selenium.By;

import com.excelr.base.Baseclass;

public class Loginpage extends Baseclass {
	
	public DashboardPage login(String uname, String pwd) {
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		capturescreenshot("bfrlogin");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DashboardPage();
		
	}
//------------------------------------------------------------------------------------------	
	public boolean getlogo() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
	}
	
	
//-------------------------------------------------------------
	public String getTitle() {
		return driver.getTitle();	
	}


}
