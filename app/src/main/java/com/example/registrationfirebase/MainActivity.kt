package com.example.registrationfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var emaili : EditText
    private lateinit var paroli : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btn (view:View) {
        emaili = findViewById(R.id.EmailAddress)
        paroli = findViewById(R.id.Password)
        val emaili1 = emaili.text.toString()
        val paroli1 = paroli.text.toString()
        if (emaili1.isEmpty() || paroli1.isEmpty()) {
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(emaili1, paroli1)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "You are registered successfully!", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                    } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }


                }
        }
    }

}




