package tz.co.hosannahighertech.blogapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.post_item.view.*
import tz.co.hosannahighertech.blogapp.R
import tz.co.hosannahighertech.blogapp.models.Post

/**
 * @package tz.co.hosannahighertech.blogapp.ui.adapters
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 10/10/2018 17:48.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
class PostsAdapter() : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    var posts: List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = posts.get(position)

        holder.view.heading.text = model.title
        holder.view.body.text = model.body
    }

    fun pushPosts(posts:List<Post>)
    {
        this.posts = posts
        notifyDataSetChanged()
    }


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)
}