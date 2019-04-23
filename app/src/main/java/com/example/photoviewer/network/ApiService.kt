package com.example.photoviewer.network

import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/albums")
    fun getAlbumList(): Call<List<Album>>

    @GET("/photos")
    fun getPhotoList(): Call<List<Photo>>
}