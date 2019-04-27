package com.example.photoviewer.data

import com.example.photoviewer.network.NetworkHelper
import com.example.photoviewer.interfaces.NetworkCallback

class Repository {

    val networkHelper = NetworkHelper()

    fun onAlbumListInit(networkCallback: NetworkCallback) {
        networkHelper.onAlbumListInit(networkCallback)
    }

/*    fun initAlbum(albums: List<Album>, albumCallback: NetworkCallback.NetworkCallback) {
        if (!::albumAdapter.isInitialized) {
            albumAdapter = AlbumAdapter()
        }

        albumAdapter.albumList = albums
        albumAdapter.setListener(albumCallback as AlbumAdapter.AlbumClickListener)
        albumCallback.finishSetAlbumAdapter(albumAdapter)
    }*/

    fun onPhotoListInit(networkCallback: NetworkCallback) {
        networkHelper.onPhotoListInit(networkCallback)
    }

/*    fun initPhotos(
        photos: List<Photo>,
        albumCallback: NetworkCallback.NetworkCallback,
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
            photoAdapter = PhotoAdapter(context)
        }

        photoAdapter.setListener(albumCallback as PhotoAdapter.PhotoClickListener)
        albumCallback.finishSetPhotoAdapter(photoAdapter)
    }*/

}