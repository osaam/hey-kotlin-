package com.osamaelsh3rawy.haykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.osamaelsh3rawy.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel:ListViewModel
    private lateinit var adapter:ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUi()
        setViewModel()
        setObserver()
    }

    private fun setObserver() {
        viewmodel.getposts.observe(this, Observer
        {data ->
            progressBar.visibility = View.VISIBLE
            adapter.addData(data)
            adapter.notifyDataSetChanged()
            progressBar.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        })


    }

    private fun setViewModel() {
        viewmodel = ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    private fun setUi() {
        adapter = ListAdapter(arrayListOf())
        recycler.adapter=adapter
    }

}