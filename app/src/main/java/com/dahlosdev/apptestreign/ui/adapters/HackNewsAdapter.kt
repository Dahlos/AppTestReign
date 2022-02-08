package com.dahlosdev.apptestreign.ui.adapters

import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dahlosdev.apptestreign.R
import com.dahlosdev.apptestreign.domain.model.HackNews
import com.dahlosdev.apptestreign.ui.viewmodel.HackNewsViewModel

//class HackNewsAdapter(private var hackNewsList: List<HackNews>) :
class HackNewsAdapter(
    private var hackNewsList: List<HackNews>,
    private val hackNewsViewModel: HackNewsViewModel
) :
    RecyclerView.Adapter<HackNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HackNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HackNewsViewHolder(layoutInflater.inflate(R.layout.hack_news_item, parent, false))
    }

    override fun onBindViewHolder(holder: HackNewsViewHolder, position: Int) {
        holder.render(hackNewsList[position])
    }

    override fun getItemCount(): Int = hackNewsList.size

    fun clearItems() {
        val size: Int = hackNewsList.size
        if (size > 0) {
            (hackNewsList as MutableList).clear()
            notifyItemRangeRemoved(0, size)
        }
    }

    fun deleteItem(i: Int) {
        hackNewsList =
            hackNewsList.filter { hackNews -> hackNews.objectID != hackNewsList[i].objectID }
        hackNewsViewModel.onDeleteHackNews(hackNewsList[i])
        notifyItemRemoved(i)
        notifyDataSetChanged()
    }

    fun addItems(hackNewsList: List<HackNews>) {
        this.hackNewsList = hackNewsList
        notifyDataSetChanged()
    }
}



