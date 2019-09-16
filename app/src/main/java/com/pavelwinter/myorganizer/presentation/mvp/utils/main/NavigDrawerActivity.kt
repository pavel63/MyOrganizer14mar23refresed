package com.pavelwinter.myorganizer.presentation.mvp.utils.main

import android.os.Bundle
import android.text.TextUtils.replace
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.tabs.TabLayout
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.content_navig_drawer.*
import timber.log.Timber

class NavigDrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bnve: BottomNavigationViewEx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navig_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val sectionsPagerAdapter =
            SectionsPagerAdapter(

                this,
                supportFragmentManager
            )
      /*  val viewPager: ViewPager = findViewById(R.id.view_pager)
       viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)*/

        //!!!!
       // tabs.visibility = View.GONE

        /*  val fab: FloatingActionButton = findViewById(R.id.fab)

          fab.setOnClickListener { view ->
              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  .setAction("Action", null).show()
          }*/


        /*val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        //menu should be considered as top level destinations.


        /*appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.bottom_navigation_list_m, R.id.bottom_navigation_projects_m, R.id.bottom_navigation_quotas_m,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
         */
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navig_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    public fun bottomNavigationInit() {
        bnve = findViewById(R.id.bnve)
        bnve?.enableAnimation(false)
        bnve?.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        bnve?.setTextSize(10.0f)
        bnve?.setIconSize(24f, 24f)

        //  updateBadge()

        bnve?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.bottom_navigation_list_m -> {
                    item.isChecked = true
                }

                R.id.nav_gallery -> {
                    item.isChecked = true
                }

                R.id.nav_slideshow -> {
                    item.isChecked = true
                }

                R.id.nav_tools -> {
                    item.isChecked = true

                }
            }
            true
        }

    }



    fun getVisibleFragment(): androidx.fragment.app.Fragment? {
        try {
            val fragmentManager = supportFragmentManager
            val fragments = fragmentManager?.fragments
            if (!fragments.isNullOrEmpty()) {
                for (fragment in fragments) {
                    if (fragment != null && fragment.isVisible)
                        Timber.d("===CURRENT FRAGMENT ${fragment.javaClass}")
                    Timber.d("===CURRENT FRAGMENT simple name${fragment?.javaClass?.simpleName}")
                    Timber.d("===FRAGM TAG ${fragment.tag}")
                    return fragment
                }
            }
            return null
        } catch (throwable: Throwable) {
            return null
        }
    }


}
