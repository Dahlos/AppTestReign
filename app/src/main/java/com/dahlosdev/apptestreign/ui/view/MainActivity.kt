package com.dahlosdev.apptestreign.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dahlosdev.apptestreign.R
import com.dahlosdev.apptestreign.databinding.ActivityMainBinding
import com.dahlosdev.apptestreign.ui.adapters.HackNewsAdapter
import com.dahlosdev.apptestreign.ui.viewmodel.HackNewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val hackNewsViewModel: HackNewsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hackNewsViewModel.getHackNewsPage(2)

        hackNewsViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        hackNewsViewModel.hackNewsModel.observe(this, Observer {
            val manager = LinearLayoutManager(this)
            val decoration = DividerItemDecoration(this, manager.orientation)
            binding.rvHackNews.layoutManager = manager
            binding.rvHackNews.adapter = HackNewsAdapter(it.hits)
            binding.rvHackNews.addItemDecoration(decoration)

        })

    }
}