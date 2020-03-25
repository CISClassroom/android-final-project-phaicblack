package com.cis.fashionstyle.listall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.cis.fashionstyle.Adapter.adapterhat
import com.cis.fashionstyle.Adapter.adapteritem
import com.cis.fashionstyle.Model.modelitem
import th.ac.kku.cis.mobileapp.fashionstyle.R
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.hat01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.hat02
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.shirt01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.shirt02

class listhat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listhat)
        if (supportActionBar != null)
            supportActionBar?.hide()
        var item = mutableListOf<modelitem>()

        item.add(modelitem("หมวก Cap","ราคา 450",R.drawable.hat02))
        item.add(modelitem("หมวกปีก รอบ","ราคา 199",R.drawable.hat01))


        var listview: ListView = findViewById(R.id.customlistviewhat)

        listview.adapter = adapterhat(this,
            R.layout.activity_hat,item)

        listview.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
            if(position==0){
                var i = Intent(this, hat01::class.java)
                startActivity(i)
            }
            else if(position==1){
                var i = Intent(this, hat02::class.java)
                startActivity(i)
            }


        }
    }
}
