package com.shyptsolution.sidemenubar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.ToggleButton
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {


   lateinit var toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navvie:NavigationView=findViewById(R.id.navmenu)
        var driver:DrawerLayout=findViewById(R.id.drawerlayout)
//        var toolbar:androidx.appcompat.widget.Toolbar=findViewById(R.id.toolbar)

         toggle= ActionBarDrawerToggle(this,driver,R.string.open,R.string.close)
        driver.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
        navvie.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    Toast.makeText(applicationContext, "Home is Selected", Toast.LENGTH_SHORT)
                        .show()
                    driver.closeDrawer(GravityCompat.START)
                }

                R.id.setting -> {
                    Toast.makeText(applicationContext, "Setting is Selected", Toast.LENGTH_SHORT)
                        .show()
                    driver.closeDrawer(GravityCompat.START)
                }

                R.id.call -> {
                    Toast.makeText(applicationContext, "Call is Selected", Toast.LENGTH_SHORT)
                        .show()
                    driver.closeDrawer(GravityCompat.START)
                }


                else -> throw IllegalStateException("Unexpected value: " + item.itemId)
            }
            true
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}




