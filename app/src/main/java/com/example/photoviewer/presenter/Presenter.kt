package com.example.photoviewer.presenter

import android.content.Context
import com.example.photoviewer.interfaces.CallbackInterface
import com.example.photoviewer.interfaces.Contract
import com.example.photoviewer.data.Repository
import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo

class Presenter(): Contract.Presenter,
    AlbumAdapter.AlbumClickListener, CallbackInterface.AlbumCallback, PhotoAdapter.PhotoClickListener {

    constructor(view: Contract.AlbumView) : this() {
        albumView = view
    }

    constructor(view: Contract.PhotoView) : this() {
        photoView = view
    }

    var albumView: Contract.AlbumView? = null
    var photoView: Contract.PhotoView? = null
    var albumId: String? = null

    override fun initPhotos(albumId: String, context: Context?) {
        this.albumId = albumId
        repository.onPhotoListInit(this, context)
    }

    val repository: Repository = Repository()

    override fun initAlbum() {
        repository.onAlbumListInit(this)
    }

    override fun getAlbumFinished(albums: List<Album>) {
        repository.initAlbum(albums, this)
    }

    override fun getPhotoFinished(photos: List<Photo>) {
        repository.initPhotos(photos, this, albumId)
    }

    override fun finishSetAlbumAdapter(mAdapter: AlbumAdapter) {
        albumView?.initAlbumRV(mAdapter)
    }

    override fun albumClicked(id: String?) {
        albumView?.onAlbumClicked(id)
    }

    override fun finishSetPhotoAdapter(photoAdapter: PhotoAdapter) {
        photoView?.initPhotoRV(photoAdapter)
    }

    override fun photoClicked(url: String?, title: String?) {
        photoView?.onPhotoClicked(url, title)
    }
}