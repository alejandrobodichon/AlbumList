package com.example.albumlistapplication.ui.main.albums

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.network.callback.AuthCallback
import com.example.albumlistapplication.network.services.GetAlbumList
import com.google.gson.JsonArray
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AlbumsPresenter @Inject constructor(
    private val retrofitServices: RetrofitServices

) : BasePresenter<IAlbumsView>() {

    fun getDownloadDetails() {
        view.showLoading()
        retrofitServices.getService(GetAlbumList::class.java).getAlbumList(
        ).enqueue(
            object : AuthCallback<List<AlbumModel>>(this@AlbumsPresenter) {
                override fun onResponseSuccessful(
                    response: Response<List<AlbumModel>>,
                    albumsList: List<AlbumModel>?
                ) {

                    view.renderAlbumList(albumsList!!)
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
