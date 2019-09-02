package com.pavelwinter.myorganizer.presentation.mvp.utils.main.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.fragments.PlaceholderFragment

private val TAB_TITLES = arrayOf(
    R.string.agenda,
    R.string.projects,
    R.string.quotas
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(
            position + 1
        )
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }




    override fun getCount(): Int {
        return 3
    }
}