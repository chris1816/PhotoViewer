package com.example.photoviewer.data

import com.google.gson.annotations.SerializedName

class Album {

    @field:SerializedName("userId")
    var userId: String? = null

    @field:SerializedName("id")
    var id: String? = null

    @field:SerializedName("title")
    var title: String? = null


}