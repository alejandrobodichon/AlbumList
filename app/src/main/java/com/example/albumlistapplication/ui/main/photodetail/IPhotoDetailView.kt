package com.example.albumlistapplication.ui.main.photodetail

import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.model.PhotoModel
import com.google.gson.JsonArray


interface IPhotoDetailView {

    fun renderPhotoDetail(photo : PhotoModel)

    fun showError()

}
