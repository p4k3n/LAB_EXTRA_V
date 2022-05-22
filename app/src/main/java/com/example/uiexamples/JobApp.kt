package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class JobApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_app)

        val first = findViewById<TextView>(R.id.firstName)

        val last = findViewById<TextView>(R.id.lastName)

        val street = findViewById<TextView>(R.id.street)
        val street2 = findViewById<TextView>(R.id.street2)

        val city = findViewById<TextView>(R.id.city)
        val state = findViewById<TextView>(R.id.state)

        val postal = findViewById<TextView>(R.id.postal)
        val country = findViewById<TextView>(R.id.country)

        val email = findViewById<TextView>(R.id.email)
        val areaCode = findViewById<TextView>(R.id.areaCode)
        val phone = findViewById<TextView>(R.id.phone)

        val position = findViewById<TextView>(R.id.position)
        val date = findViewById<TextView>(R.id.date)

        val objeto: JobForm = intent.getSerializableExtra( "objeto") as JobForm
        first.text = objeto.firstName
        last.text = objeto.lastName
        street.text = objeto.streetAddress
        street2.text = objeto.streetAddressLineTwo
        city.text = objeto.city
        state.text = objeto.state
        postal.text = objeto.postal
        country.text = objeto.country
        email.text = objeto.email
        areaCode.text = objeto.areaCode
        phone.text = objeto.phoneNumber
        position.text = objeto.position
        date.text = objeto.date


        val back: Button = findViewById(R.id.btnBack)

        back.setOnClickListener {
            finish()
        }
    }
}