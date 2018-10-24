package page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//@FindBy(xpath="//tr[@class='xcrud-th']")
	@FindBy(xpath="//input[@id='select_all']")
private List<WebElement> checkboxes;
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public void homeFea(WebDriver driver) throws InterruptedException
{JavascriptExecutor j=(JavascriptExecutor)driver;
	for(int i=1;i<=3;i++) {
		Thread.sleep(1000);
j.executeScript("window.scrollBy(0,300)",checkboxes);
}
Thread.sleep(1000);
	for(WebElement all:checkboxes)
	{//if(!all.isSelected()) {
		//all.click();
		Actions a=new Actions(driver);
		a.moveToElement(all).click().perform();
		Thread.sleep(2000);
	}
}
}
