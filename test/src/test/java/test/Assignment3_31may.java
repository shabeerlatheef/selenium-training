package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment3_31may {

	public static void main(String[] args) throws IOException {
		FileInputStream fs = new FileInputStream("E:\\java program\\Excel\\sample.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
int cellcount=sheet.getRow(0).getLastCellNum();
System.out.println(sheet.getLastRowNum());
System.out.println(cellcount);
Object ob[][] = new Object[rowCount][cellcount];

        //iterate over all the row to print the data present in each cell.
        for(int i=0;i<rowCount;i++){
            
            //get cell count in a row
            
            //iterate over each cell to print its value
            
            for(int j=0;j<cellcount;j++){
                Cell cell = sheet.getRow(i).getCell(j);
   
switch(cell.getCellType())
{
case Cell.CELL_TYPE_STRING:
    ob[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
    break;
case Cell.CELL_TYPE_NUMERIC:
	 ob[i][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
    break;
	
       default:
    	   System.out.println("Error");}
    	   }
           
        }
        
        System.out.println(Arrays.deepToString(ob));
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
		}

}
*/