package tz.co.hosannahighertech.restoapp.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tz.co.hosannahighertech.restoapp.data.models.Hotel
import tz.co.hosannahighertech.restoapp.data.models.HotelMenu
import tz.co.hosannahighertech.restoapp.data.models.MessageResponse


interface HotelsApi {
    @GET("/api/restos")
    fun allHotels(@Query("access-token") token: String?): Call<List<Hotel>>

    @GET("/api/restos/menu")
    fun hotelMenu(@Query("resto") resto: Int, @Query("access-token") token: String?): Call<List<HotelMenu>>


    @GET("/api/restos/buy")
    fun buyNow(@Query("resto") resto: Int, @Query("food") food: Int, @Query("access-token") token: String?): Call<MessageResponse>
}
