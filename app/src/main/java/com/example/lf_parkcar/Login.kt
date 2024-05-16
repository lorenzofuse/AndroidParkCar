// Login.kt
package com.example.lf_parkcar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lf_parkcar.databinding.ActivitySignInBinding
import com.example.lf_parkcar.databinding.ActivitySignInBinding.inflate
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.btn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val psw = binding.passET.text.toString()

            if (email.isNotEmpty() && psw.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, psw).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Chiude l'attività di login dopo il successo
                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Inserisci email e password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
