package com.example.rjain.fetcher.Activites

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import com.example.rjain.fetcher.Adapters.DataAdapter
import com.example.rjain.fetcher.Api.Bean.DataModel
import com.example.rjain.fetcher.Api.Bean.Population
import com.example.rjain.fetcher.Api.Bean.Worldpopulation
import com.example.rjain.fetcher.Api.RetrofitClient
import com.example.rjain.fetcher.EndPoints.RetrofitService
import com.example.rjain.fetcher.R
import com.google.gson.Gson

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mRetrofitClient: RetrofitClient? = null
    private var mRecyclerView: RecyclerView? = null
    private val mContext: Context? = null
    private var mDataModels: ArrayList<DataModel>? = null
    private var mDataAdapter: DataAdapter? = null
    private var mRetrofitService: RetrofitService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDataModels = ArrayList<DataModel>()
        mRecyclerView = findViewById(R.id.my_recycler_view) as RecyclerView
        val layoutManager = LinearLayoutManager(applicationContext)
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.layoutManager = layoutManager

        Log.i(TAG, "recycleview layout is set")

    }

    override fun onStart() {
        super.onStart()
        mRetrofitClient = RetrofitClient()
        mRetrofitService = mRetrofitClient!!.retrofitService
        val call1 = mRetrofitService!!.list
        call1.enqueue(object : Callback<Population> {
            override fun onResponse(call: Call<Population>, response: Response<Population>) {
                val statusCode = response.code()
                val population = response.body()
                val modelList = population!!.worldpopulation

                if (modelList != null) {
                    for (i in modelList.indices) {
                        mDataModels!!.add(DataModel(modelList!![i].country, modelList[i].population,
                                modelList!![i].rank, modelList[i].flag))
                    }
                }

                mDataAdapter = DataAdapter(mDataModels!!, this@MainActivity)
                mRecyclerView!!.adapter = mDataAdapter
                Log.w("Full json", Gson().toJson(response))

            }

            override fun onFailure(call: Call<Population>, t: Throwable) {
                Log.i(TAG, t.message)
            }
        })
    }

    companion object {

        private val TAG = "Main Activity"
    }
}
