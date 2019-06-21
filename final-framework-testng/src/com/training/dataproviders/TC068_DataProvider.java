package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class TC068_DataProvider {

	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData(){
	//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
	String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning\\Project\\ComplexTestcases\\Testdata.xlsx";
	String sheetName ="Sheet2";
	return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	
}


