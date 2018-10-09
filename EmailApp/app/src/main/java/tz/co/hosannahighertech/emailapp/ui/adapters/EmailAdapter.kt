package tz.co.hosannahighertech.emailapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.email_list_item.view.*
import tz.co.hosannahighertech.emailapp.R
import tz.co.hosannahighertech.emailapp.models.Email

/**
 * @package tz.co.hosannahighertech.emailapp.ui.adapters
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 08/10/2018 20:20.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
class EmailAdapter(val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_list_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = emails.get(position)

        //set values
        holder.view.sender.text = model.from
        holder.view.time.text = model.time.replace(" ", "\n")//time in new line

        holder.view.subject.text = model.subject.substring(0, model.subject.indexOf('.')).let { subject: String ->
            if (subject.length > 50)
                subject.substring(0, 49) //50 or less only
            else
            subject
        }

        holder.view.preview.text = model.message.substring(0, model.message.indexOf('\n')).let { subject: String ->
            if (subject.length > 100)
                subject.substring(0, 99) //100 or less only
            else
                subject
        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    //Vieholder class
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}