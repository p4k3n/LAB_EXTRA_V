package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)


        var personas: Personas = Personas.instance
        var user = findViewById(R.id.currentUser) as EditText
        var currentPass = findViewById(R.id.currentPass) as EditText
        var newPass = findViewById(R.id.newPass) as EditText
        var btn_update = findViewById(R.id.update) as Button
        var back = findViewById(R.id.back) as Button

        fun update() {
            var per = personas.getPersona(user.text.toString())

            if (per != null) {
                var i = personas.getIndexPerson(per.user)
                if (currentPass.text.toString() == per.password) {
                    per.password = newPass.text.toString()
                    personas.editPerson(per,i)
                    Toast.makeText(this, "Contraseña actualizada.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Error: La contraseña actual no es la correcta.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Error: No existe una persona con ese usuario.", Toast.LENGTH_SHORT).show()
            }
        }
        btn_update.setOnClickListener {
            update()
        }
        back.setOnClickListener {
            val i = Intent(this, LoginExample::class.java)
            startActivity(i)
            finish()
        }

    }
}