package com.example.registrationfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var emaili : EditText
    private lateinit var paroli : EditText
    private lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emaili = findViewById(R.id.EmailAddress)
        paroli = findViewById(R.id.Password)
        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            val emaili1 = emaili.text.toString()
            val paroli1 = paroli.text.toString()
            if (emaili1.isEmpty() || paroli1.isEmpty() || paroli1.length <= 6) {
                Toast.makeText(this, "შეამოწმეთ Email ან პაროლი" , Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(emaili1,paroli1)
                .addOnCompleteListener{ task->
                    if (task.isSuccessful){
                        Toast.makeText(this, "წარმატებით დარეგისტრირდით",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this,"არასწორია!",Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }



}




