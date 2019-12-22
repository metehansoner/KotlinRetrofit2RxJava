package com.mtehan.kotlinretrofit2rxjava.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtehan.kotlinretrofit2rxjava.Model.Post
import com.mtehan.kotlinretrofit2rxjava.R
import kotlinx.android.synthetic.main.custom_posts_list.view.*
import java.lang.StringBuilder

class PostAdapter(internal var context: Context, internal var postList: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_posts_list, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txt_author.text = postList[position].userId.toString()
        holder.txt_title.text = postList[position].title
        holder.txt_content.text =
            StringBuilder(postList[position].body.substring(0, 20)).append("....").toString()
    }
}
