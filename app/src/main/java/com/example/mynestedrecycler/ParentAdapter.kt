package com.example.mynestedrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.enums.RecyclerType
import com.example.mynestedrecycler.databinding.ItemParentPostsBinding
import com.example.mynestedrecycler.databinding.ItemParentStoriesBinding


class ParentAdapter(val list: List<ParentItem>) : Adapter<ParentAdapter.BaseViewHolder>() {

    abstract class BaseViewHolder(viewBinding: View) : ViewHolder(viewBinding)
    class ParentStoriesViewHolder(var viewBinding: ItemParentStoriesBinding) :
        BaseViewHolder(viewBinding.root)

    class ParentPostsViewHolder(var viewBinding: ItemParentPostsBinding) :
        BaseViewHolder(viewBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            STORIES_TYPE -> {
                val viewBinding = ItemParentStoriesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ParentStoriesViewHolder(viewBinding)
            }
            POSTS_TYPE -> {
                val viewBinding = ItemParentPostsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ParentPostsViewHolder(viewBinding)
            }
            else -> throw Exception("no valid view holer class")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            RecyclerType.STORY -> STORIES_TYPE
            RecyclerType.POST -> POSTS_TYPE
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ParentStoriesViewHolder -> bindStories(holder, position)
            is ParentPostsViewHolder -> bindPosts(holder, position)

        }
    }

    private fun bindPosts(holder: ParentPostsViewHolder, position: Int) {
        val postsList = list[position].list
        val adapter = PostAdapter(postsList)
        holder.viewBinding.recycleStories.adapter = adapter
    }

    private fun bindStories(holder: ParentStoriesViewHolder, position: Int) {
        val storiesList = list[position].list
        val adapter = StoriesAdapter(storiesList)
        holder.viewBinding.recycleStories.adapter = adapter
    }


    override fun getItemCount(): Int = list.size

    companion object {
        val STORIES_TYPE = 1
        val POSTS_TYPE = 2

    }

}