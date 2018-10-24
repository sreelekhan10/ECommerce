package script;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Library;
import page.ValidLoginPage;
//invalidTESTCASE
@Listeners(script.Listenercase.class)
public class TestLogin extends BaseTest {

@Test
public void inValidLog1() 
{
	System.out.println(Thread.currentThread().getId());
int rc=Library.getRowCount(xl_path,"TestLogin");
	for(int i=1;i<=rc;i++){
	 String un = Library.getCellValue(xl_path,"TestLogin",i,0);
	String pw=Library.getCellValue(xl_path,"TestLogin",i,1);
	 ValidLoginPage v=new ValidLoginPage(driver);
	v.setUserName(un);
	v.setPassWord(pw);
	try {
		v.clickLogin();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	v.verifyErrMsg();
	v.cl();

}}
}


