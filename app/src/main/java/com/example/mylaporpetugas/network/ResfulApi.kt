package com.example.mylaporpetugas.network


import com.example.mylaporpetugas.model.ResponseDataWisataItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ResfulApi {


//    @GET("film")
//    fun getAllfilm() : Call<List<ResponseDataFilmItem>>

    @GET("potensidesa")
    fun getallpotensidesa() : Call<List<ResponseDataWisataItem>>

//    @POST("film")
//    fun addPostfilm(@Body request: DataFilm) : Call<ResponseDataFilmItem>
//
//    @GET("user")
//    fun getalluser(): Call<List<ResponseDataUserItem>>
//
//    @POST("user")
//    fun addPostUser(@Body request: DataUser)



}