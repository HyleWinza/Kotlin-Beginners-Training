package tz.co.hosannahighertech.restoapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.menu_list_item.view.*
import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.data.models.HotelMenu
import tz.co.hosannahighertech.restoapp.interfaces.MenuClickListerner

/**
 * @package tz.co.hosannahighertech.restoapp.ui.adapters
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 23/10/2018 19:29.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
class MenuAdapter(val clickListerner: MenuClickListerner) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    private  val menuList = mutableListOf<HotelMenu>()

    override fun onCreateViewHolder(parent: ViewGroup, item: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val menu = menuList[position]

        menu.apply {
            val pricing: String = unitPrice.toString()+" "+currency
            vh.view.foodName.text = foodName
            vh.view.price.text = pricing
            vh.view.remaining.text = available.toString()
        }

        Glide.with(vh.view)
                .load(menu.photo)
                .apply(RequestOptions().fitCenter())
                .into(vh.view.photo)

        vh.view.seeDetails.setOnClickListener{
            clickListerner.onClick(menu)
        }
    }

    override fun getItemCount(): Int {
        return  menuList.size
    }

    fun update(list: List<HotelMenu>)
    {
        menuList.clear()
        list.forEach {
            menuList.add(it)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}