package com.dahlosdev.apptestreign.ui.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.dahlosdev.apptestreign.databinding.ActivityMainBinding
import com.dahlosdev.apptestreign.ui.adapters.HackNewsAdapter
import com.dahlosdev.apptestreign.ui.helper.SwipeGesture
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

        hackNewsViewModel.onCreate()

        hackNewsViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        hackNewsViewModel.isRefreshing.observe(this, Observer {
            binding.swRefresh.isRefreshing = it
        })

        val manager = LinearLayoutManager(this)
        binding.rvHackNews.layoutManager = manager
        val adapter = HackNewsAdapter(emptyList(), hackNewsViewModel)
        val swipeGesture = object : SwipeGesture(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        adapter.deleteItem(viewHolder.absoluteAdapterPosition)
                    }
                }
            }
        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(binding.rvHackNews)

        binding.rvHackNews.adapter = adapter

        if (binding.rvHackNews.itemDecorationCount == 0) {
            val decoration = DividerItemDecoration(this, manager.orientation)
            binding.rvHackNews.addItemDecoration(decoration)
        }

        hackNewsViewModel.hackNewsModel.observe(this, Observer {
            adapter.addItems(it)
        })

        binding.swRefresh.setOnRefreshListener(OnRefreshListener {
            hackNewsViewModel.onRefresh()
        })
    }

}