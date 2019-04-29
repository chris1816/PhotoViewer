package com.example.photoviewer.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoviewer.R
import com.example.photoviewer.adapter.PhotoAdapter
import com.example.photoviewer.data.MyViewModel
import com.example.photoviewer.data.model.Photo
import com.example.photoviewer.interfaces.ClickListener
import kotlinx.android.synthetic.main.layout_fragment_photo.*

class FragmentPhoto: Fragment(), PhotoAdapter.PhotoClickListener{

    private var clickListener: ClickListener? = null

    private val mViewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it).get(MyViewModel::class.java)
        }
    }

    companion object {
        fun newInstance(): FragmentPhoto {
            return FragmentPhoto()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        clickListener = context as ClickListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_fragment_photo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel?.initPhotos()
        initPhotoRV()
    }

    private fun initPhotoRV() {
        val layoutManager = GridLayoutManager(context, 2)
        rv_fragment_photo?.layoutManager = layoutManager
        val adapter = PhotoAdapter(context)
        adapter.setListener(this)
        rv_fragment_photo?.adapter = adapter

        mViewModel?.validPhotos?.observe(viewLifecycleOwner,
            Observer<List<Photo>> {
                adapter.setPhotosWithIdList(it)
            })
    }

    override fun photoClicked(url: String?, title: String?) {
        clickListener?.onPhotoClicked(url, title)
    }
}