package com.example.photoviewer.network

import com.example.photoviewer.CallbackInterface

interface INetworkHelper {
    fun onAlbumListInit(albumCallback: CallbackInterface.AlbumCallback)
}