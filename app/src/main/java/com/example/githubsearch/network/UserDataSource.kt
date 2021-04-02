package com.example.githubsearch.network

import androidx.paging.PageKeyedDataSource
import com.example.githubsearch.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserDataSource(private val api: GithubApi, private val query: String) :
    PageKeyedDataSource<String, User>() {
    private val compositeDisposable = CompositeDisposable()

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, User>
    ) {
        compositeDisposable.add(
            api.getUsers(query, 1, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.items, null, null)
                }, {
                })
        )
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, User>) {
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, User>) {
    }
}