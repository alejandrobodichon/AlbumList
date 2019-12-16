package com.example.albumlistapplication.ui.main.photodetail

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.albumlistapplication.R
import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.model.PhotoModel
import com.example.albumlistapplication.ui.main.MainActivity
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.fragment_albums_list.*
import kotlinx.android.synthetic.main.fragment_photo_detail.*
import kotlinx.android.synthetic.main.fragment_photos_list.*
import javax.inject.Inject

class PhotoDetailFragment: WolmoFragment<PhotoDetailPresenter>(),IPhotoDetailView {

    override fun init() {
        arguments?.getSerializable(ALBUM)?.let {
            presenter.onArgumetsReceived(it as PhotoModel)
        }
    }

    override fun layout(): Int = R.layout.fragment_photo_detail

    override fun renderPhotoDetail(photo: PhotoModel) {
        vPhotoDetailImage.setImageURI(photo.url)
        vPhotoDetailTitle.text = photo.title
    }


    override fun showError() {
        ToastFactory(context).apply { show("Something went wrong, please try again.") }
    }

    override fun onResume() {
        super.onResume()
        activity?.setTitle("Photo detail")
    }

    companion object {
        const val ALBUM ="album"
    }
}