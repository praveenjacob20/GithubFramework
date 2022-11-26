package Framework;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.excelr.base.Baseclass;
import com.excelr.base.Forgetpasswordtest;
import Pages.DashboardPage;
import Pages.Loginpage;
public class TestNGframework extends Baseclass {
	Loginpage lp;
	DashboardPage dp;
	Forgetpasswordtest fp;
	
	@BeforeMethod
	public void openwebpage() throws IOException {
		initialization();
		lp = new Loginpage();
		fp = new Forgetpasswordtest();
	}
//------------------------------------------------------	
	@Test
	public void Validatelogin() {
		dp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actUrl = dp.getdashboardurl();
		Assert.assertEquals(actUrl, expUrl);
		
	}
//--------------------------------------------------------	
	@Test
	public void validatelogo() {
		boolean logo = lp.getlogo();
		Assert.assertTrue(logo);	
	}
//---------------------------------------------------------	
	@Test
	public void validategettitle() {
		String actTitle = lp.getTitle();
		String expTitle = "OrangeHRM";
		Assert.assertEquals(actTitle, expTitle);
	}
//---------------------------------------------------------
	@Test
	public void forgetpassword() {
		fp.forgetpassword();
	}
//------------------------------------------------------------	
	@AfterMethod
	public void closedriver() {
		tearDown();
	}
}
