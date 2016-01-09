
package datacleaning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Demo {
	static String HEADER = "Date,Time,CrimeType\n";
	public static void main(String[] args) {
	    try {
	        FileInputStream file = new FileInputStream(new File("/home/pj/Desktop/data/Baton_Rouge.xlsx"));
	        FileWriter writer = new FileWriter("/home/pj/Desktop/output/Baton_Rouge.csv");
            writer.append(HEADER);
	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        System.out.println("resche");

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext())
	        {
	            Row row = rowIterator.next();
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();
	            StringBuffer b = new StringBuffer();
	            int colIndex = 0;
	            while (cellIterator.hasNext() && colIndex <= 3) 
	            {
	                Cell cell = cellIterator.next();
	                if(colIndex == 1 || colIndex == 2  ){
	                	b.append(cell.getStringCellValue()+",");
	                }else if(colIndex == 3){
	                	b.append(cell.getStringCellValue()+"\n");
	                }else if(colIndex == 0){
	                	continue;
	                }
	                colIndex++;
	                
	            }
	            writer.append(b);
	            
	        }
	        file.close();
	        writer.flush();
	        writer.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
