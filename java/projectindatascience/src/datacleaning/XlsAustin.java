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

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsAustin {

	static String HEADER = "DayofWeek,PartofDay,CrimeType,Location,Latitude,Longitude,Date\n";

	public static void main(String[] args) {
		try {
			// String target_dir = "C:\\Users\\rkmalik\\Downloads\\austin";
			String target_dir = "/home/rkmalik/Downloads/austin/xls/";
			// FileWriter writer = new
			// FileWriter("C:\\Users\\rkmalik\\Downloads\\austin\\austin.csv");
			File writeTof = new File("/home/rkmalik/Downloads/austin/austin.csv");
			FileWriter writer = new FileWriter(writeTof);
			writer.append(HEADER);
			File dir = new File(target_dir);
			File[] files = dir.listFiles();
			for (File f : files) {

				String fileName = f.getName();

				// We find two differnt path based on the xlsx and xls

				StringTokenizer token = new StringTokenizer(fileName, ".");
				String lasttoken = null;
				System.out.println(fileName);

				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(f));
				// XSSFWorkbook workbook = new XSSFWorkbook(new
				// FileInputStream(f));
				XSSFSheet worksheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = worksheet.iterator();
				rowIterator.next();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					// For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					int colIndex = 0;
					// StringBuffer b = new StringBuffer();
					String finalString = "";

					String dayOfWeek = "";
					String partOfDay="";
					String crimeType="";
					String location = "";
					String date = "";

					while (cellIterator.hasNext()) {
						String s = null;
						Cell cell = cellIterator.next();

						s = ((cell.getCellType() == Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue())
								: cell.getStringCellValue());
						
						

						if (colIndex == 2) {

							// Date d = cell.getDateCellValue();

							if ((cell.getCellType() == Cell.CELL_TYPE_STRING)) {
								s = cell.getStringCellValue();
								System.out.println(s);
							}
							
							Date d = null;
							
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								d = cell.getDateCellValue();
							}
							
							if (d==null) {
								break;
							}
							
							
							//s = cell.getStringCellValue();
							
							Calendar c = Calendar.getInstance();
							c.setTime(d);
							
							SimpleDateFormat myformat= new SimpleDateFormat("yyyy/MM/dd");
							date = myformat.format(d).toString();
							
							int day = c.get(Calendar.DAY_OF_WEEK);

							switch (day) {

							case 1:
								dayOfWeek += "Sunday";
								break;
							case 2:
								dayOfWeek += "Monday";
								break;
							case 3:
								dayOfWeek += "Tuesday";
								break;
							case 4:
								dayOfWeek += "Wednesday";
								break;
							case 5:
								dayOfWeek += "Thursday";
								break;
							case 6:
								dayOfWeek += "Friday";
								break;
							case 7:
								dayOfWeek += "Saturday";

							}

						} else if (colIndex == 3) {

							//SimpleDateFormat ft = new SimpleDateFormat("HHmmss");
							//String time = ft.format(d).toString();

							// ft = new SimpleDateFormat("HH:mm:ss");
							// ds = ft.format(d).toString();
							// partOfDay += timeOfDayLosAngles(ds);
							System.out.println(s);
							int time = (int)Double.parseDouble(s);
							partOfDay += timeOfDayBaton_Rogue (String.valueOf(time));

						} else if (colIndex == 1) {

							if ((cell.getCellType() == Cell.CELL_TYPE_STRING)) {
								s = cell.getStringCellValue();
								System.out.println(s);
							}

							if (s == null || s.isEmpty()) {
								break;
							}
							crimeType+=s;
							// finalString += s;
							// finalString += ",";
						}

						colIndex++;
						if (colIndex == 10)
							break;
					}

					finalString += dayOfWeek + ",";
					finalString += partOfDay + ",";
					finalString += crimeType + ",";
					finalString += location + ",";
					finalString += date + ",";

					// String x = b.toString();
					finalString += "\n";
					System.out.print(finalString);
					// writer.write(finalString);
					writer.append(finalString);
				}
			}
			System.out.println("Closing File");

			writer.close();
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

		Date date;
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
