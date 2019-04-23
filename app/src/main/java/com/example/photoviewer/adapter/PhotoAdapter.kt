package com.example.photoviewer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoviewer.R
import com.example.photoviewer.data.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_photo_list.view.*

class PhotoAdapter(
    val context: Context?,
    val photosWithIdList: MutableList<Photo>
) : RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {

    private var clickListener: PhotoClickListener? = null


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

    fun setListener(clickListener: PhotoClickListener?) {
        this.clickListener = clickListener
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            clickListener?.photoClicked(photosWithIdList[adapterPosition].url, photosWithIdList[adapterPosition].title)
        }

        init {
            itemView.setOnClickListener(this)
        }

        var photoTitle = itemView.tv_photo_title
        var thumbnails = itemView.tv_album_thumbnail

    }

    interface PhotoClickListener {
        fun photoClicked(url: String?, title: String?)
    }
}