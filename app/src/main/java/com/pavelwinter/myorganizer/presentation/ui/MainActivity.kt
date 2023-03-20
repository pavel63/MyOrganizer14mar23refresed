package com.pavelwinter.myorganizer.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.pavelwinter.myorganizer.databinding.ActivityMainBinding
import com.pavelwinter.myorganizer.presentation.fragments.ProjectsFragment
import com.pavelwinter.myorganizer.presentation.fragments.QuotaFragment
import com.pavelwinter.myorganizer.presentation.fragments.TaskListFragment
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        bottomNavigationInit()
    }


    private fun bottomNavigationInit() {
        binding.bnve.enableAnimation(false)
       binding. bnve.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
       binding. bnve.setTextSize(10.0f)
       binding. bnve.setIconSize(24f, 24f)

        goToFragment(TaskListFragment())
       binding. bnve.currentItem = 0

        binding.bnve.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                com.pavelwinter.myorganizer.R.id.bottom_navigation_list_m -> {
                    if (getVisibleFragment() !is TaskListFragment) {
                        item.isChecked = true
                        goToFragment(TaskListFragment())
                    }
                }

                com.pavelwinter.myorganizer.R.id.bottom_navigation_projects_m -> {
                    if (getVisibleFragment() !is ProjectsFragment) {
                        item.isChecked = true
                        goToFragment(ProjectsFragment())
                    }
                }

                com.pavelwinter.myorganizer.R.id.bottom_navigation_quotas_m -> {
                    if (getVisibleFragment() !is QuotaFragment) {
                        item.isChecked = true
                        goToFragment(QuotaFragment())
                    }
                }
            }
            true
        }
    }


    private fun goToFragment(fragmentTo: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(com.pavelwinter.myorganizer.R.id.nav_host_fragment, fragmentTo)
            .commit()
    }


    private fun getVisibleFragment(): Fragment? {
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
