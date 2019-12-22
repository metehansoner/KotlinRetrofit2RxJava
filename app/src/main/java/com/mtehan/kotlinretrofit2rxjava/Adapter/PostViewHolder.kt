package com.mtehan.kotlinretrofit2rxjava.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_posts_list.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txt_title = itemView.txt_title
    val txt_author = itemView.txt_author
    val txt_content = itemView.txt_content
}