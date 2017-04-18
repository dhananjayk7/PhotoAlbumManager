package org.project.dhananjay.PhotoAlbumManager.photo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.project.dhananjay.PhotoAlbumManager.photoModel.photoModel;



public class photo {
	
	
	public   List<photoModel> getphoto(){
		
	List<photoModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0;
	String query = "Select * from photos";
	stm = con.createStatement();
	ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		double albid = s.getDouble("album_id");
		id = s.getDouble("id");
		title = s.getString("title");	
		String url = s.getString("url");
		String thumbnail_url = s.getString("thumbnail_url");
		photoModel a1 = new photoModel(albid,id,title,url,thumbnail_url);
		list.add(a1);
	}
	s.close();

	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	

	return list;
	
	
	}
	
	
	public   List<photoModel> getphotobyalbumid(double albumid){
		
	List<photoModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0;
	String query = "Select * from photos where album_id="+albumid+";";
	stm = con.createStatement();
	ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		
		double albid = s.getDouble("album_id");
		id = s.getDouble("id");
		title = s.getString("title");	
		String url = s.getString("url");
		String thumbnail_url = s.getString("thumbnail_url");
		photoModel a1 = new photoModel(albid,id,title,url,thumbnail_url);
		list.add(a1);
	}
	s.close();

	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	

	return list;
	
	}
	
	
	
	public   List<photoModel> addphoto(photoModel phid){
		
	List<photoModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0 ;
	String query = "Select * from photos ;";
	stm = con.createStatement();
	ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		id = s.getDouble("id");
	}	

	double lastid = id;
	double newid = lastid + 1;
	s.close();
	
	query = "insert into photos values("+phid.getAlbumid()+","+newid+",'"+phid.getTitle()+"','" +phid.getUrl()+"','"+phid.getThumbnail_url()+"');";
	stm = con.createStatement();
	stm.executeUpdate(query);
	
	
	query = "Select * from photos";
	stm = con.createStatement();
	 s = stm.executeQuery(query);
	while (s.next()) {
		
		double albid = s.getDouble("album_id");
		id = s.getDouble("id");
		title = s.getString("title");	
		String url = s.getString("url");
		String thumbnail_url = s.getString("thumbnail_url");
		photoModel a1 = new photoModel(albid,id,title,url,thumbnail_url);
		list.add(a1);
	}
	s.close();

	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	return list;
	
	}
	
	
	public   List<photoModel> updatephoto(double photoid, photoModel phid){
		
	List<photoModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0 ;

	String query = "Update manager.photos Set title= '"+phid.getTitle()+"',url='"+phid.getUrl()+"', thumbnail_url = '"+phid.getThumbnail_url()+"' where id="+photoid+";";
	stm = con.createStatement();
	stm.executeUpdate(query);
	
	
	 query = "Select * from photos where id="+photoid;
	 stm = con.createStatement();
	 ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		
		double albid = s.getDouble("album_id");
		id = s.getDouble("id");
		title = s.getString("title");	
		String url = s.getString("url");
		String thumbnail_url = s.getString("thumbnail_url");
		photoModel a1 = new photoModel(albid,id,title,url,thumbnail_url);
		list.add(a1);
		
	}
	s.close();
	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	return list;	
	}	
	
	public   List<photoModel> deletephoto(double phid){
		
	List<photoModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0 ;

	String query = "Delete from manager.photos where id ="+phid;
	stm = con.createStatement();
	stm.executeUpdate(query);
	
	
	 query = "Select * from photos";
	 stm = con.createStatement();
	 ResultSet s = stm.executeQuery(query);
	 while (s.next()) {
		double albid = s.getDouble("album_id");
		id = s.getDouble("id");
		title = s.getString("title");	
		String url = s.getString("url");
		String thumbnail_url = s.getString("thumbnail_url");
		photoModel a1 = new photoModel(albid,id,title,url,thumbnail_url);
		list.add(a1);
	}

	s.close();
	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	return list;	
	}	
	
	

	
	
	public  List<photoModel>  getlist(){
		
		List<photoModel> list = new ArrayList<>();	
		List<photoModel> mainlist = new ArrayList();
	
		try{
			
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
		java.sql.Statement stm = con.createStatement();

		
		
		double id = 0.0;
		String title = "";
		double userid = 0.0;
		String query = "Select album_id, id,title,url,thumbnail_url from photos GROUP BY id;";
		stm = con.createStatement();
		ResultSet s = stm.executeQuery(query);
		while (s.next()) {
			
			double albid = s.getDouble("album_id");
			
			
			id = s.getDouble("id");
			title = s.getString("title");	
			String url = s.getString("url");
			String thumbnail_url = s.getString("thumbnail_url");
			photoModel a1 = new photoModel(albid,id,title,url,thumbnail_url);
			list.add(a1);
			photoModel a2 = new photoModel(albid);
			mainlist.add(a2);
		}
		
		
		s.close();
		
		
		
		}
		catch(Exception e){
			
			System.out.println(""+e);
		}
		

		return list;
		
		}
		
	
	
}
