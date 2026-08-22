package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//dataProvider 1
	
	@DataProvider(name="LoginData")
	public String[] [] getData() throws IOException
	{	
		
		String path = ".\\testData\\Opencart_LoginData 1.xlsx";  //taking xl file from testData
			
		ExcelUtility xlutil = new ExcelUtility(path);          //creating an object of excelutility class
		
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalcolums = xlutil.getCellCount("Sheet1", 1);
	
		String loginData[] [] = new String[totalRows] [totalcolums];  //created two dimensional array to store the data from excel sheet
		
		
		for(int i=1 ; i<=totalRows ; i++)      // 1.read the data frpm xl storing in two dimesional array
		{
			for(int j=0 ; j<totalcolums ; j++)  // 0. i is rows j is colums
			{
				loginData [i-1] [j] = xlutil.getCellData("Sheet1", i, j);  //1,0
			}
		}
		
		return loginData; // returning two dimensional array
	}
	
//similarly we can add
	
//	//dataprovider 2
//	
//	//dataprovider 3
//	
//	//dataprovider 4
//	
	}


