package com.cis.fashionstyle.listall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import android.widget.Toast
import com.cis.fashionstyle.Adapter.adapteritem
import com.cis.fashionstyle.Model.modelitem
import th.ac.kku.cis.mobileapp.fashionstyle.R
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.shirt01
import th.ac.kku.cis.mobileapp.fashionstyle.listshop.shirt02

class listshirt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listshirt)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        var item = mutableListOf<modelitem>()

        item.add(modelitem("เสื้อแขนยาวลายการ์ตูน ","ราคา 270",R.drawable.shirt01))
        item.add(modelitem("เสื้อยืดแขนสั้น","ราคา 250",R.drawable.shirt02))


        var listview: ListView = findViewById(R.id.customlistviewshirt)

        listview.adapter = adapteritem(this,
            R.layout.activity_shirt,item)

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
            if(position==0){
                var i = Intent(this,shirt01::class.java)
                startActivity(i)
            }
            else if(position==1){
                var i = Intent(this,shirt02::class.java)
                startActivity(i)
            }


        }
    }
}
