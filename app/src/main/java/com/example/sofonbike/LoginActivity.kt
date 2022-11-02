package com.example.sofonbike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {


    private lateinit var textUser: EditText
    private lateinit var textPassword: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        textUser=findViewById(R.id.textUser)
        textPassword=findViewById(R.id.textPassword)
        progressBar=findViewById(R.id.progressBar2)
        auth= FirebaseAuth.getInstance()

        val btn: Button = findViewById(R.id.button4)
        btn.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity ::class.java). apply {  }
            startActivity(intent)
        }

    }

    fun forgotPassword(view:View){

    }
    fun Registrar(view: View){
        startActivity(Intent(this,RegistrarActivity::class.java))
    }
    fun login(view:View){
        loginUser()
    }

    private fun loginUser(){
        val User:String=textUser.text.toString()
        val Password:String=textPassword.text.toString()

        if (!TextUtils.isEmpty(User) && !TextUtils.isEmpty(Password)){
            progressBar.visibility=View.VISIBLE
            auth.signInWithEmailAndPassword(User,Password)
                .addOnCompleteListener(this){
                    task->
                    if(task.isSuccessful){
                        action()

                    } else{
                        Toast.makeText(this,"Error en la autenticacion", Toast.LENGTH_LONG).show()
                    }
                }

            }
    }
    private fun action(){
        startActivity(Intent(this,MainActivity::class.java))
    }


}