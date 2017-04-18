package org.project.dhananjay.PhotoAlbumManager.album;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import org.project.dhananjay.PhotoAlbumManager.albumModel.albumModel;


public class album {

	
	
	public   List<albumModel> getalbum(){
		
	List<albumModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0;
	String query = "Select * from albums";
	stm = con.createStatement();
	ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		
		id = s.getDouble("id");
		title = s.getString("title");	
		userid = s.getDouble("user_id");
		albumModel a1 = new albumModel(id,title,userid);
		list.add(a1);
	}
	s.close();

	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	

	return list;
	
	
	}
	
	
	public   List<albumModel> getalbumid(double albid){
		
	List<albumModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0;
	String query = "Select * from albums where id="+albid+";";
	stm = con.createStatement();
	ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		
		id = s.getDouble("id");
		title = s.getString("title");	
		userid = s.getDouble("user_id");
		albumModel a1 = new albumModel(id,title,userid);
		list.add(a1);
	}
	s.close();

	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	

	return list;
	
	}
	
	
	
	public   List<albumModel> addalbum(albumModel albid){
		
	List<albumModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0 ;
	String query = "Select * from albums ;";
	stm = con.createStatement();
	ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		id = s.getDouble("id");
	}	

	double lastid = id;
	double newid = lastid + 1;
	s.close();
	
	query = "insert into albums values("+newid+",'"+albid.getTitle()+"'," +albid.getUserid()+"); ";
	stm = con.createStatement();
	stm.executeUpdate(query);
	
	
	query = "Select * from albums";
	stm = con.createStatement();
	 s = stm.executeQuery(query);
	while (s.next()) {
		
		id = s.getDouble("id");
		title = s.getString("title");	
		userid = s.getDouble("user_id");
		albumModel a1 = new albumModel(id,title,userid);
		list.add(a1);
	}
	s.close();

	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	return list;
	
	}
	
	
	public   List<albumModel> updatealbum(double albumid, albumModel albid){
		
	List<albumModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0 ;

	String query = "Update manager.albums Set title= '"+albid.getTitle()+"',user_id="+albid.getUserid()+", id = "+albid.getId()+" where id="+albumid+";";
	stm = con.createStatement();
	stm.executeUpdate(query);
	
	
	 query = "Select * from albums where id="+albid.getId();
	 stm = con.createStatement();
	 ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		
		id = s.getDouble("id");
		title = s.getString("title");	
		userid = s.getDouble("user_id");
		albumModel a1 = new albumModel(id,title,userid);
		list.add(a1);
	}
	s.close();
	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	return list;	
	}	
	
	public   List<albumModel> deletealbum(double albumid){
		
	List<albumModel> list = new ArrayList<>();	
	try{
		
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "root");
	java.sql.Statement stm = con.createStatement();

	
	
	double id = 0.0;
	String title = "";
	double userid = 0.0 ;

	String query = "Delete from manager.albums where id ="+albumid;
	stm = con.createStatement();
	stm.executeUpdate(query);
	
	
	 query = "Select * from albums";
	 stm = con.createStatement();
	 ResultSet s = stm.executeQuery(query);
	while (s.next()) {
		
		id = s.getDouble("id");
		title = s.getString("title");	
		userid = s.getDouble("user_id");
		albumModel a1 = new albumModel(id,title,userid);
		list.add(a1);
	}
	s.close();
	}
	catch(Exception e){
		
		System.out.println(""+e);
	}
	return list;	
	}	
	
	
	
}
