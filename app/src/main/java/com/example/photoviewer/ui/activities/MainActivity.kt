package com.example.photoviewer.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoviewer.interfaces.CallbackInterface
import com.example.photoviewer.R
import com.example.photoviewer.ui.fragments.FragmentAlbum
import com.example.photoviewer.ui.fragments.FragmentPhoto
import com.example.photoviewer.ui.fragments.FragmentSinglePhoto

class MainActivity : AppCompatActivity(), CallbackInterface.AlbumClickCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAlbum = FragmentAlbum.newInstance()

        supportFragmentManager.beginTransaction().replace(R.id.container, fragmentAlbum, null).commit()
    }

    override fun onAlbumClicked(id: String?) {
        val bundle = Bundle()
        bundle.putString("albumId", id)
        val fragmentPhoto = FragmentPhoto.newInstance()
        fragmentPhoto.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentPhoto, null).addToBackStack("").commit()
    }

    override fun onPhotoClicked(url: String?, title: String?) {
        val bundle = Bundle()
        bundle.putString("url", url)
        bundle.putString("title", title)
        val fragmentSinglePhoto = FragmentSinglePhoto.newInstance()
        fragmentSinglePhoto.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentSinglePhoto, null).addToBackStack("").commit()
    }

}