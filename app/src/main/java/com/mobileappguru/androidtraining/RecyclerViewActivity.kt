package com.mobileappguru.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobileappguru.androidtraining.adapters.ItemAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    private val data:Array<String> by lazy {
        resources.getStringArray(R.array.names)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView=findViewById(R.id.recyclerview)
        adapter= ItemAdapter(data)

        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}