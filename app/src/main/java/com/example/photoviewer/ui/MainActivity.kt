package com.example.photoviewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoviewer.CallbackInterface
import com.example.photoviewer.R
import com.example.photoviewer.ui.fragment.FragmentAlbum
import com.example.photoviewer.ui.fragment.FragmentPhoto

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

}