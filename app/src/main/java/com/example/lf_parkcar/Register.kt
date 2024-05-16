package com.example.lf_parkcar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lf_parkcar.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()

        binding.textView.setOnClickListener{
            val intent = Intent(this, Login::class.java)
        }

        binding.btn.setOnClickListener{
            val email=binding.emailEt.text.toString()
            val psw=binding.passET.text.toString()
            val psw2=binding.passET2.text.toString()

            if(email.isNotEmpty()&& psw.isNotEmpty() && psw2.isNotEmpty()){
                if(psw==psw2){
                    firebaseAuth.createUserWithEmailAndPassword(email, psw).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent(this, Login::class.java)
                        }else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Le password non corrispondono", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Spazi vuoti non ammessi", Toast.LENGTH_SHORT).show()
            }
        }

    }
}