package tz.co.hosannahighertech.restoapp.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.hotels_fragment.*
import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.ui.activities.MainActivity
import tz.co.hosannahighertech.restoapp.ui.adapters.HotelsAdapter
import tz.co.hosannahighertech.restoapp.ui.viewmodels.HotelsViewModel

class HotelsFragment : Fragment() {

    private val adapter = HotelsAdapter()

    companion object {
        fun newInstance() = HotelsFragment()
    }

    private lateinit var viewModel: HotelsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hotels_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this!!.activity!!).get(HotelsViewModel::class.java)

        hotelsList.itemAnimator = DefaultItemAnimator()
        hotelsList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        hotelsList.adapter = adapter

        //get notified of error
        viewModel.error.observe(
            this,
            Observer { message -> Toast.makeText(activity, message, Toast.LENGTH_LONG).show() })

        //update data
        viewModel.data.observe(this, Observer { hotels ->
            if (hotels != null)
                adapter.update(hotels)
        })

        viewModel.networkProgress.observe(this, Observer { isNetProgress ->
            run {
                val mainActivity = activity as MainActivity
                mainActivity.showProgress(isNetProgress)
            }
        })

        viewModel.loadHotels()
    }
}
