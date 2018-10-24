package generic;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public abstract class BaseTest implements IautoInt{
    public WebDriver driver;
    static{
    	System.setProperty(chrome_key,chrome_value);
    	System.setProperty(gecko_key, gecko_value);
    }
 /*   @Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String node,String browser) throws Exception{
    	Logger l=Logger.getLogger("BaseTest");
		URL remote=new URL(node);
		DesiredCapabilities d=new DesiredCapabilities();
		d.setBrowserName(browser);
		driver=new RemoteWebDriver(remote,d);
		String url = Library.getProperty(config,"URL");
		driver.get(url);
		String sITO = Library.getProperty(config,"ITO");
		long lITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(lITO,TimeUnit.MINUTES);
	}*/
   @Parameters("browser")
    @BeforeMethod
     public void openApplication(String browser)
     {if(browser.equals("firefox"))
    	driver=new FirefoxDriver();
     else
     {
    	 driver=new ChromeDriver();
     }
    	String url = Library.getProperty(config,"URL");
		driver.get(url);
		String sITO = Library.getProperty(config,"ITO");
		long lITO = Long.parseLong(sITO);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(lITO,TimeUnit.SECONDS);

     }
	@AfterMethod(alwaysRun=true)
	public void closeApplication() throws Exception{
		Thread.sleep(1000);
		driver.quit();
	}}