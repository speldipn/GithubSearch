package com.example.githubsearch.ui

import androidx.lifecycle.ViewModel
import com.example.githubsearch.network.GithubApi
import com.example.githubsearch.network.SearchRepository
import com.example.githubsearch.ui.user.UserListAdapter

class MainViewModel(api: GithubApi) : ViewModel() {

    val repository = SearchRepository(api)
    val adapter = UserListAdapter()

}