package com.assignment.arpit.ecommerce

import android.content.ClipData
import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*

class itemAdaptor(var c:Context,var list:ArrayList<items>): RecyclerView.Adapter<RecyclerView.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v=LayoutInflater.from(c).inflate(R.layout.item,parent,false)
        return ItemHolder(v)


      //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
   //To change body of created functions use File | Settings | File Templates.
   return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(list[position].name,list[position].price)

    }

    class ItemHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(n:String,p:Int)
        {
            itemView.textitem.text=n
            itemView.textprice.text=p.toString()
        }
    }
}