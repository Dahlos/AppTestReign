package com.dahlosdev.apptestreign.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.dahlosdev.apptestreign.databinding.ActivityMainBinding
import com.dahlosdev.apptestreign.ui.adapters.HackNewsAdapter
import com.dahlosdev.apptestreign.ui.viewmodel.HackNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val hackNewsViewModel: HackNewsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val manager = LinearLayoutManager(this)

        hackNewsViewModel.onCreate()

        hackNewsViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        hackNewsViewModel.isRefreshing.observe(this, Observer {
            binding.swRefresh.isRefreshing = it
        })

        hackNewsViewModel.hackNewsModel.observe(this, Observer {
            binding.rvHackNews.layoutManager = manager
            binding.rvHackNews.adapter = HackNewsAdapter(it)
            if (binding.rvHackNews.itemDecorationCount == 0) {
                val decoration = DividerItemDecoration(this, manager.orientation)
                binding.rvHackNews.addItemDecoration(decoration)
            }
        })

        binding.swRefresh.setOnRefreshListener(OnRefreshListener {
            hackNewsViewModel.onRefresh()
        })
    }
}