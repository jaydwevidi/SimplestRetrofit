package com.example.cryptomaster.recyclerView

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptomaster.R
import com.example.cryptomaster.retrofit.CryptoList

class MyRvAdapter(val dataset : CryptoList) : RecyclerView.Adapter<MyRvAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(
            parent.context ,).inflate(R.layout.currency , parent , false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.currecyName.text = dataset[position].name
    }

    override fun getItemCount() = dataset.size

    inner class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val currecyName : TextView = itemView.findViewById(R.id.tvCurrencyName)

    }
}