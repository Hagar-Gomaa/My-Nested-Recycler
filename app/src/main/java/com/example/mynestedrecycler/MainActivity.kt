package com.example.mynestedrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.enums.RecyclerType
import com.example.mynestedrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        val parentList = listOf(
            ParentItem(listOf("Islam", "Mohamed", "Omar", "Ahmed","Islam", "Mohamed", "Omar", "Ahmed"), RecyclerType.STORY),
            ParentItem(listOf("post_1", "post_2", "post_3", "post_4","post_1", "post_2", "post_3", "post_4"), RecyclerType.POST),
            ParentItem(listOf("Islam", "Mohamed", "Omar", "Ahmed","Islam", "Mohamed", "Omar", "Ahmed"), RecyclerType.STORY)
        )
        val adapter = ParentAdapter(parentList)
        viewBinding.parentRecycler.adapter = adapter
    }
}