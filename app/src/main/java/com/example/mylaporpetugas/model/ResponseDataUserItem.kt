package com.example.mylaporpetugas.model


import com.google.gson.annotations.SerializedName

data class ResponseDataUserItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("notlp")
    val notlp: Long,
    @SerializedName("password")
    val password: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)