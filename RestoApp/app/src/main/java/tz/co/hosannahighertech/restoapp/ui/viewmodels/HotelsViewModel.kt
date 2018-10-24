package tz.co.hosannahighertech.restoapp.ui.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tz.co.hosannahighertech.restoapp.data.models.Hotel
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import tz.co.hosannahighertech.restoapp.data.api.HotelsApi
import tz.co.hosannahighertech.restoapp.utilities.Constants


class HotelsViewModel(val app: Application) : AndroidViewModel(app) {
    val data = MutableLiveData<List<Hotel>>()
    val error = MutableLiveData<String>()
    val networkProgress = MutableLiveData<Boolean>()
    var prefs: SharedPreferences? = null

    init {
        prefs = app.applicationContext.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun loadHotels() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.100:8080/index.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<HotelsApi>(HotelsApi::class.java)

        //get data from API
        //Notify that we are about to call the network
        networkProgress.postValue(true)
        var accessToken: String? = null

        prefs?.apply {
            accessToken = getString(Constants.PREF_ACCESS_TOKEN, "")
        }


        service.allHotels(accessToken).enqueue(object : Callback<List<Hotel>> {
            override fun onFailure(call: Call<List<Hotel>>, t: Throwable) {
                networkProgress.postValue(false)
                error.postValue(t.message)
            }

            override fun onResponse(call: Call<List<Hotel>>, response: Response<List<Hotel>>) {
                networkProgress.postValue(false)
                data.postValue(response.body())
            }
        })

    }
}
