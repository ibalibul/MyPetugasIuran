package com.example.mylaporpetugas.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://3e85-114-124-213-114.ngrok-free.app/"

    private val logging : HttpLoggingInterceptor
        get(){
            val httpLoginInterceotor = HttpLoggingInterceptor()
            return httpLoginInterceotor.apply {
                httpLoginInterceotor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    val instance : ResfulApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ResfulApi::class.java)
    }
}