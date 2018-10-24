package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Library;
import page.HomePage;
import page.ValidLoginPage;

public class TestHome extends BaseTest{
		@Test
		public void ValidBook() throws InterruptedException
		{	String un=Library.getCellValue(xl_path,"TestValid",1,0);
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
				HomePage h=new HomePage(driver);
				h.homeFea(driver);
		}
		}


