package com.example.lf_parkcar
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Delay di 3 secondi prima di passare all'activity_sign_up
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }, 300) // 3000 millisecondi = 3 secondi
    }
}