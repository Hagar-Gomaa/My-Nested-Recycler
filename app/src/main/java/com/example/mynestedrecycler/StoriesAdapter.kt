package com.example.mynestedrecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mynestedrecycler.databinding.ItemStoryBinding

class StoriesAdapter(var storiesList: List<String>) : Adapter<StoriesAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemStoryBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemStoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStory =storiesList[position]
        holder.viewBinding.name.text=currentStory
    }
    override fun getItemCount(): Int = storiesList.size


}