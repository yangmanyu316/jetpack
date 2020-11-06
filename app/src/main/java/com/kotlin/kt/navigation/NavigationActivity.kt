package com.kotlin.kt.navigation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.kotlin.kt.R

/**
 * @ClassName: NavigationActivity
 * @Description: Navigation
 * @Author: yangmanyu
 * @Date: 2020/10/16 10:05
 */

class NavigationActivity : AppCompatActivity() {

    private var appBarConfiguration: AppBarConfiguration? = null
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration.Builder(navController!!.graph).build()
        NavigationUI.setupActionBarWithNavController(this, navController!!, appBarConfiguration!!)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_second, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, navController!!)
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController!!, appBarConfiguration!!)
                || super.onSupportNavigateUp()
    }
}