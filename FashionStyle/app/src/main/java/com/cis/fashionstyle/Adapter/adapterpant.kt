package com.cis.fashionstyle.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cis.fashionstyle.Model.modelitem
import th.ac.kku.cis.mobileapp.fashionstyle.R

public class adapterpant (val mCtx: Context,
                          var resource:Int,
                          var items:List<modelitem>): ArrayAdapter<modelitem>(mCtx,resource,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val layout: LayoutInflater = LayoutInflater.from(mCtx)

        val v: View = layout.inflate(resource,null)
        val icon : ImageView = v.findViewById(R.id.imageViewpant)
        val name : TextView = v.findViewById(R.id.textViewpant1)
        val id: TextView = v.findViewById(R.id.textViewpant2)

        val studen:modelitem = items[position]

        name.text = studen.name
        id.text = studen.id
        try {
            icon.setImageDrawable(mCtx.getDrawable(studen.icon))
        }
        catch (ex:Exception){

        }


        return v
    }
}
