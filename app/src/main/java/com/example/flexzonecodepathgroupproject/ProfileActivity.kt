package com.example.flexzonecodepathgroupproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.parse.ParseUser
import com.example.flexzonecodepathgroupproject.EditProfile

private const val TAG = "ProfileActivity"
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val thisUser = ParseUser.getCurrentUser()
        val username: TextView = findViewById(R.id.profileUsername)
        val age: TextView = findViewById(R.id.profileAge)
        val email: TextView = findViewById(R.id.profileEmail)
        val changeButton: Button = findViewById(R.id.editProfileButton)
        val backButton: Button = findViewById(R.id.backButton)
        val thisUserAge = thisUser.get("Age")

        username.text = "Name: ${thisUser.username}"
        email.text = "Email: ${thisUser.email}"
        age.text = "Age: ${thisUserAge}"

        changeButton.setOnClickListener{
            val i = Intent(this, EditProfile::class.java)
            this.startActivity(i)
            finish()
        }

        backButton.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            this.startActivity(i)
            finish()
        }

    }
}