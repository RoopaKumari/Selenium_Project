package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getCategoryName(); 
			obj[3] = temp.getCategoryDescription(); 
			obj[4] = temp.getMetaTagTitle(); 
			obj[5] = temp.getMetaTagDescription(); 
			result[count ++] = obj; 
		}
		
		return result;
	}
	
	/*@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning\\Project\\ComplexTestcases/Testdata.xlsx"; 
		String sheetname="Sheet1";

		  
		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName,sheetname);
		  Object[][] result = new Object[retVal.size()][retVal.size()];

	      int count = 0;

	 for(List<Object> temp : retVal){
		if(temp!=null){
	         Object[] obj = new Object[4];
	         obj[0] = temp.get(0);
	         obj[1] = temp.get(1);
	         obj[2] = temp.get(2);
	         obj[3] = temp.get(3);
		 
		  result[count ++] = obj; 
	         }
		 
		  return result; }
	}*/
	

	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData(){
	//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
	String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning\\Project\\ComplexTestcases\\Testdata.xlsx";
	String sheetName ="Sheet1";
	return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	/*@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
	//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
	String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning\\Project\\ComplexTestcases\\Testdata.xlsx";
	String sheetName2 ="Sheet2";
	return new ApachePOIExcelRead().getExcelContent(fileName,sheetName2); 
	}*/
	
	
	
	
	
	
	
	
	/*@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning\\Project\\ComplexTestcases/Testdata.xlsx", "Sheet1"); 
	}*/
}
