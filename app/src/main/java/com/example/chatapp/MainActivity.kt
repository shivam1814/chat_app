package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<mainChats>
    lateinit var adapter: MainChatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        list = ArrayList()

        setupList()

        adapter = MainChatsAdapter(list, this)

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.adapter = adapter
        binding.mainRecyclerView.setHasFixedSize(true)
        adapter.notifyDataSetChanged()

    }

    private fun setupList() {
        list.add(mainChats("Robert David", R.drawable.sample, 20, false))
        list.add(mainChats("Rakesh Shah", R.drawable.sample, 12, true))
        list.add(mainChats("Patel Kiran", R.drawable.sample, 0, true))
        list.add(mainChats("Kamal Shah", R.drawable.sample, 35, true))
        list.add(mainChats("Patel Kiran", R.drawable.sample, 0, false))
        list.add(mainChats("Patel Kiran", R.drawable.sample, 0, true))
        list.add(mainChats("Kamal Shah", R.drawable.sample, 35, true))
        list.add(mainChats("Patel Kiran", R.drawable.sample, 0, false))
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}