package org.project.dhananjay.PhotoAlbumManager.photoModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class photoModel {
	
	private double albumid;
	private double id;
	private String title;
	private String url;
	private String thumbnail_url;
	
	public photoModel(){
		
		
	}
	
	public photoModel(double albumid){
		this.albumid = albumid;
	}
	
	
	public photoModel(double albumid,double id, String title, String url, String thumbnail_url){
		this.albumid = albumid;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnail_url = thumbnail_url;
		
		
	}
	
	
	public double getAlbumid() {
		return albumid;
	}
	public void setAlbumid(double albumid) {
		this.albumid = albumid;
	}
	public double getId() {
		return id;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	
	

}
