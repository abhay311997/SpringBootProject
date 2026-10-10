package com.assignment.assigment2;

import com.assignment.assigment2.JSONPlaceholderAPI;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class DownloadPhotos {
    public static void main(String[] args) {
        System.out.println("Downloading photos ...");
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .client(okHttpClient)
                    .build();
            JSONPlaceholderAPI api = retrofit.create(JSONPlaceholderAPI.class);

            var apiresponse = api.getPhotos().execute();
            apiresponse.body().forEach(photo -> {
                var thumbnailUrl = photo.getThumbnailUrl();
                //download the photo using the thumbnailUrl in assigment2/photos folder
                System.out.println(thumbnailUrl);
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
