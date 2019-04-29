package com.example.photoviewer.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo
import com.example.photoviewer.interfaces.NetworkCallback

class MyViewModel(): ViewModel(), NetworkCallback {

    private var albumId: String? = ""

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>>
        get() = _albums

    private var photos: List<Photo>? = null

    private val _validPhotos = MutableLiveData<List<Photo>>()
    val validPhotos: LiveData<List<Photo>>
        get() = _validPhotos

    private val repository = Repository()

    private var INITPHOTOTAG = true

    init {
//        initAlbums()
//        initPhotos()
    }

    fun setAlbumId(albumId: String?) {
        this.albumId = albumId
    }

    fun initPhotos() {
        if (photos == null) {
            repository.onPhotoListInit(this)
        } else {
            setValidPhoto()
        }
    }

    fun initAlbums() {
        if (INITPHOTOTAG) {
            repository.onAlbumListInit(this)
        }
    }

    override fun getAlbumFinished(albums: List<Album>) {
        _albums.value = albums
        INITPHOTOTAG = false
    }

    override fun getPhotoFinished(photos: List<Photo>) {
        this.photos = photos
        setValidPhoto()
    }

    private fun setValidPhoto() {
        if (albumId.equals("")) return
        val photosWithIdList = mutableListOf<Photo>()
        photos?.let{
            for (photo in it) {
                if (photo.albumId.equals(albumId)) {
                    photosWithIdList.add(photo)
                }
            }
        }
        _validPhotos.value = photosWithIdList
    }
}