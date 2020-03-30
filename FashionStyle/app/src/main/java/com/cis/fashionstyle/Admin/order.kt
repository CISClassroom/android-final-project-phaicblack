package com.cis.fashionstyle.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.cis.fashionstyle.Adapter.adapterorder
import com.cis.fashionstyle.Model.Modelorder
import com.cis.fashionstyle.Model.modelitem
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import th.ac.kku.cis.mobileapp.fashionstyle.MainActivity
import th.ac.kku.cis.mobileapp.fashionstyle.R

class order : AppCompatActivity() {
    lateinit var listview: ListView
    lateinit var ref: DatabaseReference
    lateinit var items:MutableList<Modelorder>
    lateinit var auth: FirebaseAuth
    lateinit var googleClient: GoogleSignInClient
    var boo:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        if (supportActionBar != null)
            supportActionBar?.hide()

        listview = findViewById(R.id.listvieworder)
        items = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("Data_item")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    items.clear()
                    for (e in p0.children){
                        val rec = e.getValue(Modelorder::class.java)
                        items.add(rec!!)
                    }
                    val adapter = adapterorder(this@order,R.layout.activity_modelorder ,items)
                    listview.adapter = adapter
                }

                val logout: Button = findViewById(R.id.logout)
                logout.setOnClickListener({ v -> singOut() })
            }
        }
        )
    }
    private fun passproject() {
        if (boo) {
            var i = Intent(this, MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }

    }
    private fun singOut() {
        auth.signOut()
        boo = true
        passproject()
    }
}
