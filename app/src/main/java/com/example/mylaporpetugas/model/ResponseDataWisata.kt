package com.example.mylaporpetugas.model


import com.google.gson.annotations.SerializedName

data class ResponseDataWisata(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<ResponseDataWisataItem>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)