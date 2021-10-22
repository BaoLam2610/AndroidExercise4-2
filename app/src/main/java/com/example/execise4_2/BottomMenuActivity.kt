package com.example.execise4_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.execise4_2.adapter.ViewPager2Adapter
import com.example.execise4_2.ui.home.HomeFragment
import com.example.execise4_2.ui.person.PersonFragment
import com.example.execise4_2.ui.settings.SettingsFragment
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_bottom_menu.*

class BottomMenuActivity : AppCompatActivity() {

    val fragmentList = listOf(
        HomeFragment(), PersonFragment(), SettingsFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_menu)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mnHome -> viewPager2.currentItem = 0
                R.id.mnPerson -> viewPager2.currentItem = 1
                R.id.mnSettings -> viewPager2.currentItem = 2
            }
            true
        }

        viewPager2.adapter = ViewPager2Adapter(fragmentList,this)

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottomNavigationView.menu.findItem(R.id.mnHome).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.mnPerson).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.mnSettings).isChecked = true
                }
            }
        })

        val menuItemId: Int = bottomNavigationView.menu.getItem(0).itemId
        val badge: BadgeDrawable = bottomNavigationView.getOrCreateBadge(menuItemId)
        badge.number = 2
        badge.badgeGravity = BadgeDrawable.TOP_END
        badge.backgroundColor = Color.GREEN
    }
}