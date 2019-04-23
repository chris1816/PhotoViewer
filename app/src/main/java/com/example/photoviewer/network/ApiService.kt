package com.example.photoviewer.network

import com.example.photoviewer.data.Album
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/albums")
    fun getAlbumList(): Call<List<Album>>

}