package com.example.photoviewer.network

import android.util.Log
import com.example.photoviewer.CallbackInterface
import com.example.photoviewer.data.Album
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkHelper: INetworkHelper {

    val apiService by lazy {
        RetrofitFactory.getRetrofitInstance().create(ApiService::class.java)
    }

    companion object {
        const val TAG = "network"
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

}