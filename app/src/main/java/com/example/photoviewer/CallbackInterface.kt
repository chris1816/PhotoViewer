package com.example.photoviewer

import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.data.Album
import com.example.photoviewer.data.Photo

interface CallbackInterface {

    interface AlbumCallback{
        fun getAlbumFinished(albums: List<Album>)
        fun finishSetAlbumAdapter(mAdapter: AlbumAdapter)
        fun getPhotoFinished(photos: List<Photo>)
        fun finishSetPhotoAdapter(photoAdapter: PhotoAdapter)
    }

    interface AlbumClickCallback{
        fun onAlbumClicked(id: String?)

    }
}