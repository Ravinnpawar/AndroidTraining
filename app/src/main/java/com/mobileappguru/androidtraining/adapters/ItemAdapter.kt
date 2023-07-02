package com.mobileappguru.androidtraining.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobileappguru.androidtraining.R
import com.mobileappguru.data.Entry

class ItemAdapter(private val data: Array<Entry>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val textViewName :TextView=itemView.findViewById(R.id.api_name)
        val textViewDesc :TextView=itemView.findViewById(R.id.api_desc)
        val textViewLink :TextView=itemView.findViewById(R.id.api_link)
        val textViewCategory :TextView=itemView.findViewById(R.id.api_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val item= data[position]
        holder.textViewName.text=item.API
        holder.textViewDesc.text=item.Description
        holder.textViewLink.text=item.Link
        holder.textViewCategory.text=item.Category
    }
}