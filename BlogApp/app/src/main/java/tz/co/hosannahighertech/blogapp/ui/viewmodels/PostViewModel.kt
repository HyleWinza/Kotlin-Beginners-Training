package tz.co.hosannahighertech.blogapp.ui.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
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

    fun getPostLiveData() : LiveData<List<Post>>
    {
        return livePosts;
    }

    fun loadPosts() {

    }
}