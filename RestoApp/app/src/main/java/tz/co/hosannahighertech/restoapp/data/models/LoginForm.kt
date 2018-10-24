package tz.co.hosannahighertech.restoapp.data.models

import com.google.gson.annotations.SerializedName

data class LoginForm(@SerializedName("username") val username: String,
                     @SerializedName("password") val password: String)