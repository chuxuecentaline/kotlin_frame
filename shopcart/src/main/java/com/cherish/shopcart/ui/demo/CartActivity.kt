package com.cherish.shopcart.ui.demo

import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.IntentExtra
import com.cherish.common.widget.toolbar.normal.NormalNavigationBar
import com.cherish.shopcart.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cart.*

@Route(path = IntentExtra.Arouter.CART)
class CartActivity : BaseActivity() {

    override fun setContentId() = R.layout.activity_cart

    override fun initConfig() {

    }

    override fun bindData() {
        NormalNavigationBar.Build(this, coordinator).setTitle("title")
                .setTranslucent(true)
                .setBackIcon(R.drawable.ic_chevron_left_black)
                .setTitleColor(ContextCompat.getColor(this, R.color.color_333333))
                .setStatusColor(ContextCompat.getColor(this, R.color.white))
                .setBackgroundColor(R.color.white)
                .setThemeMode(true)
                .create()
    }

    override fun injectListener() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }

}
