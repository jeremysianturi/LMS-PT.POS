package com.pos.lms.core.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var tabTittles = ArrayList<String>()
    private var fragment = ArrayList<Fragment>()

    fun addFragments(
        fragments: Fragment?,
        titles: String?
    ) {
        fragments?.let { fragment.add(it) }
        titles?.let { this.tabTittles.add(it) }
    }


    override fun getItem(position: Int): Fragment {

        return fragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTittles[position]
    }

    override fun getCount(): Int {
        return fragment.size
    }
}