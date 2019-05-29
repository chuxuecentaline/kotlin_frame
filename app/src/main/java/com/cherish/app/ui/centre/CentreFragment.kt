package com.cherish.app.ui.centre

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.app.R
import com.cherish.common.ui.BaseFragment
import com.cherish.common.utils.IntentExtra
import kotlinx.android.synthetic.main.centre_fragment.*

class CentreFragment : BaseFragment() {

    private lateinit var viewModel: CentreViewModel

    companion object {
        fun newInstance() = CentreFragment()
        const val TAG = "AccountFragment"
    }

    override fun setLayoutId() = R.layout.centre_fragment

    override fun bindLiveData() {
        viewModel = ViewModelProviders.of(this).get(CentreViewModel::class.java)
    }

    override fun initConfigure(view: View) {

        btn_click.setOnClickListener {
            ARouter.getInstance().build(IntentExtra.Arouter.LOGIN).navigation()
        }
    }

    override fun injectListener() {

    }

}
