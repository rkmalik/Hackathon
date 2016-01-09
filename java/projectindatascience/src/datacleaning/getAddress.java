package datacleaning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getAddress {
	public static void main(String[] args) {
		double latitude = 35.60694150849056;
				
		double longitude = -82.55783835802079;
		
		try {

			URL url = new URL(
					//"https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452");
					"https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitude + "," + longitude);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}

	}
}
