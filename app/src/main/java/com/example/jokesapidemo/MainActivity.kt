package com.example.jokesapidemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jokesapidemo.apicall.FavViewModel.FavouriteFragment
import com.example.jokesapidemo.apicall.homemodel.HomeFragment
import com.example.jokesapidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
         //   enableEdgeToEdge()

            binding= ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            replaceFragment(HomeFragment())

            binding.bottomNavigation.setOnItemSelectedListener {

                when(it.itemId){
                    R.id.navigation_home -> replaceFragment(HomeFragment())
                    R.id.navigation_favourite -> replaceFragment(FavouriteFragment())

                    else -> {

                    }
                }
                  true
            }

        }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

    }




