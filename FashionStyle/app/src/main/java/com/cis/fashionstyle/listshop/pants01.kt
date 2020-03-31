package th.ac.kku.cis.mobileapp.fashionstyle.listshop

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.cis.fashionstyle.Model.Modelorder
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_pants01.*

import th.ac.kku.cis.mobileapp.fashionstyle.R
import th.ac.kku.cis.mobileapp.fashionstyle.select

class pants01 : AppCompatActivity() {
    lateinit var mDB: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pants01)
        if (supportActionBar != null)
            supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val goback: Button = findViewById(R.id.bb02)
        mDB = FirebaseDatabase.getInstance().reference

        goback.setOnClickListener {

            var i = Intent(this,  select::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }

        btpant01.setOnClickListener {
            val builder = AlertDialog.Builder(this@pants01)
            builder.setTitle("ยืนยันการสั่งซื้อ")
            builder.setMessage("คุณต้องการสั่งซื้อหรือไม่ ?")

            builder.setNegativeButton("ยกเลิก") { dialog, which ->
                dialog.dismiss()
            }
            builder.setPositiveButton("ยืนยัน") { dialog, which ->
                var newData: Modelorder = Modelorder.create()
                val obj = mDB.child("Data_item").push()
                newData.nameorder = textnameorder.text.toString()
                newData.namecount = tbcount.text.toString()
                newData.nameaddress = tbaddress.text.toString()
                newData.id = obj.key
                obj.setValue(newData)
                Toast.makeText(applicationContext, "สั่งซื้อเรียบร้อยแล้ว", Toast.LENGTH_SHORT)
                    .show()


                var i = Intent(this, select::class.java)
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)

            }



            val dialog: AlertDialog = builder.create()
            dialog.show()



        }
    }
}
