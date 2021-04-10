package com.cjzt.nicapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cjzt.nicapp.model.Place
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_place.view.*
import com.cjzt.nicapp.R

class AdapterPlaces () : RecyclerView.Adapter<AdapterPlaces.ViewHolder>() {

    lateinit var items: ArrayList<Place>

    fun setPlaces(items: List<Place>){
        this.items = items as ArrayList<Place>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val placeImage: ImageView = view.place_image
        val name: TextView = view.name
        val descripton: TextView = view.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.name.text = model.name
        holder.descripton.text = model.description
        Picasso.get()
            .load(model.image)
            .into(holder.placeImage)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }
}