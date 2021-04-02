package com.example.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.githubsearch.databinding.ActivityMainBinding
import com.example.githubsearch.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setup()
    }

    private fun setup() {
        binding.recyclerView.apply { adapter = viewModel.userListAdapter }
        viewModel.userList.observe(this,
            Observer {
                viewModel.userListAdapter.submitList(it)
            }
        )
    }
}