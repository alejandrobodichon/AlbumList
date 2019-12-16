package com.example.albumlistapplication.ui.main.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.albumlistapplication.R
import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.shared.AlbumModelDiffCallback
import kotlinx.android.synthetic.main.adapter_album.view.*


class AlbumsAdapter(
    private val albumsAdapterListener: AlbumsAdapterListener
) : ListAdapter<AlbumModel, AlbumsViewHolder>(AlbumModelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder =
        AlbumsViewHolder(parent, albumsAdapterListener)


    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.populate(getItem(position))
    }
}

class AlbumsViewHolder(parent: ViewGroup, private val albumsAdapterListener: AlbumsAdapterListener) : ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_album, parent, false)
) {
    val albumTitle = itemView.vAlbumTitle


    fun populate(album: AlbumModel) {

        albumTitle.text = album.title

        itemView.setOnClickListener {
            albumsAdapterListener.goToSelectedAlbum(album)
        }
    }
}

interface AlbumsAdapterListener {

    fun goToSelectedAlbum(album: AlbumModel)
}

