package com.example.photoviewer.network

import android.util.Log
import com.example.photoviewer.MyApplication
import com.example.photoviewer.interfaces.CallbackInterface
import com.example.photoviewer.data.model.Album
import com.example.photoviewer.data.model.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkHelper: INetworkHelper {

    @Inject
    lateinit var retrofit: Retrofit

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    companion object {
        const val TAG = "network"
    }

    init {
        MyApplication.getDaggerComponent().injectRetrofitInstance(this)
    }

    override fun onAlbumListInit(albumCallback: CallbackInterface.AlbumCallback) {

        val call = apiService.getAlbumList()

        call.enqueue(object : Callback<List<Album>> {

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.i(TAG, t.message)
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val albums = response.body()
                albums?.let {
                    albumCallback.getAlbumFinished(it)
                }
            }

        })
    }

    override fun onPhotoListInit(albumCallback: CallbackInterface.AlbumCallback) {

        val call = apiService.getPhotoList()

        call.enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.i(TAG, t.message)
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photos = response.body()
                photos?.let {
                    albumCallback.getPhotoFinished(it)
                }
            }

        })
    }

}