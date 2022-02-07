package com.dahlosdev.apptestreign.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dahlosdev.apptestreign.R
import com.dahlosdev.apptestreign.data.model.HitModel

class HackNewsAdapter(private val hackNewsList: MutableList<HitModel>) :
    RecyclerView.Adapter<HackNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HackNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HackNewsViewHolder(layoutInflater.inflate(R.layout.hack_news_item, parent, false))
    }

    override fun onBindViewHolder(holder: HackNewsViewHolder, position: Int) {
        holder.render(hackNewsList[position])
    }

    override fun getItemCount(): Int = hackNewsList.size

    fun deleteItem(i: Int) {
        hackNewsList.removeAt(i)
        notifyDataSetChanged()
    }
}

