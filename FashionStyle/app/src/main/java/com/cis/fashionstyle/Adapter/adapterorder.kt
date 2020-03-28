package com.cis.fashionstyle.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.cis.fashionstyle.Model.Modelorder
import th.ac.kku.cis.mobileapp.fashionstyle.R

public class adapterorder (val mCtx: Context,
                           var resource:Int,
                           var items:List<Modelorder>)
        : ArrayAdapter<Modelorder>(mCtx,resource,items){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            //return super.getView(position, convertView, parent)
            val layout: LayoutInflater = LayoutInflater.from(mCtx)

            val v: View = layout.inflate(resource,null)
         // val imageViews : ImageView = v.findViewById(R.id.imageView3)
            val textViewpro : TextView = v.findViewById(R.id.tvproduct)
            val textViewaddrress : TextView = v.findViewById(R.id.tvaddress)
            val textViewcount : TextView = v.findViewById(R.id.tvcount)


            val receipt: Modelorder = items[position]


            textViewpro.text = receipt.nameorder
            textViewaddrress.text = receipt.nameaddress
            textViewcount.text = receipt.namecount

            return v
        }
    }