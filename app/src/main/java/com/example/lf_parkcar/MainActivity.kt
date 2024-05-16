import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.lf_parkcar.Login
import com.example.lf_parkcar.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            // Avvia l'Activity di Login dopo 5 secondi
            startActivity(Intent(this, Login::class.java))
            // Chiudi l'attuale MainActivity
            finish()
        }, 5000)
    }
}
