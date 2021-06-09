package com.example.myagent

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_basket,
                R.id.nav_all_product,
                R.id.nav_basket,
                R.id.nav_order,
                R.id.nav_alert,
                R.id.nav_wine,
                R.id.nav_questions_answers,
                R.id.nav_history_order,
                R.id.nav_my_profile,
                R.id.privacyPolicyFragment,
                R.id.selectedProductInfoFragment,
                R.id.suppliersInfoFragment,
                R.id.selectedProductInfoFragment,
                R.id.howDoesItWorksFragment,
                R.id.nav_product_category,
                R.id.suppliersListFragment,
                R.id.suppliersInfoFragment,
                R.id.favouriteFragment,
                R.id.questionsAndAnswersFragment,
                R.id.cannedProductsFragment

            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        var i=0
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.authFragment -> {
                    toolbar.setVisibility(View.GONE)
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                R.id.authDataFragment -> {
                    toolbar.setVisibility(View.GONE)
                }
                R.id.nav_all_product -> {
                    toolbar.setVisibility(View.VISIBLE)
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)


                }
            }
        }

        navView.setNavigationItemSelectedListener {
            Log.d("ttt", "$it")

            when (it.itemId) {
                R.id.nav_share -> {
//                    Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()

//                    val callIntent = Intent(Intent.ACTION_CALL)
//                    callIntent.data = Uri.parse("tel:9961907453")
//                    if (ActivityCompat.checkSelfPermission(
//                            this@MainActivity,
//                            Manifest.permission.CALL_PHONE
//                        ) != PackageManager.PERMISSION_GRANTED
//                    )else {
////                        return false
//                        startActivity(callIntent)
//                    }

                    makePhoneCall("+998 93 004 10 24")

                    drawerLayout.close()
                }
            }

            when (it.title) {
                "Мой профиль"->{

                    navController.navigate(R.id.nav_my_profile)
                    drawerLayout.close()
                }
                "Продовольственные"->{

                    navController.navigate(R.id.nav_product_category)
                    drawerLayout.close()
                }
                "Список поставщиков"->{

                    navController.navigate(R.id.suppliersListFragment)
                    drawerLayout.close()
                }
                "Накопленные проценты"->{
                    navController.navigate(R.id.nav_questions_answers)
                    drawerLayout.close()
                }
                "Мои заказы"->{

//                    navController.navigate(R.id.suppliersListFragment)

//                    showSpinner()

//                    val spinner: Spinner = findViewById(R.id.nav_lang)
//                    ArrayAdapter.createFromResource(
//                        this,
//                        R.array.planets_array,
//                        R.layout.spinner_item
//                    ).also { adapter ->
//                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//                        spinner.adapter = adapter
//                    }


                    navController.navigate(R.id.nav_history_order)
                    drawerLayout.close()

                }
                "Как работает"->{

                    navController.navigate(R.id.howDoesItWorksFragment)
                    drawerLayout.close()
                }
                "Вопросы и ответы"->{

                    navController.navigate(R.id.questionsAndAnswersFragment)
                    drawerLayout.close()
                }

                "Публичная оферта"->{

                    navController.navigate(R.id.privacyPolicyFragment)
                    drawerLayout.close()
                }

            }

            false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

  private fun  makePhoneCall(phone: String) {
        val call = Intent(Intent.ACTION_DIAL);
        call.data = Uri.parse("tel:$phone")
        this.startActivity(call)
    }

    override    fun onBackPressed() {
        var i=0
        if(navController.currentDestination?.id==R.id.nav_all_product)
        {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                return
            }

            doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_LONG).show()

            Handler().postDelayed({
                doubleBackToExitPressedOnce = false;
            }, 2000)
        }
        else
            super.onBackPressed()    }


}