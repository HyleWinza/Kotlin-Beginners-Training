package tz.co.hosannahighertech.blogapp.models

import com.google.gson.annotations.SerializedName

/**
 * @package tz.co.hosannahighertech.blogapp.models
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 10/10/2018 17:45.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
data class Post(@SerializedName("userId") val userId:Int = 0,
                @SerializedName("id")val id:Int = 0,
                @SerializedName("title") val title: String = "",
                @SerializedName("body") val body: String = "")