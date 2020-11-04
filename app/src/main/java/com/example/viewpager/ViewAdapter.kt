package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class ViewpagerAdpter(val colors:List<Int>):RecyclerView.Adapter<ViewpagerAdpter.ViewPagerViewHolder>(){



    inner  class  ViewPagerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override  fun onCreateViewHolder(parent: ViewGroup,viewType:Int):ViewPagerViewHolder{


        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewlayout,parent,false)


        return  ViewPagerViewHolder(view)

    }

    override  fun getItemCount():Int{

        return  colors.size

    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentColors = colors[position]

        var text = holder.itemView.findViewById(R.id.red_frg) as TextView
        text.setBackgroundResource(currentColors)

    }








}