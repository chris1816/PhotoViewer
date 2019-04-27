package com.example.photoviewer.interfaces

interface ClickListener {
    fun onAlbumClicked()
    fun onPhotoClicked(url: String?, title: String?)
}