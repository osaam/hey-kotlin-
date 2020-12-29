package com.osamaelsh3rawy.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val Base_Url = "https://jsonplaceholder.typicode.com/"
    val apiServies: ApiServies = getRetrofit()
    private fun getRetrofit(): ApiServies {
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServies::class.java)
    }
}