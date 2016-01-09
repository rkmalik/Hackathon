package datacleaning;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class DataCleaner {
	//static String HEADER = "Date,Time,CrimeType\n";
	
	static String HEADER = "DayofWeek,PartofDay,CrimeType";
	public static void main(String[] args) throws ParseException, IOException {

		//time to time of the day - Baton-Rogue
		String str = "0600";
		timeOfDayBaton_Rogue(str);
		
		
		////time to time of the day - Denver
		String sTimeStamp = "2013-06-19 19:54:59";
		
		
		//date to day
		String sDay = "11/21/2015";
		dateToDay(sDay);
		
		
		
		
		File f = new File("C:\\Users\\rkmalik\\Desktop\\data\\los_angeles.csv");
		BufferedReader inputStream = null;
		 FileWriter writer = null;
        try {
        	//System.out.println("File is "+ f);
            inputStream = new BufferedReader(
                            new FileReader(f));
            writer = new FileWriter("C:\\Users\\rkmalik\\Desktop\\data\\los_angeles_o1.csv");
            writer.append(HEADER);
            //prefered output format - Latitude	| Longitude	| Address | CrimeTime | CrimeType

            String line = inputStream.readLine();
            System.out.println(line);
           /* System.out.println(line);
            System.out.println(inputStream.readLine());
            System.out.println(inputStream.readLine());
            System.out.println(inputStream.readLine());
            System.out.println(inputStream.readLine());
            line = inputStream.readLine() + inputStream.readLine()+inputStream.readLine();
            System.out.println(line);
            String a[] = line.split(",");
            StringBuffer b = new StringBuffer();
            b.append(a[1] + ",");
            b.append(a[2] + ",");
            b.append(a[3] + "\n");
            System.out.println(b);*/
            
            while((line = inputStream.readLine()/* + inputStream.readLine()+inputStream.readLine()*/) != null){
            	String a[] = line.split(",");
            	/*for (int i = 0; i < a.length; i++)
            		System.out.print(a[i] + ", " );
            	System.out.println("");*/
                StringBuffer b = new StringBuffer();
                if(a.length < 4)
                	continue;
                b.append(dateToDay(a[2])+",");		// day of week
                b.append(timeOfDayBaton_Rogue(a[3]) + ",");	// time of day
                
                //String after = a[8].trim().replaceAll(" +", " ");
                b.append(a[8].trim().replaceAll(" +", " ") + ",");		// crime type
                b.append(a[11] + "\n"); // locationi
                
                //b.append(a[3] + "\n");
                
                
               //a[2], a[5], a[8], a[12], 
                System.out.println(b);
                writer.append(b);
            } 
            writer.flush();
            writer.close();
        }catch(Exception e){  
        	e.printStackTrace();
        	 writer.flush();
             writer.close();
        }
		
	}
	
	public static String dateToDay(String sDay){
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	    java.util.Date date1 = null;
	    try {
	        date1 = format.parse(sDay);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
	    calendar.setTime(date1);
	    System.out.println("Day of the week = "
	            + (calendar.get(Calendar.DAY_OF_WEEK)));
	    
	    return String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
	}
	public static String timeOfDayBaton_Rogue(String str) throws ParseException{		
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
				 
				java.util.Date date = formatter.parse(str);
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
				System.out.println("Time: " + (time.getHours()));
				System.out.println("TimeOfDay: " + timeOfDay);
				return timeOfDay;
	}
}
