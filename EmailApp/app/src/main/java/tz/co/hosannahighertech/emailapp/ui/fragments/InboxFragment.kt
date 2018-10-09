package tz.co.hosannahighertech.emailapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_inbox.view.*
import org.json.JSONArray
import org.json.JSONObject
import tz.co.hosannahighertech.emailapp.R
import tz.co.hosannahighertech.emailapp.models.Email
import tz.co.hosannahighertech.emailapp.ui.SimpleDividerItemDecoration
import tz.co.hosannahighertech.emailapp.ui.adapters.EmailAdapter
import java.nio.charset.Charset

class InboxFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inbox, container, false)

        view.inboxList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        view.inboxList.itemAnimator = DefaultItemAnimator()
        view.inboxList.addItemDecoration(SimpleDividerItemDecoration(context!!))

        val items: List<Email> = itemsFromJson()
        view.inboxList.adapter = EmailAdapter(items)

        return view
    }

    private fun itemsFromJson(): List<Email> {
        val inputStream = activity!!.resources.openRawResource(R.raw.fake_emails)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.defaultCharset())
        val emails = mutableListOf<Email>()

        val data = JSONArray(json)
        for(i in 0 until data.length())
        {
            val o = data.getJSONObject(i)

            emails.add(Email(o.getBoolean("is_read"),
                    o.getString("subject"),
                    o.getString("photo"),
                    o.getString("from"),
                    o.getInt("id"),
                    o.getString("time"),
                    o.getString("message"),
                    o.getString("email")))
        }

        return emails
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment InboxFragment.
         */

        @JvmStatic
        fun newInstance(): InboxFragment {
            return InboxFragment().apply {
                arguments = Bundle()
            }
        }
    }
}
