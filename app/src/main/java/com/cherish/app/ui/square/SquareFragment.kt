package com.cherish.app.ui.square

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.app.R
import com.cherish.common.ui.BaseFragment
import com.cherish.common.utils.IntentExtra
import kotlinx.android.synthetic.main.centre_fragment.*

class SquareFragment : BaseFragment() {

    private lateinit var viewModel: SquareViewModel

    override fun setLayoutId() = R.layout.square_fragment

    override fun initConfigure(view: View?) {
        viewModel = ViewModelProviders.of(this).get(SquareViewModel::class.java)
        btn_click.setOnClickListener {
            ARouter.getInstance().build(IntentExtra.SCROLLING).navigation(activity, object :NavigationCallback{
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

    override fun bindLiveData() {
    }

    companion object {
        fun newInstance() = SquareFragment()
        const val TAG = "ReOrderFragment"
    }

}
