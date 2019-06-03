package com.aurora.system.ui.centre

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.aurora.system.R
import com.aurora.system.ui.search.SearchHomeActivity
import com.aurora.common.ui.BaseFragment
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.centre_fragment.*
import java.util.concurrent.TimeUnit

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

        btn_click.clicks().throttleFirst(2,TimeUnit.SECONDS).subscribe{
            launchActivity(SearchHomeActivity::class.java)
        }
    }

    override fun injectListener() {

    }

}
