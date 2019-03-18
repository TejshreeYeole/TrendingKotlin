package com.knowhassels.Utils.Retrofit

import com.example.xepochallenge.model.GithubRepoModel
import kotlinx.coroutines.Deferred
import org.json.JSONArray
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("repositories")
    fun getGithubRepo(@Query("language")  value : String ) : Deferred<ArrayList<GithubRepoModel>>
}
