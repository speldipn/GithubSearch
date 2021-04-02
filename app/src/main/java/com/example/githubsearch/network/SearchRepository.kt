package com.example.githubsearch.network

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.githubsearch.model.User

class SearchRepository(val api: GithubApi) {
    val config = PagedList.Config.Builder()
        .setInitialLoadSizeHint(20)
        .setPrefetchDistance(10)
        .setPageSize(20)
        .build()

    fun userDataSource(query: String): LiveData<PagedList<User>> {
        return LivePagedListBuilder(object : DataSource.Factory<String, User>() {
            override fun create(): DataSource<String, User> {
                return UserDataSource(api, query)
            }
        }, config).build()
    }
}