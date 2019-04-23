package com.example.photoviewer

import android.content.Context
import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.adapter.PhotoAdapter

interface Contract {



    interface Presenter {
        fun initAlbum()
        fun initPhotos(albumId: String, context: Context?)
    }

    interface AlbumView {

        fun initAlbumRV(mAdapter: AlbumAdapter)
        fun onAlbumClicked(id: String?)

    }

    interface PhotoView {
        fun initPhotoRV(photoAdapter: PhotoAdapter)

    }

}