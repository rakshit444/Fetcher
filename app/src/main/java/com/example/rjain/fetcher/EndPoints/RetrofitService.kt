package com.example.rjain.fetcher.EndPoints

import com.example.rjain.fetcher.Api.Bean.Population

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by rjain on 5/27/2017.
 */

interface RetrofitService {
    @get:GET("tutorial/jsonparsetutorial.txt")
    val list: Call<Population>

}
