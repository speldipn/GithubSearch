package com.example.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearch.databinding.ActivityMainBinding
import com.example.githubsearch.ui.MainViewModel
import com.example.githubsearch.ui.user.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setup()
    }

    private fun setup() {
        val userListAdapter = UserListAdapter()
        binding.recyclerView.apply {
            adapter = userListAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    companion object {
        const val TAG = "speldipn"
    }
}