package org.project.dhananjay.PhotoAlbumManager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.project.dhananjay.PhotoAlbumManager.database.Database_Class;
import org.project.dhananjay.PhotoAlbumManager.photo.photo;
import org.project.dhananjay.PhotoAlbumManager.photoModel.photoModel;

@Path("/managephotos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PhotoResource {
	
	
	/*@Path("/init")
	@GET
	public String getmsg(){
	//	return "Hello World";
		return Database_Class.initdb();	
	}*/
	
	photo ph = new photo();
	@Path("/photos")
	@GET
	public List<photoModel> getphoto(){
	
		return ph.getphoto();
	}
	
	@Path("/photos/{albumid}")
	@GET
	public List<photoModel>  getphotobyalbumid(@PathParam("albumid") double albid){
		
		return ph.getphotobyalbumid(albid);	
	}
	
	
	@POST
	public List<photoModel> addphoto(photoModel title){
		return ph.addphoto(title);	
	}
	

	@Path("/photos/{photoid}")
	@PUT
	public List<photoModel> updatephoto(@PathParam("photoid") double photoid, photoModel title){
		
		return ph.updatephoto(photoid, title);
	}
		
	@Path("/photos/{photoid}")
	@DELETE
	public List<photoModel> deletephoto(@PathParam("photoid") double photoid){
		
		return ph.deletephoto(photoid);	
	}
	
	
	@Path("/photos/list")
	@GET
	
	public  List<photoModel>  getlist(){
		
		return ph.getlist();
	}
	
	

}