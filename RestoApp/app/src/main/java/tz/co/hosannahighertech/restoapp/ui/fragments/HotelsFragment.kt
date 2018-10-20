package tz.co.hosannahighertech.restoapp.ui.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.ui.viewmodels.HotelsViewModel

class HotelsFragment : Fragment() {

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
        viewModel = ViewModelProviders.of(this).get(HotelsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
