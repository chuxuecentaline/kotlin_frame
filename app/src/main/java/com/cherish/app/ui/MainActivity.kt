package com.cherish.app.ui

import androidx.fragment.app.FragmentTransaction
import com.cherish.app.Home.HomeFragment
import com.cherish.app.R
import com.cherish.app.ui.centre.CentreFragment
import com.cherish.app.ui.cart.CartFragment
import com.cherish.app.ui.square.SquareFragment
import com.cherish.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var fragmentPosition = 0
    override fun setContentId() = R.layout.activity_main

    override fun bindData() {
        updateFragment(0)
    }

    override fun injectListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_home -> {
                    updateFragment(0)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_message -> {
                    updateFragment(1)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_reorder -> {
                    updateFragment(2)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_account -> {
                    updateFragment(3)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    updateFragment(0)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    /**
     * fragment 切换
     */
    private fun updateFragment(position: Int) {
        val hideFragment = when (fragmentPosition) {
            0 -> supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
            1 -> supportFragmentManager.findFragmentByTag(CartFragment.TAG)
            2 -> supportFragmentManager.findFragmentByTag(SquareFragment.TAG)
            3 -> supportFragmentManager.findFragmentByTag(CentreFragment.TAG)
            else -> null
        }
        val showFragment = when (position) {
            0 -> supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
                    ?: HomeFragment.newInstance()
            1 -> supportFragmentManager.findFragmentByTag(CartFragment.TAG)
                    ?: CartFragment.newInstance()
            2 -> supportFragmentManager.findFragmentByTag(SquareFragment.TAG)
                    ?: SquareFragment.newInstance()
            3 -> supportFragmentManager.findFragmentByTag(CentreFragment.TAG)
                    ?: CentreFragment.newInstance()
            else -> supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
                    ?: HomeFragment.newInstance()
        }
        val tag = when (position) {
            0 -> HomeFragment.TAG
            1 -> CartFragment.TAG
            2 -> SquareFragment.TAG
            3 -> CentreFragment.TAG
            else -> HomeFragment.TAG
        }
        fragmentPosition = position
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        hideFragment?.let { transaction.hide(it) }
        if (showFragment.isAdded) {
            transaction.show(showFragment)
        } else {
            transaction.add(R.id.fl_content, showFragment, tag)
        }
        transaction.commitAllowingStateLoss()
    }
}
