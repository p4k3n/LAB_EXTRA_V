package com.example.uiexamples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uiexamples.ui.Login

class LoginExample : AppCompatActivity() {

    var personas: Personas = Personas.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_example)
        // get reference to all views


        var et_user_name = findViewById(R.id.et_user_name) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_reset = findViewById(R.id.btn_reset) as Button
        var btn_submit = findViewById(R.id.btn_submit) as Button
        var btn_reg = findViewById(R.id.btn_reg) as Button
        var btn_pass = findViewById(R.id.btn_pass) as Button

        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_user_name.setText("")
            et_password.setText("")
        }

        // set on-click listener
        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;
            //Toast.makeText(this@LoginExample, user_name, Toast.LENGTH_LONG).show()
            if(personas.login(user_name.toString(), password.toString())){
                val bundle = Bundle()
                val Login = personas.loginP(user_name.toString(), password.toString())
                val i = Intent(this, MenuExample::class.java)
                i.putExtra("msg", "MENSAJE DE Login al Menú")
                i.putExtra("Login", Login)
                startActivity(i)
            }else{
                Toast.makeText(this, "El usuario no se encuentra registrado", Toast.LENGTH_SHORT).show()
            }

        }
        btn_reg.setOnClickListener{
            val intent2 = Intent(applicationContext, Form::class.java)
            intent2.putExtra("flag","flag")
            startActivity(intent2)
            finish()
        }

        btn_pass.setOnClickListener{
            val intent3 = Intent(this, Password::class.java)
            startActivity(intent3)
            finish()
        }
    }
}