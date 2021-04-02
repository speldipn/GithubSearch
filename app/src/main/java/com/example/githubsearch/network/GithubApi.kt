package com.example.githubsearch.network

import com.example.githubsearch.model.UserResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("search/users")
    fun getUsers(
        @Query("q") q: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Single<UserResult>
}