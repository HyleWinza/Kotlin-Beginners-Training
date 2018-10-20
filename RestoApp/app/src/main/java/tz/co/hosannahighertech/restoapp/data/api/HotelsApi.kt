package tz.co.hosannahighertech.restoapp.data.api

import retrofit2.Call
import retrofit2.http.GET
import tz.co.hosannahighertech.restoapp.data.models.Hotel


interface HotelsApi {
    @GET("/api/restos")
    fun allHotels(): Call<List<Hotel>>
}
