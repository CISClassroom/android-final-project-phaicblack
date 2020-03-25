package th.ac.kku.cis.mobileapp.fashionstyle.listshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import th.ac.kku.cis.mobileapp.fashionstyle.R
import th.ac.kku.cis.mobileapp.fashionstyle.select

class shirt02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shirt02)
        if (supportActionBar != null)
            supportActionBar?.hide()
        val goback: Button = findViewById(R.id.bb02)

        goback.setOnClickListener {

            var i = Intent(this,  select::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
    }
}
