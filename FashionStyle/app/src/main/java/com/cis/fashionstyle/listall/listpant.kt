package com.cis.fashionstyle.listall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import com.cis.fashionstyle.Adapter.adapterhat
import com.cis.fashionstyle.Adapter.adapterpant
import com.cis.fashionstyle.Model.modelitem
import th.ac.kku.cis.mobileapp.fashionstyle.R
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.hat01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.hat02
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.pants01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.pants02

class listpant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listpant)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        var item = mutableListOf<modelitem>()

        item.add(modelitem("กางเกงขาสั้น","ราคา 250",R.drawable.pant01))
        item.add(modelitem("กางเกงขายาว","ราคา 320",R.drawable.pant02))


        var listview: ListView = findViewById(R.id.customlistviewpant)

        listview.adapter = adapterpant(this,
            R.layout.activity_pants,item)

        listview.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
            if(position==0){
                var i = Intent(this, pants01::class.java)
                startActivity(i)
            }
            else if(position==1){
                var i = Intent(this, pants02::class.java)
                startActivity(i)
            }


        }
    }
}
