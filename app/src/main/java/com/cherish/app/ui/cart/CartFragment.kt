package com.cherish.app.ui.cart

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.app.R
import com.cherish.common.ui.BaseFragment
import com.cherish.common.utils.IntentExtra
import kotlinx.android.synthetic.main.centre_fragment.*

class CartFragment : BaseFragment() {
    private lateinit var viewModel: CartViewModel

    companion object {
        fun newInstance() = CartFragment()
        const val TAG = "MessageFragment"
    }

    override fun setLayoutId() = R.layout.cart_fragment

    override fun bindLiveData() {
    }

    override fun initConfigure(view: View) {
        viewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)
        btn_click.setOnClickListener {
            ARouter.getInstance()
                    .build(IntentExtra.CART)
                    .navigation(activity,object :NavCallback(){
                        override fun onArrival(postcard: Postcard?) {
                            println("success ${postcard?.path}")
                        }

                        override fun onInterrupt(postcard: Postcard?) {
                            super.onInterrupt(postcard)
                            println("success ${postcard?.path}")
                        }

                    })
        }
    }



}
