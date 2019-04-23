package com.example.photoviewer.interfaces

import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo

interface CallbackInterface {

    interface AlbumCallback{
        fun getAlbumFinished(albums: List<Album>)
        fun finishSetAlbumAdapter(mAdapter: AlbumAdapter)
        fun getPhotoFinished(photos: List<Photo>)
        fun finishSetPhotoAdapter(photoAdapter: PhotoAdapter)
    }

    interface AlbumClickCallback {
        fun onAlbumClicked(id: String?)
        fun onPhotoClicked(url: String?, title: String?)
    }

    interface PhotoClickCallback {

    }
}