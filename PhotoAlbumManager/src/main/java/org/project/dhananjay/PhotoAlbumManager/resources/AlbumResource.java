package org.project.dhananjay.PhotoAlbumManager.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.project.dhananjay.PhotoAlbumManager.album.album;
import org.project.dhananjay.PhotoAlbumManager.albumModel.albumModel;

import org.project.dhananjay.PhotoAlbumManager.database.Database_Class;

@Path("/manager")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlbumResource {
	
	
	@Path("/init")
	@GET
	public String getmsg(){
	//	return "Hello World";
		return Database_Class.initdb();	
	}
	
	album alb = new album();
	@Path("/albums")
	@GET
	public List<albumModel> getalbum(){
	
		return alb.getalbum();
	}
	
	@Path("/albums/{albumid}")
	@GET
	public List<albumModel>  getalbumid(@PathParam("albumid") double albumid){
		
		return alb.getalbumid(albumid);	
	}
	
	
	@POST
	public List<albumModel> addalbum(albumModel title){
		return alb.addalbum(title);	
	}
	

	@Path("/albums/{albumid}")
	@PUT
	public List<albumModel> updatealbum(@PathParam("albumid") double albumid, albumModel title){
		
		return alb.updatealbum(albumid, title);
	}
		
	@Path("/albums/{albumid}")
	@DELETE
	public List<albumModel> updatealbum(@PathParam("albumid") double albumid){
		
		return alb.deletealbum(albumid);	
	}
	

}
