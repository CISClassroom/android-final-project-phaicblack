package th.ac.kku.cis.mobileapp.fashionstyle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.cis.fashionstyle.listall.listhat
import com.cis.fashionstyle.listall.listpant
import com.cis.fashionstyle.listall.listshirt
import com.cis.fashionstyle.listall.listshoes
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.squareup.picasso.Picasso


class select : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
   // lateinit var googleClient: GoogleSignInClient
    var boo:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        if (supportActionBar != null)
            supportActionBar?.hide()
        val goshirt: ImageButton = findViewById(R.id.Buttonsshirt)
        val gopant: ImageButton = findViewById(R.id.Buttonspant)
        val goshoes: ImageButton = findViewById(R.id.Buttonsshoes)
        val gohat: ImageButton = findViewById(R.id.Buttonshat)
        val NameSetting: TextView = findViewById(R.id.name)
        val Profile: ImageView = findViewById(R.id.Profile)
        val Email: TextView = findViewById(R.id.email)
        auth = FirebaseAuth.getInstance()
        auth.currentUser!!.email
        val xx: Uri? = auth.currentUser!!.photoUrl
        NameSetting.text = auth.currentUser!!.displayName.toString()
        Picasso.get().load(xx).into(Profile)
        Email.text = auth.currentUser!!.email


        val btlogout: Button = findViewById(R.id.logout)
        btlogout.setOnClickListener({ v -> singOut() })


        goshirt.setOnClickListener {
            var i = Intent(this, listshirt::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
        gopant.setOnClickListener {

            var i = Intent(this, listpant::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
        goshoes.setOnClickListener {

            var i = Intent(this, listshoes::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
        gohat.setOnClickListener {

            var i = Intent(this, listhat::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
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

        private fun updateUI(user: FirebaseUser?) {
            if (user == null) {
                //show.text = "No User"
            } else {
                //show.text = user.email.toString()
                passproject()
            }

        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == 101) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuth(account!!)
                    //FirebaseAuth(account)
                } catch (e: ApiException) {
                    Log.i("Error OOP", e.toString())
                    boo = false
                    updateUI(null)
                }
            }
        }

        private fun firebaseAuth(account: GoogleSignInAccount) {
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        boo = true
                        updateUI(user)
                    } else {
                        boo = false
                        updateUI(null)
                    }
                }
        }
    }




