package com.mtehan.kotlinretrofit2rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mtehan.kotlinretrofit2rxjava.Adapter.PostAdapter
import com.mtehan.kotlinretrofit2rxjava.Model.Post
import com.mtehan.kotlinretrofit2rxjava.Retrofit.MyAPI
import com.mtehan.kotlinretrofit2rxjava.Retrofit.RetrofitClient
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import java.util.concurrent.ScheduledFuture

class MainActivity : AppCompatActivity() {
    internal lateinit var jsonApi: MyAPI
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init api
        val retrofit = RetrofitClient.instance
        jsonApi = retrofit.create(MyAPI::class.java)

        //view
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { posts -> displayData(posts) })
    }

    private fun displayData(posts: List<Post>?) {
        val adapter = PostAdapter(this, posts!!)
        recyclerView.adapter = adapter
    }
}
