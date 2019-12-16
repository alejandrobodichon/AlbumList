package com.example.albumlistapplication.ui.main.photos

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.albumlistapplication.R
import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.model.PhotoModel
import com.example.albumlistapplication.ui.main.MainActivity
import com.example.albumlistapplication.ui.main.photodetail.PhotoDetailFragment
import com.example.albumlistapplication.ui.main.photodetail.PhotoDetailFragment.Companion.ALBUM
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_albums_list.*
import kotlinx.android.synthetic.main.fragment_photos_list.*
import javax.inject.Inject

class PhotosFragment: WolmoFragment<PhotosPresenter>(), IPhotosView {

    override fun init() {
        arguments?.getInt(ALBUM_ID)?.let {
            presenter.getPhotosList(it.toString())
        }
    }

    override fun layout(): Int = R.layout.fragment_photos_list

    override fun renderPhotosList(photosList: List<PhotoModel>) {
        val listener = object : PhotosAdapterListener {

            override fun goToSelectedPhoto(album: PhotoModel) {
                val bundle = Bundle()
                bundle.putSerializable(ALBUM, album)
                val photoDetailFragment = PhotoDetailFragment()
                photoDetailFragment.arguments= bundle
                (activity as MainActivity).replaceFragment(photoDetailFragment,R.id.vBaseContent,true,"Photo detail")
            }
        }

        vPhotosListRecycler.layoutManager = GridLayoutManager(requireContext(),2)
        val photosAdapter = PhotosAdapter(listener)
        vPhotosListRecycler.adapter = photosAdapter
        photosAdapter.submitList(photosList)
    }

    override fun showError() {
        ToastFactory(context).apply { show("Something went wrong, please try again.") }
    }

    override fun onResume() {
        super.onResume()
        activity?.setTitle("Photos grid")

    }

    override fun showLoading() {
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        requireActivity().vProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        requireActivity().vProgressBar.visibility = View.GONE
    }

    companion object {
        const val ALBUM_ID ="albumId"
    }
}