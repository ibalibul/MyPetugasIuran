package com.example.mylaporpetugas.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDataWisataItem(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("deskrpsi")
    val deskrpsi: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("updatedAt")
    val updatedAt: String
):Serializable