package com.example.photoviewer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.photoviewer.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_fragment_photo_single.*

class FragmentSinglePhoto: Fragment() {

    companion object {
        fun newInstance(): FragmentSinglePhoto {
            return FragmentSinglePhoto()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_fragment_photo_single, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
        arguments?.let {
            val url = it.getString("url")
            val title = it.getString("title")
            loadPhoto(url, title)
        }
    }

    private fun loadPhoto(url: String?, title: String?) {
        Picasso.with(context)
            .load(url)
            .into(iv_photo_single)

        tv_photo_title_single.text = title
    }
}