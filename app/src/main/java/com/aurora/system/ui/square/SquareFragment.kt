package com.aurora.system.ui.square

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.aurora.system.R
import com.aurora.common.ui.BaseFragment
import com.aurora.common.utils.IntentExtra
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.centre_fragment.*
import java.util.concurrent.TimeUnit

class SquareFragment : BaseFragment() {

    private lateinit var viewModel: SquareViewModel

    companion object {
        fun newInstance() = SquareFragment()
        const val TAG = "ReOrderFragment"
    }

    override fun setLayoutId() = R.layout.square_fragment

    override fun bindLiveData() {
        viewModel = ViewModelProviders.of(this).get(SquareViewModel::class.java)
    }

    override fun initConfigure(view: View) {

        btn_click.clicks().throttleFirst(2,TimeUnit.SECONDS).subscribe {
            ARouter.getInstance().build(IntentExtra.Arouter.SCROLLING).navigation(activity, object : NavigationCallback {
                override fun onLost(postcard: Postcard?) {
                }

                override fun onFound(postcard: Postcard?) {

                }

                override fun onInterrupt(postcard: Postcard?) {

                }

                override fun onArrival(postcard: Postcard?) {

                }

            })
        }
    }

    override fun injectListener() {

    }

}
