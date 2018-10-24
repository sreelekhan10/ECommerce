package script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestVerify {
	public static void main(String[] args) throws Exception {
		
	
	
		File f=new File("./data/input.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fs);
	//Sheet TestLogin=wb.getSheetAt(0);
	//TestLogin.getRow(1).createCell(2).setCellValue("pass");
	//TestLogin.getRow(2).createCell(2).setCellValue("pass");
	//TestLogin.getRow(3).createCell(2).setCellValue(12);
		wb.getSheet("TestLogin").getRow(1).createCell(2).setCellValue("pass");
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();

}}
