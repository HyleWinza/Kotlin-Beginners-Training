package tz.co.hosannahighertech.restoapp.data.models

import com.google.gson.annotations.SerializedName

data class MessageResponse(@SerializedName("success") val success: Boolean,
                           @SerializedName("message") val message: String)