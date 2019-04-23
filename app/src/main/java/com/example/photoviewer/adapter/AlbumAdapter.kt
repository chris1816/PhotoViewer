package com.example.photoviewer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoviewer.data.Album
import com.example.photoviewer.R
import kotlinx.android.synthetic.main.layout_album_list.view.*

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {

    lateinit var albumList: List<Album>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_album_list, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (::albumList.isInitialized) {
            return albumList.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (!::albumList.isInitialized) {
            return
        }
        holder.albumTitle.text = albumList.get(position).title
    }


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var albumTitle = itemView.tv_album_title
    }
}