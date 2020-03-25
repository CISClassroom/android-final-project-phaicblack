package com.cis.fashionstyle.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.cis.fashionstyle.Model.modelitem
import th.ac.kku.cis.mobileapp.fashionstyle.R

public class adaptershoes (val mCtx: Context,
                    var resource:Int,
                    var items:List<modelitem>) : ArrayAdapter<modelitem>(mCtx,resource,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val layout: LayoutInflater = LayoutInflater.from(mCtx)

        val v: View = layout.inflate(resource,null)
        val icon : ImageView = v.findViewById(R.id.imageViewshoes)
        val name : TextView = v.findViewById(R.id.textViewsshoes1)
        val id: TextView = v.findViewById(R.id.textViewshoes2)

        val modelitem1:modelitem = items[position]

        name.text = modelitem1.name
        id.text = modelitem1.id
        try {
            icon.setImageDrawable(mCtx.getDrawable(modelitem1.icon))
        }
        catch (ex:Exception){

        }

        return v
    }
}
