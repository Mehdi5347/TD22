package com.example.td2.data

import retrofit2.http.GET
import retrofit2.Call

interface FruitInterface {
    @GET("api.json")
    Call<RestFruitApiResponse> getNom()
}