package com.example.photoviewer.di

import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.network.NetworkHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface MyComponent {

    fun injectRetrofitInstance(networkHelper: NetworkHelper)

}