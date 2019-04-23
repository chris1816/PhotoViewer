package com.example.photoviewer.data

import android.content.Context
import com.example.photoviewer.network.NetworkHelper
import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo
import com.example.photoviewer.interfaces.CallbackInterface

class Repository {

    val networkHelper = NetworkHelper()
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var photoAdapter: PhotoAdapter
    private var context: Context? = null


    fun onAlbumListInit(albumCallback: CallbackInterface.AlbumCallback) {
        networkHelper.onAlbumListInit(albumCallback)
    }

    fun initAlbum(albums: List<Album>, albumCallback: CallbackInterface.AlbumCallback) {
        if (!::albumAdapter.isInitialized) {
            albumAdapter = AlbumAdapter()
        }

        albumAdapter.albumList = albums
        albumAdapter.setListener(albumCallback as AlbumAdapter.AlbumClickListener)
        albumCallback.finishSetAlbumAdapter(albumAdapter)
    }

    fun onPhotoListInit(
        albumCallback: CallbackInterface.AlbumCallback,
        context: Context?
    ) {
        this.context = context
        networkHelper.onPhotoListInit(albumCallback)
    }

    fun initPhotos(
        photos: List<Photo>,
        albumCallback: CallbackInterface.AlbumCallback,
        albumId: String?
    ) {

        val photosWithIdList = mutableListOf<Photo>()

        for (photo in photos) {
            if (photo.albumId.equals(albumId)) {
                photosWithIdList.add(photo)
            }
        }

//        photoAdapter.photoList = photosWithId
        if (!::photoAdapter.isInitialized) {
            photoAdapter = PhotoAdapter(context, photosWithIdList)
        }

        photoAdapter.setListener(albumCallback as PhotoAdapter.PhotoClickListener)
        albumCallback.finishSetPhotoAdapter(photoAdapter)
    }

}