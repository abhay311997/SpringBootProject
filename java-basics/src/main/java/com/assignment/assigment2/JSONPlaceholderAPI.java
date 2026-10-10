package com.assignment.assigment2;

import retrofit2.Call;
import retrofit2.http.GET;
import com.assignment.assigment2.models.Photo ;

import java.util.List;

public interface JSONPlaceholderAPI {
    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
