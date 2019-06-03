package com.aurora.system.ui.listdemo

import android.graphics.Color
import android.view.Menu
import androidx.core.content.ContextCompat
import com.aurora.system.R
import com.aurora.common.ui.BaseActivity
import com.aurora.common.widget.toolbar.normal.NormalNavigationBar
import kotlinx.android.synthetic.main.activity_list2.*

class ListActivity : BaseActivity() {

    override fun setContentId() = R.layout.activity_list2

    override fun initConfig() {

    }

    override fun bindData() {
        NormalNavigationBar.Build(this, ll_root).setTitle("demo")
                .setTranslucent(true)
                .setBackIcon(R.drawable.ic_chevron_left_white)
                .setTitleColor(Color.WHITE)
                .setStatusColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setBackgroundColor(R.color.colorPrimary)
                .create()
    }

    override fun injectListener() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_tab, menu)
        return true
    }

}
