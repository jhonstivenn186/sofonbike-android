package com.example.sofonbike


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.sofonbike.databinding.ActivityMainBinding
import java.lang.reflect.Array.newInstance


class MainActivity : AppCompatActivity() {
   //  val DURACION: Long = 2000;


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(UserFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){

                R.id.Userfragment -> replaceFragment(UserFragment())
                R.id.Emailfragment -> replaceFragment(EmailFragment())
                R.id.Favoritofragment -> replaceFragment(FavoritosFragment())
                R.id.Carritofragment -> replaceFragment(CarritoFragment())
                else ->{



                }

            }

            true

        }

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener{
            val intent: Intent = Intent(this,PruebaActivity ::class.java). apply {  }
            startActivity(intent)
        }


        val btn2: Button = findViewById(R.id.button3)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this,LoginActivity ::class.java). apply {  }
            startActivity(intent)
        }



        val btn3: Button = findViewById(R.id.button5)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this,RegistrarActivity ::class.java). apply {  }
            startActivity(intent)
        }

    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }



}