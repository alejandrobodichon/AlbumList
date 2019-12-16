package com.example.albumlistapplication.ui.main.albums

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.albumlistapplication.R
import com.example.albumlistapplication.model.AlbumModel
import com.example.albumlistapplication.ui.main.MainActivity
import com.example.albumlistapplication.ui.main.photos.PhotosFragment
import com.example.albumlistapplication.ui.main.photos.PhotosFragment.Companion.ALBUM_ID
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_albums_list.*
import javax.inject.Inject

class AlbumsFragment: WolmoFragment<AlbumsPresenter>(), IAlbumsView {

    @Inject internal lateinit var toastFactory: ToastFactory

    override fun init() {
        presenter.getDownloadDetails()
    }

    override fun layout(): Int = R.layout.fragment_albums_list

    override fun renderAlbumList(albumsList: List<AlbumModel>) {
        val listener = object : AlbumsAdapterListener {

            override fun goToSelectedAlbum(album: AlbumModel) {
                val bundle = Bundle()
                bundle.putInt(ALBUM_ID, album.id)
                val photoFragment = PhotosFragment()
                photoFragment.arguments= bundle
                (activity as MainActivity).replaceFragment(photoFragment,R.id.vBaseContent,true,"Photos grid")

            }
        }
        vAlbumsListRecycler.layoutManager = LinearLayoutManager(requireContext())
        val albumsAdapter = AlbumsAdapter(listener)
        vAlbumsListRecycler.adapter = albumsAdapter
        albumsAdapter.submitList(albumsList)

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

    override fun onResume() {
        super.onResume()
        activity?.title = "Album list"
    }

    override fun showError() {
        ToastFactory(context).apply { show("Something went wrong, please try again.") }
    }
}