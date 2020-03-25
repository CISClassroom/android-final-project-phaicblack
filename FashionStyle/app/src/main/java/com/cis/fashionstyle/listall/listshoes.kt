package com.cis.fashionstyle.listall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.cis.fashionstyle.Adapter.adapterhat
import com.cis.fashionstyle.Adapter.adaptershoes
import com.cis.fashionstyle.Model.modelitem
import th.ac.kku.cis.mobileapp.fashionstyle.R
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.pants01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.pants02
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.shoes01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.shoes02

class listshoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listshoes)
        if (supportActionBar != null)
            supportActionBar?.hide()
        var item = mutableListOf<modelitem>()

        item.add(modelitem("รองเท้า Nike","ราคา 2,200",R.drawable.shoes01))
        item.add(modelitem("รองเท้าแตะ","ราคา 120",R.drawable.shoes02))


        var listview: ListView = findViewById(R.id.customlistviewshoes)

        listview.adapter = adaptershoes(this,
            R.layout.activity_shoes,item)

        listview.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
            if(position==0){
                var i = Intent(this, shoes01::class.java)
                startActivity(i)
            }
            else if(position==1){
                var i = Intent(this, shoes02::class.java)
                startActivity(i)
            }


        }
    }
}
