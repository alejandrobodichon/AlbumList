package com.example.albumlistapplication.ui.main.photodetail

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.model.PhotoModel
import com.example.albumlistapplication.network.callback.AuthCallback
import com.example.albumlistapplication.network.services.GetAlbumList
import com.example.albumlistapplication.network.services.GetAlbumPhotosList
import com.google.gson.JsonArray
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PhotoDetailPresenter @Inject constructor(
) : BasePresenter<IPhotoDetailView>() {

    fun onArgumetsReceived(photo: PhotoModel) {
        view.renderPhotoDetail(photo)
    }
}
