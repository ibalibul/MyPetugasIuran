package com.example.mylaporpetugas.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroftUser {

    const val BASE_URL = "https://6340e78716ffb7e275c7134c.mockapi.io/"

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
            .client(client)
            .build()
        retrofit.create(ResfulApi::class.java)
    }
}