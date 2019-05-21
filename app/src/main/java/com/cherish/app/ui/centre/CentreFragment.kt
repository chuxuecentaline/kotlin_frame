package com.cherish.app.ui.centre

import androidx.lifecycle.ViewModelProviders
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter

import com.cherish.app.R
import com.cherish.common.ui.BaseFragment
import com.cherish.common.utils.IntentExtra
import kotlinx.android.synthetic.main.centre_fragment.*

class CentreFragment : BaseFragment() {

    private lateinit var viewModel: CentreViewModel

    override fun setLayoutId() = R.layout.centre_fragment

    override fun initConfigure(view: View?) {
        viewModel = ViewModelProviders.of(this).get(CentreViewModel::class.java)
        btn_click.setOnClickListener {
            ARouter.getInstance().build(IntentExtra.LOGIN).navigation()
        }
    }

    override fun bindLiveData() {
    }

    companion object {
        fun newInstance() = CentreFragment()
        const val TAG = "AccountFragment"
    }


}
