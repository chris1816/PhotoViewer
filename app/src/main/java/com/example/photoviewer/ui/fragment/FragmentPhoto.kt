package com.example.photoviewer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoviewer.Contract
import com.example.photoviewer.R
import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.presenter.Presenter
import kotlinx.android.synthetic.main.layout_fragment_photo.*

class FragmentPhoto: Fragment(), Contract.PhotoView {

    private var presenter: Presenter? = null

    companion object {
        fun newInstance(): FragmentPhoto {
            return FragmentPhoto()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_fragment_photo, container, false)
        presenter = Presenter(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumId = arguments?.getString("albumId")
        albumId?.let {
            presenter?.initPhotos(it, context)
        }
    }

    override fun initPhotoRV(photoAdapter: PhotoAdapter) {
        val layoutManager = GridLayoutManager(context, 2)
        rv_fragment_photo.layoutManager = layoutManager
        rv_fragment_photo.adapter = photoAdapter
    }

}