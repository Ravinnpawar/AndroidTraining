package com.mobileappguru.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobileappguru.androidtraining.adapters.ItemAdapter
import com.mobileappguru.data.Entry

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    private val data:Array<String> by lazy {
        resources.getStringArray(R.array.names)
    }
    private val jsonData:Array<Entry> by lazy{
        arrayOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView=findViewById(R.id.recyclerview)
        adapter= ItemAdapter(jsonData)

        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}