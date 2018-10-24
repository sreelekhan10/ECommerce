package page;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountsPage {
@FindBy(xpath="//a[@href='#ACCOUNTS']")
private WebElement acc;
@FindBy(xpath="//a[text()='Admins']")
private WebElement admin;
@FindBy(xpath="//button[@type='submit']")
private WebElement addAdmin;
@FindBy(xpath="//input[@name='fname']")
private WebElement fname;
@FindBy(xpath="//input[@name='lname']")
private WebElement lname;
@FindBy(xpath="//input[@name='email']")
private WebElement email;
@FindBy(xpath="//input[@name='password']")
private WebElement pwd;
@FindBy(xpath="//input[@name='mobile']")
private WebElement mbl;
@FindBy(xpath="//select[@name='country']")
private WebElement countr;
@FindBy(name="status")
private WebElement dropstatus;
@FindBy(xpath="//input[@value='addHotels' ]/..//ins[@class='iCheck-helper']")
private WebElement addHotel;
@FindBy(xpath="//div[@class='panel-footer']//button[text()='Submit']")
private WebElement submit;
public AccountsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public void clickAccount() {
	
acc.click();
}
public void adminFea(String fnam,String lnam,String emailid,String passwrd,String mobile,WebDriver driver)
{
	admin.click();
	addAdmin.click();
	fname.sendKeys(fnam);
	lname.sendKeys(lnam);
	email.sendKeys(emailid);
	pwd.sendKeys(passwrd);
	mbl.sendKeys(mobile);
	Select s1=new Select(countr);
	s1.selectByVisibleText("India");
	List<WebElement> all = s1.getOptions();
	int count = all.size();
	System.out.println(count);
		for (int i = 0; i < count; i++) {
			 WebElement options = all.get(i);
			String text = options.getText();
			System.out.println(text);
		}
		
	dropstatus.click();
	Select s2=new Select(dropstatus);
	s2.selectByVisibleText("Enabled");
	JavascriptExecutor j=(JavascriptExecutor )driver;
	j.executeScript("window.scrollBy(0,300)",addHotel);
	addHotel.click();
	submit.click();
}
}