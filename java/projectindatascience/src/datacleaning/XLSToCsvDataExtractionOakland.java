
package datacleaning;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XLSToCsvDataExtractionOakland {

	static String inputpath = "/home/rkmalik/Downloads/rawdatainput/raleigh.xls";
	static String outputpath = "/home/rkmalik/Downloads/cleanedataoutput/raleigh.csv";

	static String HEADER = "DayofWeek,PartofDay,CrimeType,Location,Latitude,Longitude,Date\n";

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream(inputpath);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheetAt(0);
			System.out.println("Read");

			FileWriter writer = new FileWriter(outputpath);
			writer.append(HEADER);

			Iterator<Row> rowIterator = worksheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				StringBuffer b = new StringBuffer();
				int colIndex = 0;

				String day = "";
				String partOfDay = "";
				String crimeType = "";
				String location = "";
				String latitude = "";
				String longitude = "";
				String date = "";

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String s = null;

					if (colIndex == 0) {
						if ((cell.getCellType() == Cell.CELL_TYPE_STRING)) {
							s = cell.getStringCellValue();
							System.out.println(s);
						}
						
						if (s==null || s.isEmpty()) {
							break;
						}
						crimeType += s;
					}

					else if (colIndex == 1) {

						if ((cell.getCellType() == Cell.CELL_TYPE_STRING)) {
							s = cell.getStringCellValue();
							System.out.println(s);
						}
						String ds = cell.getStringCellValue();
						
						if (ds == null || ds.isEmpty()) {
							break;
						}
						
						System.out.println(ds);
						// Date d = cell.getDateCellValue();
						Calendar c = Calendar.getInstance();
						Date d = new Date(ds);
						c.setTime(d);
						int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
						
						
						switch (dayOfWeek) {

						case 1:
							day += "Sunday";
							break;
						case 2:
							day += "Monday";
							break;
						case 3:
							day += "Tuesday";
							break;
						case 4:
							day += "Wednesday";
							break;
						case 5:
							day += "Thursday";
							break;
						case 6:
							day += "Friday";
						case 7:
							day += "Saturday";

						}

						if (day.isEmpty()) {
							System.out.println("dayof week " + dayOfWeek);
						}
						
						
						SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss");
						date += ft.format(d).toString();
						//System.out.println(ft.format(d));
						ft = new SimpleDateFormat("HH:mm:ss");
						ds = ft.format(d).toString();
						
						partOfDay += timeOfDayLosAngles(ds); 
						// Now we will find the time of the crime

						

					} else if (colIndex == 2) {
						s = ((cell.getCellType() == Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue())
								: cell.getStringCellValue());
						
						
						s.trim();

						if (s==null || s.isEmpty())  {
							break;
						}
						
						s=s.replace("(", "");
						s=s.replace(")", "");

						String[] locs = s.split(",");
						
						if (locs.length <2) {
							break;
						}
						

						if (locs.length == 2) {
							if (locs[0] != null) {
								latitude += locs[0].trim();
							}
							if (locs[1] != null) {
								longitude += locs[1].trim();
							}
						}

					} else if (colIndex == 3) {
						s = ((cell.getCellType() == Cell.CELL_TYPE_NUMERIC) ? String.valueOf(cell.getNumericCellValue())
								: cell.getStringCellValue());
						
						if (s==null || s.isEmpty())  {
							break;
						}
						s.trim();
						location = s;
					}

					colIndex++;

				}

				if (!day.isEmpty()&& !partOfDay.isEmpty() && !crimeType.isEmpty() && !location.isEmpty()
						&& !latitude.isEmpty() && !longitude.isEmpty() && !date.isEmpty()) {
				
					b.append(day + ",");
					b.append(partOfDay + ",");
					b.append(crimeType + ",");
					b.append(location + ",");
					b.append(latitude + ",");
					b.append(longitude + ",");
					b.append(date);
					b.append("\n");
					writer.append(b);
					
				}
				

			}

			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public static String timeOfDayLosAngles(String str) {
		int timeLength = str.length();
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		/*if (timeLength >= 4) {
			formatter = new SimpleDateFormat("hhmm");
		} else if (timeLength == 3) {
			formatter = new SimpleDateFormat("hmm");
		} else if (timeLength < 3) {
			formatter = new SimpleDateFormat("mm");
		}*/

		java.util.Date date;
		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
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
		return timeOfDay;
	}

}
