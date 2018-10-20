package tz.co.hosannahighertech.restoapp.data.models

import com.google.gson.annotations.SerializedName

data class Hotel(@SerializedName("address")
                 val address: String = "",
                 @SerializedName("name")
                 val name: String = "",
                 @SerializedName("logo")
                 val logo: String = "",
                 @SerializedName("id")
                 val id: Int = 0,
                 @SerializedName("category")
                 val category: String = "")