package com.example.trueclubassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(val context: Context, val list: List<Country>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.result_list_item, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {

        val article = list[position]
        holder.country.text = "Country : ${article.country_id}"
        holder.prob.text = "Probability : ${article.probability}"

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var country = itemView.findViewById<TextView>(R.id.country)
        var prob = itemView.findViewById<TextView>(R.id.prob)
    }

}