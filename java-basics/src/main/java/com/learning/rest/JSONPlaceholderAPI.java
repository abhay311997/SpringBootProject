package com.learning.rest;

import com.learning.rest.models.Photo;
import retrofit2.http.GET;
import retrofit2.Call;

import java.util.List;

public interface JSONPlaceholderAPI{
    @GET("/photos")
    Call<List<Photo>> getPhotos() ;
}
