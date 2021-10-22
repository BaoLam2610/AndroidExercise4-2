package com.example.execise4_2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this,
            drawerLayout,
            R.string.nav_drawer_open,
            R.string.nav_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mnBottomNavMenu -> Intent(this,
                    BottomMenuActivity::class.java).also { intent ->
                    startActivity(intent)
                }
                R.id.mnToolbar -> Intent(this,
                    ToolbarActivity::class.java).also { intent ->
                    startActivity(intent)
                }
                R.id.mnCollapseToolbar -> Intent(this,
                    CollapseToolbarActivity::class.java).also { intent ->
                    startActivity(intent)
                }
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

}