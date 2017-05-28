package com.example.rjain.fetcher.Api

import android.util.Log

import com.example.rjain.fetcher.EndPoints.RetrofitService
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rjain on 5/27/2017.
 */

class RetrofitClient {
    val retrofitService: RetrofitService

    init {

        val gson = GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.androidbegin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        Log.i(TAG, "setting retrofit service")
        retrofitService = retrofit.create(RetrofitService::class.java)
        Log.i(TAG, "Done")
    }

    companion object {

        private val TAG = "Relationship Service"
    }

}
