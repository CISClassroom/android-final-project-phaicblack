package th.ac.kku.cis.mobileapp.fashionstyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class pants : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pants)
        if (supportActionBar != null)
            supportActionBar?.hide()
    }
}
