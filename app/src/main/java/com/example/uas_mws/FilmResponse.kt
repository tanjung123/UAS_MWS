package com.example.uas_mws

import com.google.gson.annotations.SerializedName

data class FilmResponse (
    val image : String?,
    val title : String?,
    val director : String?,
    val producer : String?,
    //SerializedName digunakan untuk alias
    @SerializedName("description")
    val desc : String?,
    @SerializedName("release_date")
    val release : String?,
    @SerializedName("running_time")
    val time : String?,
    @SerializedName("rt_score")
    val rating : String?
)