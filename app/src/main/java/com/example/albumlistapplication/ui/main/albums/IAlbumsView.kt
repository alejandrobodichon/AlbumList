package com.example.albumlistapplication.ui.main.albums

import com.example.albumlistapplication.model.AlbumModel
import com.google.gson.JsonArray


interface IAlbumsView {

    fun renderAlbumList(albumsList : List<AlbumModel>)

    fun showError()

    fun showLoading()

    fun hideLoading()

}
