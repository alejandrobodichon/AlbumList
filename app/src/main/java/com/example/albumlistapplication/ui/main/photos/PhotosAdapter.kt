package com.example.albumlistapplication.ui.main.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.albumlistapplication.R
import com.example.albumlistapplication.model.PhotoModel
import com.example.albumlistapplication.shared.PhotoModelDiffCallback
import kotlinx.android.synthetic.main.adapter_photo.view.*


class PhotosAdapter(
    private val photosAdapterListener: PhotosAdapterListener
) : ListAdapter<PhotoModel, PhotosViewHolder>(PhotoModelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder =
        PhotosViewHolder(parent, photosAdapterListener)

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.populate(getItem(position))
    }
}

class PhotosViewHolder(parent: ViewGroup, private val photosAdapterListener: PhotosAdapterListener) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_photo, parent, false)
) {
    val lp =  (itemView.layoutParams as GridLayoutManager.LayoutParams).apply {
        width = parent.measuredWidth / 2
        height = parent.measuredWidth / 2
        itemView.layoutParams = this
    }

    val photoTitle = itemView.vPhotoTitle
    val photoImage = itemView.vPhotoImage


    fun populate(photo: PhotoModel) {

        photoTitle.text = photo.title
        photoImage.setImageURI(photo.thumbnailUrl)

        itemView.setOnClickListener {
            photosAdapterListener.goToSelectedPhoto(photo)
        }
    }
}

interface PhotosAdapterListener {

    fun goToSelectedPhoto(album: PhotoModel)
}

