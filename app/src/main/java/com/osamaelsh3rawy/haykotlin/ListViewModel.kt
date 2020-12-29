package com.osamaelsh3rawy.haykotlin

import android.content.ContentValues.TAG
import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osamaelsh3rawy.data.PostsData
import com.osamaelsh3rawy.network.ApiClient
import com.osamaelsh3rawy.network.ApiServies
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel : ViewModel() {
    val list = MutableLiveData<List<PostsData>>()
    val apiServies :ApiServies =ApiClient.apiServies
    val getposts: MutableLiveData<List<PostsData>>get() = list
    init {
        getdata()
    }

    private fun getdata() {
        GlobalScope.launch {
            try {
                val postsFromApi = apiServies.GetPosts()
                list.postValue(postsFromApi)
            } catch (e: Exception){
                Log.d(TAG, "getdata: ${e.message}")
            }
        }}

}