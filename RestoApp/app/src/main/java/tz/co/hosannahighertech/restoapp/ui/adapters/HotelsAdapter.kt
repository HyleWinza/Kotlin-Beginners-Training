package tz.co.hosannahighertech.restoapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.hotels_list_item.view.*
import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.data.models.Hotel

class HotelsAdapter : Adapter<HotelsAdapter.ViewHolder>() {

    private val hotelsList: MutableList<Hotel> = mutableListOf()


    fun update(hotels: List<Hotel>) {
        hotelsList.clear()
        hotels.forEach { hotelsList.add(it)}

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.hotels_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  hotelsList.size
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val hotel = hotelsList[position]

        vh.view.name.text = hotel.name
        vh.view.address.text = hotel.address
        vh.view.category.text = hotel.category

        //load image
        Glide.with(vh.view.context)
            .load(hotel.logo)
            .into(vh.view.logo)
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}