package com.example.photoviewer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoviewer.R
import com.example.photoviewer.data.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_photo_list.view.*

class PhotoAdapter(
    val context: Context?,
    val photosWithIdList: MutableList<Photo>
) : RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photosWithIdList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.photoTitle.text = photosWithIdList[position].title

        Picasso.with(context)
            .load(photosWithIdList[position].thumbnailUrl)
            .into(holder.thumbnails)

    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var photoTitle = itemView.tv_photo_title
        var thumbnails = itemView.tv_album_thumbnail

    }
}