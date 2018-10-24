package script;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Gridd {

@Parameters({"node","browser"})
@Test
public void test(String node,String browser) throws MalformedURLException
{
	URL url=new URL(node);
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setBrowserName(browser);
	WebDriver driver=new RemoteWebDriver(url,dc);
	driver.get("http://localhost/login.do");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 WebElement un = driver.findElement(By.name("username"));
	 for(int i=1;i<=10;i++){
	un.sendKeys("admin");
}
	 driver.quit();
}
}