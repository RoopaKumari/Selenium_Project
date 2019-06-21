package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class TC069_DataProvider {
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData(){
	//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
	String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning\\Project\\ComplexTestcases\\Testdata.xlsx";
	String sheetName ="Sheet3";
	return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
}
