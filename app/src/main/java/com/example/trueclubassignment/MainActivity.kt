package com.example.trueclubassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter : ResultAdapter
    lateinit var listItems : RecyclerView
    private var list = mutableListOf<Country>()
    lateinit var name : TextInputEditText
    lateinit var submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listItems = findViewById(R.id.recyclerView)
        name = findViewById(R.id.name)
        submit = findViewById(R.id.submit)

//        val layoutManager = LinearLayoutManager(this)
        adapter = ResultAdapter(this@MainActivity, list)
        listItems.adapter = adapter
        val layoutManager = LinearLayoutManager(this@MainActivity)
        listItems.layoutManager = layoutManager

        submit.setOnClickListener{
            getResult()
        }

    }

    private fun getResult() {
        Log.d("ISHANK", "Request sent for ${name.text}")
        val res: Call<model> = ApiService.apiInstance.getData(name.text.toString())
        res.enqueue(object : Callback<model> {
            override fun onResponse(call: Call<model>, response: Response<model>) {
                val res = response.body()
                if (res != null) {
                    list.addAll(res.country)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<model>, t: Throwable) {
                Log.d("ISHANK", "Error in Fetching News", t)
            }
        })
    }
}