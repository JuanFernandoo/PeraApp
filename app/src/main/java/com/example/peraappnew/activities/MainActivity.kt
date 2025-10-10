package com.example.peraappnew.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.peraappnew.R
import com.example.peraappnew.fragments.UpdateUserFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var menuButton: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        menuButton = findViewById(R.id.menuButton)

        menuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_op1 -> {
                    replaceFragment(UpdateUserFragment())
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_op2 -> {
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_op3 -> {
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_op4 -> {
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }.also {
                drawerLayout.closeDrawers()
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}