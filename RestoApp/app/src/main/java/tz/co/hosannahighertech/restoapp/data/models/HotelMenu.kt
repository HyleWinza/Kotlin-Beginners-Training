package tz.co.hosannahighertech.restoapp.data.models

import com.google.gson.annotations.SerializedName

data class HotelMenu(@SerializedName("food_name")
                val foodName: String = "",
                     @SerializedName("restaurant")
                val restaurant: Int = 0,
                     @SerializedName("available")
                val available: Int = 0,
                     @SerializedName("resto_name")
                val restoName: String = "",
                     @SerializedName("photo")
                val photo: String = "",
                     @SerializedName("currency")
                val currency: String = "",
                     @SerializedName("food_desc")
                val foodDesc: String = "",
                     @SerializedName("unit_price")
                val unitPrice: Int = 0,
                     @SerializedName("food")
                val food: Int = 0)