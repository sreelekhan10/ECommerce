package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidLoginPage {
@FindBy(xpath="//input[@type='text']")
private WebElement untb;
@FindBy(xpath="//input[@type='password']")
private WebElement pwd;
@FindBy(xpath="//span[text()='Login']")
private WebElement login;
@FindBy(xpath="//p[text()='The Email field must contain a valid email address.']")
private WebElement errormsg;
public ValidLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public void verifyErrMsg()
{try {
	Thread.sleep(8000);
} catch (InterruptedException e) {
	e.printStackTrace();
}
	
	Assert.assertTrue(errormsg.isDisplayed());
	
}
public void setUserName(String un)
{
	untb.sendKeys(un);
}
public void setPassWord(String pw)
{
	pwd.sendKeys(pw);
}
public void clickLogin() throws InterruptedException
{Thread.sleep(10000);
	login.click();
}
public void cl()
{
	untb.clear();
	pwd.clear();
}
}
