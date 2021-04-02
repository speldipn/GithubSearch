package com.example.githubsearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.githubsearch.model.User
import com.example.githubsearch.network.GithubApi
import com.example.githubsearch.network.SearchRepository
import com.example.githubsearch.ui.user.UserListAdapter

class MainViewModel(api: GithubApi) : ViewModel() {

    val repository = SearchRepository(api)
    val userListAdapter = UserListAdapter()

    var userList: LiveData<PagedList<User>> = repository.userDataSource("aa")
}