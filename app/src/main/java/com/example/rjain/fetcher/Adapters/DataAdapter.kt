package com.example.rjain.fetcher.Adapters

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import com.example.rjain.fetcher.Activites.MainActivity
import com.example.rjain.fetcher.Api.Bean.DataModel
import com.example.rjain.fetcher.R
import com.squareup.picasso.Picasso

import java.util.ArrayList

/**
 * Created by rjain on 5/28/2017.
 */

class DataAdapter(private val mDataModelArrayList: ArrayList<DataModel>, private val mcontext: Context) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    internal var isImageFitToScreen: Boolean = false
    private var view: View? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        view = LayoutInflater.from(viewGroup.context).inflate(R.layout.population_card, viewGroup, false)
        return ViewHolder((view as View?)!!)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.population.text = mDataModelArrayList[i].population
        viewHolder.country.text = mDataModelArrayList[i].country
        viewHolder.rank.text = mDataModelArrayList[i].rank!!.toString()
        Picasso.with(mcontext).load(mDataModelArrayList[i].flag).into(viewHolder.flag)
        viewHolder.flag.setOnClickListener {
            val dialog = Dialog(mcontext)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

            val imageView = ImageView(mcontext)
            imageView.setImageDrawable(viewHolder.flag.drawable)
            dialog.addContentView(imageView, RelativeLayout.LayoutParams(700, 600))
            dialog.show()
        }
        //viewHolder.tv_api_level.setText(android.get(i).getTruncated());
    }

    override fun getItemCount(): Int {
        return mDataModelArrayList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val population: TextView
        val country: TextView
        val rank: TextView
        val flag: ImageView


        init {

            population = view.findViewById(R.id.edit_population) as TextView
            country = view.findViewById(R.id.edit_country) as TextView
            rank = view.findViewById(R.id.edit_rank) as TextView
            flag = view.findViewById(R.id.flag) as ImageView

        }
    }
}