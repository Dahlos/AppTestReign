package com.dahlosdev.apptestreign.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.dahlosdev.apptestreign.R
import com.dahlosdev.apptestreign.databinding.ActivityMainBinding
import com.dahlosdev.apptestreign.ui.viewmodel.HackNewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val hackNewsViewModel: HackNewsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     //   hackNewsViewModel.onCreate()
        hackNewsViewModel.getHackNewsPage(2)

        hackNewsViewModel.hackNewsModel.observe(this, Observer {
            binding.txtTest.text = it.hits[0].story_title
        })

    }
}