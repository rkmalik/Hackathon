package datacleaning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class XlsDemoOrig {
	//static String HEADER = "offensedate,offensedescription,offensestarttime,offensestreet,offensepremises\n";
	static String HEADER = "DayofWeek,PartofDay,CrimeType\n";
	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\rkmalik\\Desktop\\data\\test.xlsx");
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheetAt(0);
			System.out.println("Read");
			 FileWriter writer = new FileWriter("C:\\Users\\rkmalik\\Desktop\\data\\los_angeles_output.csv");
	            writer.append(HEADER);
			/*HSSFRow row1 = worksheet.getRow(1);
			System.out.println(row1.getCell(3).getStringCellValue());*/
			 Iterator<Row> rowIterator = worksheet.iterator();
			 rowIterator.next();
			 while (rowIterator.hasNext())
		        {
		            Row row = rowIterator.next();
		            //For each row, iterate through all the columns
		            Iterator<Cell> cellIterator = row.cellIterator();
		            StringBuffer b = new StringBuffer();
		            int colIndex = 0;
		            while (cellIterator.hasNext() ) 
		            {
		                Cell cell = cellIterator.next();
		                String s = null;
		                
		                
		                /*else if(colIndex == 2){
		                	s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf((int)cell.getNumericCellValue()) : cell.getStringCellValue() );
		                	if(s==""){
		                		s=null;
		                	}
		                	s+=",";
		                	b.append(s);
		                }*/
		               /* if(colIndex == 2){		                	
		                	//s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf((int)cell.getNumericCellValue()) : cell.getDateCellValue().toString());
		                	Date d = ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? cell.getDateCellValue(): null);
		                	String date = null;
		                	
		                	if(d!=null){
		                		date = String.valueOf(d.getDay());			                				                	
		                	}
		                	b.append(date + ",");
		                	//b.append(time + ",");
		                	 * 
		                	 * 
		                	
		                }else*/ if(colIndex == 2){
		                	s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf((int)cell.getNumericCellValue()) : cell.getStringCellValue() );
		                	//System.out.println(s);
		                	String dateday = dateToDay(s);
		                	b.append(dateday + ",");	
		                } /*else if (colIndex == 1) {
		                	s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue() );
		                	System.out.println(s);
		                	
		                }*/
		                
		                
		                
		                /*else if( colIndex == 1){
		                	s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue() );
		                	Date d = ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? cell.getDateCellValue(): null);
		                	String hours = String.valueOf(d.getHours());
		                	String min = String.valueOf(d.getMinutes());
		                	s = hours +  min;
		                	if(s!=null){
		                		s = timeOfDayLosAngles(s);
		                	}		                			                			                	
		                	b.append(s + ",");
		                }else if(colIndex == 3 ){
		                	s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue() );		                	
		                	s+=",";
		                	b.append(s);
		                }*//*else if(colIndex == 4){
		                	
		                	switch (cell.getCellType()) {
		                    case Cell.CELL_TYPE_STRING:
		                        s = (cell.getRichStringCellValue().getString());
		                        break;
		                    case Cell.CELL_TYPE_NUMERIC:
		                        s = String.valueOf(cell.getNumericCellValue());
		                        break;
		                    case Cell.CELL_TYPE_FORMULA:
		                        s = (cell.getCellFormula());
		                        break;
		                	}
		                	
		                	//s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue() );
		                	//if(s!=null)
		                		b.append(s + "\n");
		                }*/
		                
		                //s= ((cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) ? String.valueOf((int)cell.getNumericCellValue()) : cell.getStringCellValue() );
		                //System.out.println(s);
	                	//String dateday = dateToDay(s);
		                colIndex++;
		                
		            }
		            b.append("\n");
		            writer.append(b);
		            
		        }
			 
			 writer.flush();
		        writer.close();
			
			/*HSSFCell cellA1 = row1.getCell((short) 0);
			String a1Val = cellA1.getStringCellValue();
			HSSFCell cellB1 = row1.getCell((short) 1);
			String b1Val = cellB1.getStringCellValue();
			HSSFCell cellC1 = row1.getCell((short) 2);
			boolean c1Val = cellC1.getBooleanCellValue();
			HSSFCell cellD1 = row1.getCell((short) 3);
			Date d1Val = cellD1.getDateCellValue();

			System.out.println("A1: " + a1Val);
			System.out.println("B1: " + b1Val);
			System.out.println("C1: " + c1Val);
			System.out.println("D1: " + d1Val);*/
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static String dateToDay(String sDay){
		//SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	    java.util.Date date1 = null;
	    try {
	        date1 = format.parse(sDay);
	    } catch (Exception e) {
	        return null;
	    }
	    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
	    calendar.setTime(date1);
	    //System.out.println("Day of the week = "
	           // + (calendar.get(Calendar.DAY_OF_WEEK)));
	    return String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
	}
	public static String timeOfDayLosAngles(String str) {		
				int timeLength = str.length();
				DateFormat formatter = new SimpleDateFormat("hhmm");
				if(timeLength>=4){
					formatter= new SimpleDateFormat("hhmm");
				}
				else if(timeLength==3){
					formatter = new SimpleDateFormat("hmm");
				}
				else if(timeLength<3){
					formatter = new SimpleDateFormat("mm");
				}
				 
				java.util.Date date;
				try {
					date = formatter.parse(str);
				} catch (ParseException e) {
					return null;
				}
				Time time = new Time(date.getTime());		
				String timeOfDay = "";		
				int hours = time.getHours();
				if(hours>=0 && hours<6){
					timeOfDay = "Dawn";
				}
				else if(hours>=6 && hours<12){
					timeOfDay = "Morning";
				}
				else if(hours>=12 && hours<18){
					timeOfDay = "Afternoon";
				}else{
					timeOfDay = "Night";
				}
				//System.out.println("Time: " + (time.getHours()));
				//System.out.println("TimeOfDay: " + timeOfDay);
				return timeOfDay;
	}
	
}
