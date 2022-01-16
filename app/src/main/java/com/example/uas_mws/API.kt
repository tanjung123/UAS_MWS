package com.example.uas_mws

import retrofit2.Call
import retrofit2.http.*

interface API {
    // Read
    @GET("films")
    fun getFilms() : Call<ArrayList<FilmResponse>>
}