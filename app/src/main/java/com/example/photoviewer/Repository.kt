package com.example.photoviewer

import com.example.photoviewer.network.NetworkHelper
import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.data.Album

class Repository {

    val networkHelper = NetworkHelper()
    private lateinit var mAdapter: AlbumAdapter


    fun onAlbumListInit(albumCallback: CallbackInterface.AlbumCallback) {
        networkHelper.onAlbumListInit(albumCallback)
    }

    fun initAlbum(albums: List<Album>, albumCallback: CallbackInterface.AlbumCallback) {
        if (!::mAdapter.isInitialized) {
            mAdapter = AlbumAdapter()
        }

        mAdapter.albumList = albums
        mAdapter.setListener(albumCallback as AlbumAdapter.AlbumClickListener)
        albumCallback.finishSetAdapter(mAdapter)
    }

}