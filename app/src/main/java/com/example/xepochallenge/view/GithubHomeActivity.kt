package com.example.xepochallenge.view

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.xepochallenge.R
import com.example.xepochallenge.model.GithubRepoModel
import com.google.gson.Gson
import com.knowhassels.Utils.Retrofit.ApiHandler
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class GithubHomeActivity : AppCompatActivity(), GithubHomeAdapter.ItemClickListener {


    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var githubRepoListAdapter : GithubHomeAdapter
    private  var repoList : ArrayList<GithubRepoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title ="Repositories"

        linearLayoutManager = LinearLayoutManager(this)
        rv_githubrepo.layoutManager = linearLayoutManager
        githubRepoListAdapter= GithubHomeAdapter(repoList,this)
        rv_githubrepo.adapter=githubRepoListAdapter

        callLoginApi()
    }

    override fun onItemClick(view: View, position: Int) {
        var intent =Intent(this,GithubDetailActivity::class.java)
        var gson =Gson()
        val repo = gson.toJson(repoList[position])
        intent.putExtra("RepoDetails", repo)
        startActivity(intent)
    }

    private fun callLoginApi() {

        var gson= Gson()
        var dialog = ProgressDialog(this@GithubHomeActivity)
        dialog.setMessage("Please Wait...")
        dialog.show()

        val service = ApiHandler.getApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.getGithubRepo("kotlin")
            try {
                val response: ArrayList<GithubRepoModel> = request.await()
                dialog.dismiss()
                if(response !=null) {
                    repoList.addAll(response)
                    githubRepoListAdapter.notifyDataSetChanged()
                }else{
                }
            } catch (e: HttpException) {
                Log.d("droidTest","e 1 :: "+e.message())
            } catch (e: Throwable) {
                Log.d("droidTest","e 2 :: "+e.message)
            }
        }
    }
}
