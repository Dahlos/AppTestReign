package com.dahlosdev.apptestreign.ui.adapters

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.databinding.HackNewsItemBinding
import com.dahlosdev.apptestreign.domain.model.HackNews
import com.dahlosdev.apptestreign.ui.helper.SwipeGesture
import com.dahlosdev.apptestreign.ui.view.HackNewsDetailActivity

class HackNewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = HackNewsItemBinding.bind(view)
    fun render(hackNewsModel: HackNews) {
        binding.txtTitle.text = hackNewsModel.title ?: hackNewsModel.story_title
        binding.txtAuthor.text = hackNewsModel.author


        itemView.setOnClickListener {

            if (hackNewsModel.story_url.isNullOrBlank()) {
                Toast.makeText(
                    binding.itemHackNews.context,
                    hackNewsModel.story_url ?: "URL NOT FOUND",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(itemView.context, HackNewsDetailActivity::class.java).apply {
                    putExtra("story_url", hackNewsModel.story_url)
                }
                itemView.context.startActivity(intent)
            }
        }
    }

}