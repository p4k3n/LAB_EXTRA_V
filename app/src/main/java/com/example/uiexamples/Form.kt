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
        var personas: Personas = Personas.instance
        var bundle = intent.extras
        var titulo = bundle!!.getString("titulo")
        var posicion = bundle!!.getInt("posicion")
        var tit = findViewById(R.id.titulo) as TextView
        tit.setText(titulo)

        var user = findViewById(R.id.user) as TextView
        var name = findViewById(R.id.name) as TextView
        var password = findViewById(R.id.password) as TextView
        var rol = "standard"
        var btn = findViewById(R.id.button) as Button
        var foto = 0



        if(bundle.getSerializable("usuario")!=null){
            var  persona =  bundle.getSerializable("usuario") as Persona
            user.setText(persona.user)
            name.setText(persona.nombre)
            password.setText(persona.password)
            foto = persona.foto
            btn.setOnClickListener {
                var per = Persona(user.text.toString(), password.text.toString(), name.text.toString(), foto, rol)
                personas.editPerson(per,posicion)
                val i = Intent(this, CrudPersonas::class.java)
                Toast.makeText(this, "Usuario editado", Toast.LENGTH_SHORT).show()
                startActivity(i)
                finish()
            }
        }else if(bundle.getSerializable("flag") != null) {
            btn.setOnClickListener {
                var per = Persona(user.text.toString(), password.text.toString(), name.text.toString(), 2131165293, rol)
                personas.addPersona(per)
                val i = Intent(this, LoginExample::class.java)
                Toast.makeText(this, "Usario registrado", Toast.LENGTH_SHORT).show()
                startActivity(i)
                finish()
            }
        }else{
            btn.setOnClickListener {
                var per = Persona(user.text.toString(), password.text.toString(), name.text.toString(), 2131165293, rol)
                personas.addPersona(per)
                val i = Intent(this, CrudPersonas::class.java)
                Toast.makeText(this, "Usario agregado", Toast.LENGTH_SHORT).show()
                startActivity(i)
                finish()
            }
        }

    }
}