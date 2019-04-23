package com.example.photoviewer

import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.data.Album

interface CallbackInterface {

    interface AlbumCallback{
        fun getAlbumFinished(albums: List<Album>)
        fun finishSetAdapter(mAdapter: AlbumAdapter)
    }
}