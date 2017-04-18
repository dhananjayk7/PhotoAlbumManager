# PhotoAlbumManager
A RESTful application 


Installation steps: 

System must have jdk 1.8, maven 3.3.9, mysql 5.6
1. Downlaod the repository.
2. Run mvnw clean package
3. Run the Created JAR
4. Go to "http://localhost:8080/PhotoAlbumManager/webapi/manager/init" to initialize the database.

Functionality:

1. ALBUMS:
  - GET /webapi/manager/albums : to get the list of albums.
  - GET /webapi/manager/albums/{album_id} : to get the album with id {album_id}
  - PUT /webapi/manager/albums/{album_id} : to update album details with id {album_id}.
  - POST /webapi/manager : Add a new album.
  - DELETE /webapi/manager/albums/{album_id} : to delete album with id {album_id}.
  

2. Photos:
  - GET /webapi/managephotos/photos : to get list of photos.
  - GET /webapi/managephotos/photos/{photo_id} : to get photo with it {photo_id}.
  - GET /webapi/managephotos/photos/{album_id} : Get all photos in album {album_id}.
  - GET /webapi/managephotos/photos/list : Get list of all photos in albums.
  - POST /webapi/managephotos : to add new photo.
  - PUT /webapi/managephotos/photos/{photo_id} : to update photo with id {photo_id}.
  - DELETE /webapi/managephotos/photos/{photo_id} : to delete the photo with id {photo_id}.
  
