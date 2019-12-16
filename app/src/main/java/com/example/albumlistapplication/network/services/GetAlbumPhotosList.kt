package com.example.albumlistapplication.network.services

import com.example.albumlistapplication.model.PhotoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetAlbumPhotosList {

    @GET("/photos")
    fun getAlbumList(
        @Query("albumId") albumId: String
    ): Call<List<PhotoModel>>
}