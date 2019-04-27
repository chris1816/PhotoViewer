package com.example.photoviewer.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photoviewer.R
import com.example.photoviewer.adapter.AlbumAdapter
import com.example.photoviewer.data.MyViewModel
import com.example.photoviewer.data.model.Album
import com.example.photoviewer.interfaces.ClickListener
import kotlinx.android.synthetic.main.layout_fragment_album.*

class FragmentAlbum: Fragment(), AlbumAdapter.AlbumClickListener {

    private var clickListener: ClickListener? = null

    private val mViewModel by lazy {
        activity?.let{
            ViewModelProviders.of(it).get(MyViewModel::class.java)
        }
    }

    companion object {
        fun newInstance(): FragmentAlbum {
            return FragmentAlbum()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        clickListener = context as ClickListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_fragment_album, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel?.initAlbums()
        initAlbumRV()
    }

     private fun initAlbumRV() {
        val layoutManager = LinearLayoutManager(context)
        rv_fragment_album?.layoutManager = layoutManager
        val adapter = AlbumAdapter()
        adapter.setListener(this)
        rv_fragment_album?.adapter = adapter

         mViewModel?.albums?.observe(viewLifecycleOwner,
            Observer<List<Album>> {
                adapter.setAlbumList(it)
            })
    }

    override fun albumClicked(id: String?) {
        mViewModel?.setAlbumId(id)
        clickListener?.onAlbumClicked()
    }
}