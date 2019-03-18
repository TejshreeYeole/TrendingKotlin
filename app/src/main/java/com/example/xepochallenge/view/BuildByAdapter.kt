package com.example.xepochallenge.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xepochallenge.R
import com.example.xepochallenge.model.BuiltBy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_buildby.view.*

class BuildByAdapter(private var builtByList: List<BuiltBy>) : RecyclerView.Adapter<BuildByAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_buildby, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int =builtByList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(builtByList[position].avatar).into(holder.profileImage)
        holder.tvName.text=builtByList[position].username
                holder.tvHref.text=builtByList[position].href
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage =view.profile_image
        val tvName = view.tv_name
        val tvHref=view.tv_href

    }
}