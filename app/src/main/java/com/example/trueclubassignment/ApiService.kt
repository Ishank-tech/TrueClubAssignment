package com.example.trueclubassignment

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.nationalize.io"

interface ApiServiceInterface {

        @GET("/?")
        fun getData(@Query("name") name : String) : Call<model>

}

object ApiService{
    val apiInstance : ApiServiceInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInstance = retrofit.create(ApiServiceInterface::class.java)
    }
}