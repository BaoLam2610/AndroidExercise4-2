package com.example.execise4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : AppCompatActivity() {

    var count = 0
    var menuItem: MenuItem? = null
    private var tvBadge: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        btnAdd.setOnClickListener {
            count++
            invalidateOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        // set menu item badge
        menuItem = menu?.findItem(R.id.mnNotification)

        if(count == 0)
            menuItem?.actionView = null
        else{
            menuItem?.setActionView(R.layout.notification_badge)
            val view = menuItem!!.actionView
            tvBadge = view.findViewById(R.id.text_badge)
            tvBadge?.text = count.toString()
            view.setOnClickListener {
                onOptionsItemSelected(menuItem!!)
            }
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnSearch -> Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            R.id.mnHome -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            R.id.mnPerson -> Toast.makeText(this, "Person", Toast.LENGTH_SHORT).show()
            R.id.mnSettings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            R.id.mnNotification -> {
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Your notification")
                    .setMessage("You have $count notifications")
                    .create()
                dialog.show()
            }
        }
        return true
    }
}