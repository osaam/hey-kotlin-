package com.osamaelsh3rawy.network

import android.service.autofill.UserData
import com.osamaelsh3rawy.data.PostsData
import retrofit2.http.GET

interface ApiServies {

    @GET("posts")
    suspend fun GetPosts(): List<PostsData>
    fun get():List<PostsData>
}