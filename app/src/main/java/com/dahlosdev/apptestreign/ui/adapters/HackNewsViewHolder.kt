package com.dahlosdev.apptestreign.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.databinding.HackNewsItemBinding
import com.dahlosdev.apptestreign.domain.model.HackNews

class HackNewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = HackNewsItemBinding.bind(view)
    fun render(hackNewsModel: HackNews) {
        binding.txtTitle.text = hackNewsModel.title ?: hackNewsModel.story_title
        binding.txtAuthor.text = hackNewsModel.author
        binding.itemHackNews

        itemView.setOnClickListener {
//            Toast.makeText(
//                binding.itemHackNews.context,
//                hit.story_url ?: "URL NOT FOUND",
//                Toast.LENGTH_SHORT
//            ).show()
//            val intent = Intent(itemView.context, HackNewsDetailActivity::class.java).apply {
//                putExtra("story_url", hit.story_url)
//            }
//            itemView.context.startActivity(intent)

        }

    }

}