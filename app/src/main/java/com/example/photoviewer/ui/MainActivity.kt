package com.example.photoviewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoviewer.R
import com.example.photoviewer.ui.fragment.FragmentAlbum

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = FragmentAlbum.newInstance()

        supportFragmentManager.beginTransaction().replace(R.id.container, fragment1, null).commit()
    }

}