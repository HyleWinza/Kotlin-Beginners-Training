package tz.co.hosannahighertech.restoapp.data.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import tz.co.hosannahighertech.restoapp.data.models.LoginForm
import tz.co.hosannahighertech.restoapp.data.models.MessageResponse

interface AuthApi {
    @POST("/api/auth/login")
    fun doLogin(@Body form: LoginForm): Call<MessageResponse>

}