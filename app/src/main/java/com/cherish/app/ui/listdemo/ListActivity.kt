package com.cherish.app.ui.listdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import com.cherish.app.R
import com.cherish.common.ui.BaseActivity
import com.cherish.common.widget.toolbar.normal.NormalNavigationBar
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_list2.*

class ListActivity : BaseActivity() {

    override fun setContentId() = R.layout.activity_list2

    override fun bindData() {
        NormalNavigationBar.Build(this, ll_root).setTitle("demo")
                .setTranslucent(true)
                .setBackIcon(R.drawable.ic_chevron_left_white)
                .setTitleColor(Color.WHITE)
                .setStatusColor(ContextCompat.getColor(this,R.color.colorPrimary))
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
