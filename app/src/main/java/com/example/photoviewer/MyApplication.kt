package com.example.photoviewer

import android.app.Application
import com.example.photoviewer.di.ApiModule
import com.example.photoviewer.di.DaggerMyComponent
import com.example.photoviewer.di.MyComponent

class MyApplication: Application() {

    companion object {
        fun getDaggerComponent(): MyComponent {
            return DaggerMyComponent
                .builder()
                .apiModule(ApiModule("https://jsonplaceholder.typicode.com"))
                .build()
        }
    }
}