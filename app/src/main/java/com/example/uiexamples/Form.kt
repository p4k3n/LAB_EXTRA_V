package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        var bundle = intent.extras
        var titulo = bundle!!.getString("titulo")
        var posicion = bundle!!.getInt("posicion")
        var tit = findViewById(R.id.titulo) as TextView
        tit.setText(titulo)

        var user = findViewById(R.id.user) as TextView
        var name = findViewById(R.id.name) as TextView
        var password = findViewById(R.id.password) as TextView
        var btn = findViewById(R.id.button) as Button
        var foto = 0

        if(bundle.getSerializable("usuario")!=null){
            var  persona =  bundle.getSerializable("usuario") as Persona
            user.setText(persona.user)
            name.setText(persona.nombre)
            password.setText(persona.password)
            foto = persona.foto
        }else{
            println("insertar")
        }
        btn.setOnClickListener {

                var per = Persona(user.toString(), password.toString(), name.toString(), foto)
                val i = Intent(this, MenuExample::class.java)
                //i.putExtra("Login", Login)
                startActivity(i)


        }
    }
}