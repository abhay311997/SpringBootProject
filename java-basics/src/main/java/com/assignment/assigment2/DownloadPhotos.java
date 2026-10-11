package com.assignment.assigment2;

import com.assignment.assigment2.JSONPlaceholderAPI;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Assignment2: This class downloads photos from the JSONPlaceholder API
// and saves them to a local directory.
// Downloads 10 albums with each 2 photos and saves them in the specified directory.
public class DownloadPhotos {
    public static void main(String[] args) {
        System.out.println("Downloading photos ...");
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            JSONPlaceholderAPI api = retrofit.create(JSONPlaceholderAPI.class);

            var apiresponse = api.getPhotos().execute();
            for(int i = 0; i < apiresponse.body().size(); i++) {
                var photo = apiresponse.body().get(i);
                int albumId = photo.getAlbumId();
                if(albumId > 10) {
                    break;
                }
                var photoUrl = photo.getUrl();
                var Id = photo.getId();
                if(Id%50 < 1 || Id%50 > 2){
                    continue;
                }

                String Path = "C:\\SpringBoot\\Project\\java-basics\\src\\main\\java\\com\\assignment\\assigment2\\photos\\" + albumId;
                java.io.File directory = new java.io.File(Path);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                try {
                    java.net.URL url = new java.net.URL(photoUrl);
                    java.io.InputStream in = url.openStream();
                    java.nio.file.Files.copy(in, java.nio.file.Paths.get(Path + "\\" + Id + ".jpg"), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Downloaded photo " + Id + " from album " + albumId);
                    in.close();
                } catch (Exception e) {
                    System.out.println("Error downloading photo: " + e.getMessage());
                }
            }
            System.out.println("10 Album with each 2 photos downloaded successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Downloading photos completed.");
    }
}
