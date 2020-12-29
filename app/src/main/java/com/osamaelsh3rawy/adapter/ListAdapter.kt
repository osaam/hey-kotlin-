package com.osamaelsh3rawy.adapter

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osamaelsh3rawy.data.PostsData
import com.osamaelsh3rawy.haykotlin.R
import kotlinx.android.synthetic.main.item.view.*

class ListAdapter(private val posts: ArrayList<PostsData>) :
    RecyclerView.Adapter<ListAdapter.VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            VH = VH(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))



    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val posts :PostsData=posts.get(position)
        holder.itemView.body.text=posts.body
        holder.itemView.title.text=posts.title
    }

    fun addData(list: List<PostsData>) {
        posts.addAll(list)
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}