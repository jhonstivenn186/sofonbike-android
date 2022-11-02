package com.example.sofonbike

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PruebaActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)


        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity ::class.java). apply {  }
            startActivity(intent)
        }

    }

}