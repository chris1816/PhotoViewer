package com.example.photoviewer.presenter

import android.util.Log
import com.example.photoviewer.CallbackInterface
import com.example.photoviewer.Contract
import com.example.photoviewer.Repository
import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.data.Album

class Presenter(val view: Contract.FragmentView): Contract.Presenter,
    AlbumAdapter.AlbumClickListener, CallbackInterface.AlbumCallback {

    val repository: Repository = Repository()

    override fun initAlbum() {
        repository.onAlbumListInit(this)
    }

    override fun getAlbumFinished(albums: List<Album>) {
        repository.initAlbum(albums, this)
    }

    override fun finishSetAdapter(mAdapter: AlbumAdapter) {
        view.initAlbumRV(mAdapter)
    }

    override fun albumClicked(id: String?) {
        view.onAlbumClicked(id)
    }
}