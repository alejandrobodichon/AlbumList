package com.example.albumlistapplication.shared

import androidx.recyclerview.widget.DiffUtil
import com.example.albumlistapplication.model.PhotoModel

class PhotoModelDiffCallback : DiffUtil.ItemCallback<PhotoModel>() {

    override fun areItemsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean =
        oldItem == newItem
}
