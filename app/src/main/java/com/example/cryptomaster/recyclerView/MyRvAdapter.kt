package com.example.cryptomaster.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptomaster.R
import com.example.cryptomaster.retrofit.CryptoList
import com.example.cryptomaster.retrofit.CryptoListItem

class MyRvAdapter(val dataset : CryptoList)
    : RecyclerView.Adapter<MyRvAdapter.MyViewHolder>() , Filterable {
    val full = dataset.toList()

    var myFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = mutableListOf<CryptoListItem>()
            if (constraint.isNullOrEmpty())
                filteredList.addAll(full)
            else
                for (i in full) {
                    if (
                        i.name.contains(constraint, true)||
                        i.id.contains(constraint , true)||
                        i.rank.toString().contains(constraint, true)
                    )
                        filteredList.add(i)
                }

            val x = FilterResults()
            x.values = filteredList
            return x
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            dataset.clear()
            dataset.addAll(results?.values as MutableList<CryptoListItem>)
            notifyDataSetChanged()
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(
            parent.context ,).inflate(R.layout.currency , parent , false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.currencyName.text = dataset[position].name
        holder.rank.text = "#"+dataset[position].rank

        if(dataset[position].is_active)
        holder.isActive.text = "Active"
        else
            holder.isActive.text = "Inactive"

    }

    override fun getItemCount() = dataset.size

    inner class MyViewHolder(private val itemView : View):RecyclerView.ViewHolder(itemView){
        val currencyName : TextView = itemView.findViewById(R.id.cryptoName)
        val rank : TextView = itemView.findViewById(R.id.rankTV)
        val isActive : TextView = itemView.findViewById(R.id.isActive)

    }

    override fun getFilter() = myFilter
}