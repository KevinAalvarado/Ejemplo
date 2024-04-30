package kevin.alvarado.registroyloginfirebasekevin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a todos los elementos de la vista
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContrasena = findViewById<EditText>(R.id.txtPass)
        val btnRegistrarme = findViewById<Button>(R.id.btnRegistrar)

        fun limpiar(){
            txtCorreo.setText("")
            txtContrasena.setText("")
            txtCorreo.clearFocus()
            txtContrasena.clearFocus()
        }

        //2- Programa el boton para registrar el usuario
        btnRegistrarme.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtCorreo.text.toString(), txtContrasena.text.toString())
            limpiar()
            Toast.makeText(this, "Usuario registrado", Toast.LENGTH_LONG).show()
        }


    }
}