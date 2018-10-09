package tz.co.hosannahighertech.emailapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tz.co.hosannahighertech.emailapp.R

class SentItemsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sent_items, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment SentItemsFragment.
         */

        @JvmStatic
        fun newInstance(): SentItemsFragment {
            return SentItemsFragment().apply {
                arguments = Bundle()
            }
        }
    }
}
