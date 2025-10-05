package com.example.peraappnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_op1 -> {
                    val intent = Intent(this, UpdateUserActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_op2 -> {
                    true
                }
                R.id.nav_op3 -> {
                    true
                }
                R.id.nav_op4 -> {
                    true
                }
                else -> false
            }

        }
    }
}