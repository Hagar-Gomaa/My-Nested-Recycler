package com.example.mynestedrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mynestedrecycler.databinding.ItemPostBinding
import com.example.mynestedrecycler.databinding.ItemStoryBinding

class PostAdapter(var postsList: List<String>) : Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemPostBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStory =postsList[position]
        holder.viewBinding.name.text=currentStory.toString()
    }
    override fun getItemCount(): Int = postsList.size


}