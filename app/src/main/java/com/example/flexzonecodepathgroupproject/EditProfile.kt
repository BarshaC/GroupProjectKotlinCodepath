package com.example.flexzonecodepathgroupproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.parse.ParseUser

private const val TAG = "EditProfile"
class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val thisUser = ParseUser.getCurrentUser()
        val newUsername: TextView = findViewById(R.id.changeUsername)
        val newAge: TextView = findViewById(R.id.changeAge)
        val newEmail: TextView = findViewById(R.id.changeEmail)
        val confirmChange: Button = findViewById(R.id.confirmEditButton)
        val backButton: Button = findViewById(R.id.editBackButton)

        confirmChange.setOnClickListener{
            val thisNewUsername = newUsername.text.toString()
            val thisNewAge = newAge.text.toString()
            val thisNewEmail = newEmail.text.toString()
            if (thisNewUsername.isNotEmpty()) {
                thisUser.put("username", "$thisNewUsername")
            }
            if (thisNewAge.isNotEmpty()) {
                thisUser.put("Age", "$thisNewAge")
            }
            if (thisNewEmail.isNotEmpty()){
                thisUser.put("email", "$thisNewEmail")
            }

            thisUser.saveInBackground{e->
            if(e==null){
                Toast.makeText(this, "Save Successful", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();
                }
            }

            val i = Intent(this, ProfileActivity::class.java)
            this.startActivity(i)
            finish()
    }
        backButton.setOnClickListener{
            val i = Intent(this, ProfileActivity::class.java)
            this.startActivity(i)
            finish()
        }
}
}