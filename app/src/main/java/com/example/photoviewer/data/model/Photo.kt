package com.example.photoviewer.data.model

import com.google.gson.annotations.SerializedName

class Photo {

    @field: SerializedName("albumId")
    var albumId: String? = null

    @field: SerializedName("id")
    var id: String? = null

    @field: SerializedName("title")
    var title: String? = null

    @field: SerializedName("url")
    var url : String? = null

    @field: SerializedName("thumbnailUrl")
    var thumbnailUrl: String? = null

}