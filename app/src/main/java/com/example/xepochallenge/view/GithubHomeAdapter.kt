package com.example.xepochallenge.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xepochallenge.R
import com.example.xepochallenge.model.GithubRepoModel
import kotlinx.android.synthetic.main.item_repo.view.*

class GithubHomeAdapter(private val repoList: ArrayList<GithubRepoModel>,private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<GithubHomeAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repo, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int= repoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAuthor.text=repoList[position].author
        holder.tvName.text=repoList[position].name
        holder.tvUrl.text=repoList[position].url
        holder.tvDescription.text=repoList[position].description
        holder.tvForks.text=repoList[position].forks.toString()
        holder.tvStars.text=repoList[position].stars.toString()
        holder.tvCurrentperiodstars.text=repoList[position].currentPeriodStars.toString()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {

        val tvAuthor =view.tv_author
        val tvName = view.tv_name
        val tvUrl=view.tv_url
        val tvDescription =view.tv_description
        val tvForks = view.tv_forks
        val tvStars=view.tv_stars
        val tvCurrentperiodstars=view.tv_currentperiodstars

        init {
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            if (itemClickListener != null) {
                if (v != null) {
                    itemClickListener.onItemClick(v, adapterPosition)
                }
            }
        }
    }


}