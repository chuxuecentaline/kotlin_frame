package com.cherish.app.ui.cart

import androidx.lifecycle.ViewModelProviders
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter

import com.cherish.app.R
import com.cherish.common.ui.BaseFragment
import com.cherish.common.utils.IntentExtra
import kotlinx.android.synthetic.main.centre_fragment.*

class CartFragment : BaseFragment() {

    private lateinit var viewModel: CartViewModel

    override fun setLayoutId() = R.layout.cart_fragment

    override fun initConfigure(view: View?) {
        viewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)
        btn_click.setOnClickListener {
            ARouter.getInstance()
                    .build(IntentExtra.CART)
                    .navigation(activity)
        }
    }

    override fun bindLiveData() {
    }

    companion object {
        fun newInstance() = CartFragment()
        const val TAG = "MessageFragment"
    }


}
