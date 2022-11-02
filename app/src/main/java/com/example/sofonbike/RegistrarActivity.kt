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
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.Reference

class RegistrarActivity : AppCompatActivity() {

    private lateinit var textName:EditText
    private lateinit var textLastname:EditText
    private lateinit var textEmail:EditText
    private lateinit var textPassword:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        textName=findViewById(R.id.textName)
        textLastname=findViewById(R.id.textLastname)
        textEmail=findViewById(R.id.textEmail)
        textPassword=findViewById(R.id.textPassword)
        progressBar=findViewById(R.id.progressBar)
        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        dbReference=database.reference.child("User")

        val btn: Button = findViewById(R.id.button6)
        btn.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity ::class.java). apply {  }
            startActivity(intent)
        }










    }
    fun Registrar(view:View){
        createNewAccount()
    }
        private fun createNewAccount(){
            val Name:String=textName.text.toString()
            val Lastname:String=textLastname.text.toString()
            val Email:String=textEmail.text.toString()
            val Password:String=textPassword.text.toString()

            if(!TextUtils.isEmpty(Name) &&!TextUtils.isEmpty(Lastname) &&!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password) ){
                progressBar.visibility=View.VISIBLE

                auth.createUserWithEmailAndPassword(Email,Password)
                    .addOnCompleteListener(this){
                        task->
                        if(task.isComplete){
                            val user:FirebaseUser?=auth.currentUser
                            verifyEmail(user)

                            val userBD=dbReference.child(user?.uid.toString())
                            userBD.child("Name").setValue(Name)
                            userBD.child("Lastname").setValue(Lastname)
                            action()


                        }
                    }
            }

        }

    private fun action(){
        startActivity(Intent(this,LoginActivity::class.java))
    }
    private fun verifyEmail(user:FirebaseUser?){
        user?.sendEmailVerification()
                ?.addOnCompleteListener(this){
                        task->
                    if(task.isComplete){
                       Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Error al enviar el email",Toast.LENGTH_LONG).show()
                    }
                }
    }



}