package com.example.photoviewer.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        private lateinit var retrofitInstance: Retrofit

        fun getRetrofitInstance(): Retrofit {
            if (!Companion::retrofitInstance.isInitialized) {
                retrofitInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitInstance
        }

    }

}