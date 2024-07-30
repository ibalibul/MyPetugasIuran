package com.example.mylaporpetugas.network


import com.example.mylaporpetugas.data.DataUsers
import com.example.mylaporpetugas.model.ResponseDataPengaduanItem
import com.example.mylaporpetugas.model.ResponseDataUserItem
import com.example.mylaporpetugas.model.ResponseDataWisataItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ResfulApi {


    @GET("users")
    fun getalluser(): Call<List<ResponseDataUserItem>>

    @POST("users")
    fun addPostUser(@Body request: DataUsers) : Call<ResponseDataUserItem>

    @GET("potensidesa")
    fun getallpotensidesa() : Call<List<ResponseDataWisataItem>>

    @GET("pengaduan")
    fun getallPengaduan() : Call<List<ResponseDataPengaduanItem>>

//    @POST("film")
//    fun addPostfilm(@Body request: DataFilm) : Call<ResponseDataFilmItem>
}