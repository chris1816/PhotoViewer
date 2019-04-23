package com.example.photoviewer

import com.example.photoviewer.adapter.AlbumAdapter

interface Contract {

    interface View {

    }

    interface Presenter {
        fun initAlbum()

    }

    interface FragmentView {
        fun initAlbumRV(mAdapter: AlbumAdapter)
        fun onAlbumClicked(id: String?)

    }
}