package com.example.xepochallenge.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.xepochallenge.R
import com.example.xepochallenge.model.GithubRepoModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detailview.*
import kotlinx.android.synthetic.main.item_repo.view.*

class GithubDetailActivity : AppCompatActivity(){

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var buildByAdapter : BuildByAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailview)

        val extras = intent.extras
        var stringResponse=extras.getString("RepoDetails")
        var gson= Gson()
        var model: GithubRepoModel=gson.fromJson(stringResponse,GithubRepoModel::class.java)

        linearLayoutManager = LinearLayoutManager(this)
        rv_contributors.layoutManager = linearLayoutManager
        buildByAdapter= BuildByAdapter(model.builtBy)
        rv_contributors.adapter=buildByAdapter

        supportActionBar?.title =model.name

        layout_basicinfo.tv_name.visibility= View.GONE
        layout_basicinfo.tv_author.text=model.author
        layout_basicinfo.tv_url.text=model.url
        layout_basicinfo.tv_description.text=model.description
        layout_basicinfo.tv_forks.text=model.forks.toString()
        layout_basicinfo.tv_stars.text=model.stars.toString()
        layout_basicinfo.tv_currentperiodstars.text=model.currentPeriodStars.toString()

    }

}