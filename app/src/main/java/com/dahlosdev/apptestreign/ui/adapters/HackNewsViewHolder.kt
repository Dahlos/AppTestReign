package com.dahlosdev.apptestreign.ui.adapters

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.dahlosdev.apptestreign.R
import com.dahlosdev.apptestreign.data.model.HitModel
import com.dahlosdev.apptestreign.databinding.HackNewsItemBinding
import com.dahlosdev.apptestreign.ui.view.HackNewsDetailActivity

class HackNewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = HackNewsItemBinding.bind(view)
    fun render(hit: HitModel) {
        binding.txtTitle.text = hit.title ?: hit.story_title
        binding.txtAuthor.text = hit.author
        binding.itemHackNews

        itemView.setOnClickListener {
            Toast.makeText(
                binding.itemHackNews.context,
                hit.story_url ?: "URL NOT FOUND",
                Toast.LENGTH_SHORT
            ).show()
//            val intent = Intent()
//            intent.putExtra("story_url", hit.story_url)
            val intent = Intent(itemView.context, HackNewsDetailActivity::class.java).apply {
                putExtra("story_url", hit.story_url)
            }
            itemView.context.startActivity(intent)
        }
    }
}