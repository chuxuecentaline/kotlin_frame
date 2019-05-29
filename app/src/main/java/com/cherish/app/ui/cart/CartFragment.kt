package com.cherish.app.ui.cart

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.app.login.LoginNavigationCallBack
import com.cherish.common.ui.BaseFragment
import com.cherish.common.utils.IntentExtra
import kotlinx.android.synthetic.main.centre_fragment.*


class CartFragment : BaseFragment() {
    private lateinit var viewModel: CartViewModel

    companion object {
        fun newInstance() = CartFragment()
        const val TAG = "MessageFragment"
    }

    override fun setLayoutId() = com.cherish.app.R.layout.cart_fragment

    override fun bindLiveData() {
    }

    override fun initConfigure(view: View) {
        viewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)

        btn_click.setOnClickListener {
            ARouter.getInstance()
                    .build(IntentExtra.Arouter.CART)
                    .navigation(activity, object : LoginNavigationCallBack() {
                        override fun onInterrupt(postcard: Postcard?) {
                            val path = postcard?.path
                            val bundle = postcard?.extras
                            // 被登录拦截了下来了
                            // 需要调转到登录页面，把参数跟被登录拦截下来的路径传递给登录页面，登录成功后再进行跳转被拦截的页面
                            ARouter.getInstance().build(IntentExtra.Arouter.LOGIN)
                                    .with(bundle)
                                    .withString(IntentExtra.PATH, path)
                                    .navigation(activity, 100)
                        }


                    })
        }
    }


}
