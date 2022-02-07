package com.dahlosdev.apptestreign.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dahlosdev.apptestreign.R
import com.dahlosdev.apptestreign.domain.model.HackNews

class HackNewsAdapter(private var hackNewsList: List<HackNews>) :
    RecyclerView.Adapter<HackNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HackNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HackNewsViewHolder(layoutInflater.inflate(R.layout.hack_news_item, parent, false))
    }

    override fun onBindViewHolder(holder: HackNewsViewHolder, position: Int) {
        holder.render(hackNewsList[position])
        holder.itemView.setOnClickListener {
            hackNewsList =
                hackNewsList.filterNot { it.objectID == hackNewsList[position].objectID }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = hackNewsList.size

}


