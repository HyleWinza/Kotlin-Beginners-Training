package tz.co.hosannahighertech.restoapp.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.data.api.AuthApi
import tz.co.hosannahighertech.restoapp.data.models.LoginForm
import tz.co.hosannahighertech.restoapp.data.models.MessageResponse
import tz.co.hosannahighertech.restoapp.utilities.Constants

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_in_button.setOnClickListener {
            attemptLogin()
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private fun attemptLogin() {
        // Reset errors.
        username.error = null
        password.error = null

        // Store values at the time of the login attempt.
        val username = username.text.toString()
        val passwordStr = password.text.toString()

        var cancel = false
        var focusView: View? = null

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView?.requestFocus()
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true)

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.1.100:8080/index.php/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create<AuthApi>(AuthApi::class.java)

            val form = LoginForm(username, passwordStr)
            service.doLogin(form).enqueue(object: Callback<MessageResponse>{
                override fun onFailure(call: Call<MessageResponse>, t: Throwable) {
                    showProgress(false)
                    password.error = t.message
                }

                override fun onResponse(call: Call<MessageResponse>, response: Response<MessageResponse>) {
                    showProgress(false)
                    val result = response.body()
                    val prefs = applicationContext.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE)
                    result?.let {
                        val editor = prefs.edit()
                        editor.putString(Constants.PREF_ACCESS_TOKEN, it.message)
                        editor.commit()

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

            })

        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    private fun showProgress(show: Boolean) {
        login_progress.visibility = if (show) View.VISIBLE else View.GONE
        login_form.visibility = if (show) View.GONE else View.VISIBLE
    }
}
