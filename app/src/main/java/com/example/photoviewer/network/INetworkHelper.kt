package com.example.photoviewer.network

import com.example.photoviewer.interfaces.NetworkCallback

interface INetworkHelper {
    fun onAlbumListInit(networkCallback: NetworkCallback)
    fun onPhotoListInit(networkCallback: NetworkCallback)
}