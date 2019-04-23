package com.example.photoviewer.network

import com.example.photoviewer.interfaces.CallbackInterface

interface INetworkHelper {
    fun onAlbumListInit(albumCallback: CallbackInterface.AlbumCallback)
    fun onPhotoListInit(albumCallback: CallbackInterface.AlbumCallback)
}