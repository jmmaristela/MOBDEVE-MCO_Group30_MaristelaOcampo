package com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments.HomeFragment
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments.NotificationFragment
import com.mobdeve.s12.maristela.joseph_miguel.mobdeve_maristelaocampo_mco.fragments.StartActivityFragment

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_menu -> {
                    setCurrentFragment(HomeFragment())
                    true
                }
                R.id.start_menu -> {
                    setCurrentFragment(StartActivityFragment())
                    true
                }
                R.id.notif_menu -> {
                    setCurrentFragment(NotificationFragment())
                    true
                }
                R.id.profile_menu -> {
                    setCurrentFragment(ProfileActivity())
                    true
                }
                else -> false
            }
        }

        // Set the initial fragment
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.home_menu
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }

}
