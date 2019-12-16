package com.example.albumlistapplication.ui.main.photos

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

class PhotosPresenter @Inject constructor(
    private val retrofitServices: RetrofitServices

) : BasePresenter<IPhotosView>() {

    fun getPhotosList(albumId: String) {
        view.showLoading()
        retrofitServices.getService(GetAlbumPhotosList::class.java).getAlbumList(albumId = albumId
        ).enqueue(
            object : AuthCallback<List<PhotoModel>>(this@PhotosPresenter) {
                override fun onResponseSuccessful(
                    response: Response<List<PhotoModel>>,
                    photosList: List<PhotoModel>?
                ) {

                    view.renderPhotosList(photosList!!)
                    view.hideLoading()
                }

                override fun onResponseFailed(responseBody: ResponseBody?, code: Int) {
                    view.showError()
                    view.hideLoading()
                }

                override fun onCallFailure(t: Throwable) {
                    view.showError()
                    view.hideLoading()
                }
            })
    }
}
