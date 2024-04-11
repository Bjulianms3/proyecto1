package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class login2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val texv_bienvenido = findViewById<TextView>(R.id.texv_bienvenido)

        val nombreUsuario =  intent.getStringExtra("usuario")
        val sharedPref = this.getSharedPreferences("MisharedPrefer",MODE_PRIVATE)
        val apodo = sharedPref.getString("apodo", "")

        texv_bienvenido.append(" " + nombreUsuario)
    }
}