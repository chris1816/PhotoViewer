package com.example.photoviewer.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoviewer.R
import com.example.photoviewer.interfaces.ClickListener
import com.example.photoviewer.ui.fragments.FragmentAlbum
import com.example.photoviewer.ui.fragments.FragmentPhoto
import com.example.photoviewer.ui.fragments.FragmentSinglePhoto

class MainActivity : AppCompatActivity(), ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentAlbum = FragmentAlbum.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentAlbum, null).commit()
        }
    }

    override fun onAlbumClicked() {
        val fragmentPhoto = FragmentPhoto.newInstance()
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