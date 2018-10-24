package tz.co.hosannahighertech.restoapp.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tz.co.hosannahighertech.restoapp.data.api.HotelsApi
import tz.co.hosannahighertech.restoapp.data.models.HotelMenu
import tz.co.hosannahighertech.restoapp.data.models.MessageResponse

/**
 * @package tz.co.hosannahighertech.restoapp.ui.viewmodels
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 23/10/2018 19:50.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
class MenuViewModel() : ViewModel() {

    val data = MutableLiveData<List<HotelMenu>>()
    val buyNow = MutableLiveData<MessageResponse>()


    fun loadMenu(resto: Int, accessToken: String?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.100:8080/index.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<HotelsApi>(HotelsApi::class.java)
        service.hotelMenu(resto, accessToken).enqueue(object : Callback<List<HotelMenu>>{

            override fun onFailure(call: Call<List<HotelMenu>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<HotelMenu>>, response: Response<List<HotelMenu>>) {
                data.postValue(response.body())
            }

        })
    }

    fun buyNow(restaurant: Int, food: Int, accessToken: String?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.100:8080/index.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<HotelsApi>(HotelsApi::class.java)
        service.buyNow(restaurant, food, accessToken).enqueue(object : Callback<MessageResponse>{

            override fun onFailure(call: Call<MessageResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MessageResponse>, response: Response<MessageResponse>) {
                response.body()?.apply {
                    buyNow.postValue(this)
                }
            }

        })
    }
}