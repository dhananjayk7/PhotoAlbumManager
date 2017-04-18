package org.project.dhananjay.PhotoAlbumManager.albumModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class albumModel {


	private double id;
	private String title;
	private double userid; 
	
	public albumModel() {
		
	}
	

	public albumModel(double id, String title, double userid){
		this.id = id;
		this.title = title;
		this.userid = userid;
	}


	public double getId() {
		return id;
	}


	public double getUserid() {
		return userid;
	}


	public void setUserid(double userid) {
		this.userid = userid;
	}


	public void setId(double id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


}
