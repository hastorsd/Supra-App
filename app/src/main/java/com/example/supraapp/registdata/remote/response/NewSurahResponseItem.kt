package com.example.supraapp.registdata.remote.response


import com.google.gson.annotations.SerializedName

data class NewSurahResponseItem(
    @SerializedName("arti")
    val arti: String,
    @SerializedName("audio")
    val audio: String,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("jumlah_ayat")
    val jumlahAyat: Int,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("nama_latin")
    val namaLatin: String,
    @SerializedName("nomor")
    val nomor: Int,
    @SerializedName("tempat_turun")
    val tempatTurun: String
)