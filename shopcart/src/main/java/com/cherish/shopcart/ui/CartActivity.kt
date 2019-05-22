package com.cherish.shopcart.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.IntentExtra
import com.cherish.shopcart.R

import kotlinx.android.synthetic.main.activity_cart.*

@Route(path = IntentExtra.CART)
class CartActivity : BaseActivity() {
    override fun setContentId() = R.layout.activity_cart

    override fun bindData() {

    }

    override fun injectListener() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
