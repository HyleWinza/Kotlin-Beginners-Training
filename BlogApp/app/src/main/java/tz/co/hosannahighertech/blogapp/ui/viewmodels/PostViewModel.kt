package tz.co.hosannahighertech.blogapp.ui.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tz.co.hosannahighertech.blogapp.api.BlogApi
import tz.co.hosannahighertech.blogapp.models.Post

/**
 * @package tz.co.hosannahighertech.blogapp.ui.viewmodels
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 10/10/2018 19:01.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
class PostViewModel(app:Application) : AndroidViewModel(app) {
    private val livePosts = MutableLiveData<List<Post>>()
    private val liveNetStatus = MutableLiveData<Boolean>()

    fun getPostLiveData() : LiveData<List<Post>>
    {
        return livePosts
    }

    fun getNetStatus() : LiveData<Boolean>
    {
        return liveNetStatus
    }

    fun loadPosts() {
        val api = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(BlogApi::class.java)

        liveNetStatus.postValue(true) //start loading

        api.getPosts().enqueue(object:Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                liveNetStatus.postValue(false)
                //display error message
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                liveNetStatus.postValue(false)
                livePosts.postValue(response.body())
            }

        })

    }
}