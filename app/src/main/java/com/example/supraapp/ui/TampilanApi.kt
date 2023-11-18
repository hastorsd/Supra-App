package com.example.supraapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.supraapp.dataapi.MainAdapter
import com.example.supraapp.dataapi.remote.ApiService
import com.example.supraapp.dataapi.remote.UsersItem
import com.example.supraapp.databinding.ActivityTampilanApiBinding
import com.example.supraapp.util.constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TampilanApi : AppCompatActivity() {

    private lateinit var binding: ActivityTampilanApiBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilanApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        getUsersData()
    }

    private fun getUsersData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object : retrofit2.Callback<List<UsersItem>> {
            override fun onResponse(
                call: retrofit2.Call<List<UsersItem>>,
                response: retrofit2.Response<List<UsersItem>>
            ){
                if (response.isSuccessful){
                    val data = response.body()!!
                    viewAdapter = MainAdapter(baseContext, data)
                    binding.itemRv.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<UsersItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}