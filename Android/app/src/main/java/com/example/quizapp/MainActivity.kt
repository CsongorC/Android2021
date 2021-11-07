package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMenu()
    }

    fun initMenu() {
        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.home -> findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)
                R.id.quizGame -> findNavController(R.id.nav_host_fragment).navigate(R.id.quizStartFragment)
                R.id.addQuestion -> findNavController(R.id.nav_host_fragment).navigate(R.id.questionAddFragment)
                R.id.profile -> findNavController(R.id.nav_host_fragment).navigate(R.id.profileFragment)
                R.id.listOfQuestions -> findNavController(R.id.nav_host_fragment).navigate(R.id.questionListFragment)
                else -> false
            }
            drawerLayout.close()
            true
        }
    }

}