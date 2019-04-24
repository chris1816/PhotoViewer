package com.example.photoviewer.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoviewer.interfaces.CallbackInterface
import com.example.photoviewer.interfaces.Contract
import com.example.photoviewer.presenter.Presenter
import com.example.photoviewer.R
import com.example.photoviewer.adapter.AlbumAdapter
import kotlinx.android.synthetic.main.layout_fragment_album.*

class FragmentAlbum: Fragment(), Contract.AlbumView {

    private var presenter: Presenter? = null
    private var albumClickCallback: CallbackInterface.AlbumClickCallback? = null

    companion object {
        fun newInstance(): FragmentAlbum {
            return FragmentAlbum()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        albumClickCallback = context as CallbackInterface.AlbumClickCallback
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_fragment_album, container, false)
        presenter = Presenter(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.initAlbum()
    }

    override fun initAlbumRV(mAdapter: AlbumAdapter) {

        val layoutManager = LinearLayoutManager(context)
        rv_fragment_album?.layoutManager = layoutManager as RecyclerView.LayoutManager?
        rv_fragment_album?.adapter = mAdapter
    }

    override fun onAlbumClicked(id: String?) {
        albumClickCallback?.onAlbumClicked(id)
    }
}