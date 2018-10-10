package tz.co.hosannahighertech.blogapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import tz.co.hosannahighertech.blogapp.R
import tz.co.hosannahighertech.blogapp.models.Post
import tz.co.hosannahighertech.blogapp.ui.adapters.PostsAdapter
import tz.co.hosannahighertech.blogapp.ui.viewmodels.PostViewModel

class MainActivity : AppCompatActivity() {

    private val adapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heading.text = getString(R.string.title_blog_posts)

        postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        postList.itemAnimator = DefaultItemAnimator()
        postList.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        viewModel.getPostLiveData().observe(this, Observer<List<Post>> {
            if(it != null)
                adapter.pushPosts(it)
        })

        viewModel.getNetStatus().observe(this, Observer<Boolean>{
            if(it!=null)
            {
                showProgress(it)
            }
            showProgress(false)
        })

        viewModel.loadPosts()
    }

    private fun showProgress(show: Boolean) {
        if(show)
        {
            containerMain.visibility = View.GONE
            containerProgress.visibility = View.VISIBLE
        }
        else
        {
            containerMain.visibility = View.VISIBLE
            containerProgress.visibility = View.GONE
        }
    }
}
