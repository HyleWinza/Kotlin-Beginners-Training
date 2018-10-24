package tz.co.hosannahighertech.restoapp.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.data.models.HotelMenu
import tz.co.hosannahighertech.restoapp.interfaces.MenuClickListerner
import tz.co.hosannahighertech.restoapp.ui.adapters.MenuAdapter
import tz.co.hosannahighertech.restoapp.ui.viewmodels.MenuViewModel
import tz.co.hosannahighertech.restoapp.utilities.Constants

class MenuActivity : AppCompatActivity(), MenuClickListerner {

    private val adapter = MenuAdapter(this)
    private var preferences: SharedPreferences? = null
    private var restoId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        preferences = applicationContext.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE)

        menuList.itemAnimator = DefaultItemAnimator()
        menuList.layoutManager = GridLayoutManager(this, 2)
        menuList.adapter = adapter

        viewModel.data.observe(this, Observer {
            it?.apply {
                adapter.update(this)
            }
        })

        viewModel.buyNow.observe(this, Observer {
            it?.apply {
                Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()
                if (success) {
                    loadMenu()
                }
            }
        })

        intent?.apply {
            supportActionBar?.title = getStringExtra(Constants.HOTEL_NAME)
            restoId = getIntExtra(Constants.HOTEL_ID, 0)

            loadMenu()
        }
    }

    private fun loadMenu() {
        val viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        val token = preferences?.getString(Constants.PREF_ACCESS_TOKEN, "")
        viewModel.loadMenu(restoId, token)
    }

    override fun onClick(menu: HotelMenu) {
        val viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        AlertDialog.Builder(this)
            .setPositiveButton(R.string.btn_title_buy_now) { dialog, which ->
                //Buy now
                val token = preferences?.getString(Constants.PREF_ACCESS_TOKEN, "")
                viewModel.buyNow(menu.restaurant, menu.food, token)
            }
            .setNegativeButton(R.string.cancel) { dialog, which ->
                //cancel clicked
            }
            .setTitle(menu.foodName+" "+menu.unitPrice+" "+menu.currency)
            .setMessage("${menu.foodDesc}\n\nContinue and buy the food?")
            .show()
    }
}
