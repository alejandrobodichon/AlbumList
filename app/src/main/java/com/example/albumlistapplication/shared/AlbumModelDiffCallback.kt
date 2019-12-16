package com.example.albumlistapplication.shared

import androidx.recyclerview.widget.DiffUtil
import com.example.albumlistapplication.model.AlbumModel

class AlbumModelDiffCallback : DiffUtil.ItemCallback<AlbumModel>() {

    override fun areItemsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean =
        oldItem == newItem
}
