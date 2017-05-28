package com.example.rjain.fetcher.Api.Bean

/**
 * Created by rjain on 5/27/2017.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Population {

    @SerializedName("worldpopulation")
    @Expose
    var worldpopulation: List<Worldpopulation>? = null

}