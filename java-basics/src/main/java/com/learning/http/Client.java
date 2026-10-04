package com.learning.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Client {
    OkHttpClient okHttpClient ;

    public Client() {
        okHttpClient = new OkHttpClient();
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try{
            var response = okHttpClient.newCall(request).execute().body().string();
            return response;
        } catch (IOException ioe) {
            System.out.println("Error " + ioe.getMessage());
            return null;
        }
    }
}
