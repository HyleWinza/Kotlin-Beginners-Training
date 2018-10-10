package tz.co.hosannahighertech.blogapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import tz.co.hosannahighertech.blogapp.R
import tz.co.hosannahighertech.blogapp.models.Post
import tz.co.hosannahighertech.blogapp.ui.adapters.PostsAdapter
import tz.co.hosannahighertech.blogapp.ui.viewmodels.PostViewModel

class MainActivity : AppCompatActivity() {

    val adapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        postList.itemAnimator = DefaultItemAnimator()
        postList.adapter = adapter

        ViewModelProviders.of(this)
                .get(PostViewModel::class.java)
                .getPostLiveData()
                .observe(this, Observer<List<Post>> {
                    
                })
    }
}
