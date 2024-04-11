package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt_siguiente = findViewById<Button>(R.id.bt_siguiente);
        val ptUsuario = findViewById<EditText>(R.id.pt_Usuario);
        val ptContrasena = findViewById<EditText>(R.id.pt_Contrasena);
        val ptApodo = findViewById<EditText>(R.id.pt_apodo);

        bt_siguiente.setOnClickListener {
            val usuario = ptUsuario.text.toString()
            val contrasena = ptContrasena.text.toString()
            val apodo = ptApodo.text.toString()

            if (usuario == "ximena") {
                if (contrasena == "xime") {
                    val intent = Intent(this, login2::class.java)
                    intent.putExtra("usuario",usuario)
                    startActivity(intent)

                    val sharedPref = this.getSharedPreferences("MiSharedPrefer", MODE_PRIVATE)
                    with (sharedPref.edit()){
                        putString("apodo",apodo)
                        apply()
                    }
                } else {
                    Toast.makeText(this, "contaseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "datos incorrectos", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, login2::class.java)
            startActivity(intent)
        }
    }
}