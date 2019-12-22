package com.mtehan.kotlinretrofit2rxjava.Retrofit

import com.mtehan.kotlinretrofit2rxjava.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET


interface MyAPI {
    @get:GET("posts")
    val posts: Observable<List<Post>>
}