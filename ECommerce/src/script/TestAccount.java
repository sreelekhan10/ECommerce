package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Library;
import page.AccountsPage;
import page.ValidLoginPage;

public class TestAccount extends BaseTest{
@Test(groups= {"login"})
public void testAccount()
{String un=Library.getCellValue(xl_path,"TestValid",1,0);
String pw=Library.getCellValue(xl_path,"TestValid",1,1);
ValidLoginPage v=new ValidLoginPage(driver);
	v.setUserName(un);
	v.setPassWord(pw);
	try {
		v.clickLogin();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	AccountsPage a=new AccountsPage(driver);
	a.clickAccount();
	String fnam=Library.getCellValue(xl_path,"TestAccount",1, 0);
	String lnam=Library.getCellValue(xl_path,"TestAccount",1, 1);
	String emailid=Library.getCellValue(xl_path,"TestAccount",1, 2);
	String passwrd=Library.getCellValue(xl_path,"TestAccount",1,3);
	String mobile=Library.getCellValue(xl_path,"TestAccount",1,4);
	a.adminFea(fnam,lnam,emailid,passwrd,mobile, driver);
}
}
