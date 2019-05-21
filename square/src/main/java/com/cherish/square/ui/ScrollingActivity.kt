package com.cherish.square.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.IntentExtra
import com.cherish.square.R
import kotlinx.android.synthetic.main.activity_scrolling.*

@Route(path = IntentExtra.SCROLLING)
class ScrollingActivity : BaseActivity() {
    override fun setContentId() = R.layout.activity_scrolling

    override fun bindData() {

    }

    override fun injectListener() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
