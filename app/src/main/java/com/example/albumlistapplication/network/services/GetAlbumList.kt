package com.example.albumlistapplication.network.services

import com.example.albumlistapplication.model.AlbumModel
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface GetAlbumList {

    @GET("/albums")
    fun getAlbumList(
    ): Call<List<AlbumModel>>
}