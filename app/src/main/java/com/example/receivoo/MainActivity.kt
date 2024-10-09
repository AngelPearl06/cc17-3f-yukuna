package com.example.receivoo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.receivoo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Planner())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.planner -> replaceFragment(Planner())
                R.id.scanner -> replaceFragment(Scanner())
                R.id.manager -> replaceFragment(Manager())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout ,fragment)
        fragmentTransaction.commit()
    }
}