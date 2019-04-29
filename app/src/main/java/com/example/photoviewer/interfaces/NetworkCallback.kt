package com.example.photoviewer.interfaces

import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo

interface NetworkCallback {

    fun getAlbumFinished(albums: List<Album>)
    fun getPhotoFinished(photos: List<Photo>)
}