package th.ac.kku.cis.mobileapp.fashionstyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class hat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hat)
        if (supportActionBar != null)
            supportActionBar?.hide()
    }
}
