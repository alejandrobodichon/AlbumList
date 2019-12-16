package com.example.albumlistapplication.ui.main.photos

import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.model.PhotoModel
import com.google.gson.JsonArray


interface IPhotosView {

    fun renderPhotosList(photosList : List<PhotoModel>)

    fun showError()

    fun showLoading()

    fun hideLoading()
}
