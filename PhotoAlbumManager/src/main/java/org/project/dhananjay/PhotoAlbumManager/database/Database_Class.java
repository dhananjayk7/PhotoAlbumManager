package org.project.dhananjay.PhotoAlbumManager.database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;

public class Database_Class {
	

	public static String initdb(){
	try{
		
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver"); 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
		java.sql.Statement stm = con.createStatement();
		String query;

		query = "DROP TABLE if EXISTS photos";
		stm = con.createStatement();
		stm.executeUpdate(query);
		
		query = "DROP TABLE if EXISTS albums";
		stm = con.createStatement();
		stm.executeUpdate(query);
		
		query = "CREATE TABLE albums (id DOUBLE NOT NULL, title varchar(100) NOT NULL, user_id DOUBLE, PRIMARY KEY (id));";
		stm = con.createStatement();
		stm.executeUpdate(query);
			
	
		query = "CREATE TABLE photos (album_id DOUBLE,id DOUBLE NOT NULL, title varchar(100) NOT NULL, url varchar(200) NOT NULL, thumbnail_url varchar(200),PRIMARY KEY (id),CONSTRAINT falbum_id FOREIGN KEY (album_id) REFERENCES albums (id) );";
		stm = con.createStatement();
		stm.executeUpdate(query);
		

		
		
		URL resource = new URL("https://jsonplaceholder.typicode.com/albums");	
		BufferedReader in = new BufferedReader(new InputStreamReader(resource.openStream()));
	
	String input,ip = "";
	while((input = in.readLine())!=null){
		
		ip += input;
		
	}
	
	in.close();	

	JSONArray obj = new JSONArray(ip);
	int n = obj.length();
	 for (int i = 0; i < n; ++i) {
	     JSONObject albums = obj.getJSONObject(i);
	      double userid = albums.getInt("userId");
	      double id = albums.getInt("id");
	      String title = albums.getString("title");
	  	  query = "INSERT INTO albums VALUES(" + id + ",'" +title  + "', " + userid + ");";
		  stm = con.createStatement();
		  stm.executeUpdate(query);
	    }
		
		URL resource1 = new URL("https://jsonplaceholder.typicode.com/photos");	
		BufferedReader in1 = new BufferedReader(new InputStreamReader(resource1.openStream()));
	
	String input1,ip1 = "";
	while((input1 = in1.readLine())!=null){
		
		ip1 += input1;
		
	}
	
	in1.close();	

	JSONArray obj1 = new JSONArray(ip1);
	int n1 = obj1.length();
	 for (int i = 0; i < n1; ++i) {
	     JSONObject albums1 = obj1.getJSONObject(i);
	      double albumid = albums1.getInt("albumId");
	      double id = albums1.getInt("id");
	      String title = albums1.getString("title");
	      String url = albums1.getString("url");
	      String thumbnailUrl = albums1.getString("thumbnailUrl");
	  	  query = "INSERT INTO photos VALUES(" + albumid + "," +id  + ",' " +title+ "', '" +url+"','"+thumbnailUrl+"');";
		  stm = con.createStatement();
		  stm.executeUpdate(query);
	    }

	}
	catch(Exception E){
		System.out.println(""+E);
	}
	
return "DB Initialization Successful";

}
	
	
	
	
}
