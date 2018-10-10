package tz.co.hosannahighertech.blogapp.api

import retrofit2.Call
import retrofit2.http.GET
import tz.co.hosannahighertech.blogapp.models.Post

/**
 * @package tz.co.hosannahighertech.blogapp.models
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 10/10/2018 19:56.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
interface BlogApi {

    @GET("posts")
    fun getPosts() : Call<List<Post>>
}