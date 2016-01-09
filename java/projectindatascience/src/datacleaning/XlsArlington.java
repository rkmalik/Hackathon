package datacleaning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsArlington {

	public static void main(String[] args) {
		try {
			String target_dir = "C:\\Users\\rkmalik\\Downloads\\arlington";
			FileWriter writer = new FileWriter("C:\\Users\\rkmalik\\Downloads\\arlington\\arlington.csv");
			File dir = new File(target_dir);
			File[] files = dir.listFiles();
			for (File f : files) {

				String fileName = f.getName();

				// We find two differnt path based on the xlsx and xls

				StringTokenizer token = new StringTokenizer(fileName, ".");
				String lasttoken = null;
				while (token.hasMoreTokens())
					lasttoken = token.nextToken();

				if (lasttoken.equals("xlsx")) {

					System.out.println(fileName);

					XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(f));
					XSSFSheet worksheet = workbook.getSheetAt(0);
					Iterator<Row> rowIterator = worksheet.iterator();
					rowIterator.next();
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						// For each row, iterate through all the columns
						Iterator<Cell> cellIterator = row.cellIterator();
						int colIndex = 0;
						StringBuffer b = new StringBuffer();
						while (cellIterator.hasNext()) {
							String s = null;
							Cell cell = cellIterator.next();
							
							s = ((cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
									? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue());
							
							
							String finalString = null;

							if (colIndex == 1 || colIndex == 2 || colIndex == 4) {
								if (colIndex == 1) {
									Date d = cell.getDateCellValue();
									
									Calendar c = Calendar.getInstance();
				                	c.setTime(d);
				                	int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
									//finalString = dateToDay(s);
				                	finalString = String.valueOf(dayOfWeek);
									finalString += ",";
								} else if (colIndex == 2) {
									finalString = timeOfDayBaton_Rogue(s);
									finalString += ",";
								} else if (colIndex == 4) {
									finalString = s;
								}

								b.append(finalString);
							}
							colIndex++;
						}
						String x = b.toString();
						//x = x.substring(0, x.length() - 1);
						x += "\n";
						writer.append(x);
					}

				} else if (lasttoken.equals("xls")) {
					HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(f));
					HSSFSheet worksheet = workbook.getSheetAt(0);
					Iterator<Row> rowIterator = worksheet.iterator();
					rowIterator.next();
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						// For each row, iterate through all the columns
						Iterator<Cell> cellIterator = row.cellIterator();
						int colIndex = 0;
						StringBuffer b = new StringBuffer();
						
						
						while (cellIterator.hasNext()) {
							String s = null;
							Cell cell = cellIterator.next();
							s = ((cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
									? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue());
							String finalString = null;

							if (colIndex == 1 || colIndex == 2 || colIndex == 4) {
								if (colIndex == 1) {
									Date d = cell.getDateCellValue();
									
									Calendar c = Calendar.getInstance();
				                	c.setTime(d);
				                	int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
									//finalString = dateToDay(s);
				                	finalString = String.valueOf(dayOfWeek);
									finalString += ",";
								} else if (colIndex == 2) {
									finalString = timeOfDayBaton_Rogue(s);
									finalString += ",";
								} else if (colIndex == 4) {
									finalString = s;
								}

								b.append(finalString);
							}
							colIndex++;
						}
						String x = b.toString();
						//x = x.substring(0, x.length() - 1);
						x += "\n";
						writer.append(x);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Done...");
	}

	public static String dateToDay(String sDay) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date1 = null;
		try {
			date1 = format.parse(sDay);
		} catch (Exception e) {
			return null;
		}
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
		calendar.setTime(date1);
		// System.out.println("Day of the week = "
		// + (calendar.get(Calendar.DAY_OF_WEEK)));
		return String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
	}

	public static String timeOfDayBaton_Rogue(String str) {
		int timeLength = str.length();
		DateFormat formatter = new SimpleDateFormat("hhmm");
		if (timeLength >= 4) {
			formatter = new SimpleDateFormat("hhmm");
		} else if (timeLength == 3) {
			formatter = new SimpleDateFormat("hmm");
		} else if (timeLength < 3) {
			formatter = new SimpleDateFormat("mm");
		}

		java.util.Date date;
		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		Time time = new Time(date.getTime());
		String timeOfDay = "";
		int hours = time.getHours();
		if (hours >= 0 && hours < 6) {
			timeOfDay = "Dawn";
		} else if (hours >= 6 && hours < 12) {
			timeOfDay = "Morning";
		} else if (hours >= 12 && hours < 18) {
			timeOfDay = "Afternoon";
		} else {
			timeOfDay = "Night";
		}
		// System.out.println("Time: " + (time.getHours()));
		// System.out.println("TimeOfDay: " + timeOfDay);
		return timeOfDay;
	}

}
