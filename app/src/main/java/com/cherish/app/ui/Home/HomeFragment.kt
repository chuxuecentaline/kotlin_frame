package com.cherish.app.Home

import android.view.View
import com.cherish.app.R
import com.cherish.app.ui.listdemo.ListActivity
import com.cherish.app.ui.search.SearchHomeActivity
import com.cherish.common.picengine.glide.SimpleImageLoad
import com.cherish.common.ui.BaseFragment
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 首页
 */
class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
        const val TAG = "HomeFragment"
    }

    override fun setLayoutId() = R.layout.fragment_home

    override fun bindLiveData() {

    }

    override fun initConfigure(view: View) {

        SimpleImageLoad<String>(requireActivity()).load(iv_bg, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558419894267&di=d04afdd1fce989f18534f335dbd1f316&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201708%2F02%2F20170802172403_YVvPG.thumb.700_0.gif")

    }

    override fun injectListener() {
        btn_click1?.let {
            btn_click1.clicks().subscribe {

                launchActivity(ListActivity::class.java)
            }
        }
        iv_bg?.apply {
            iv_bg.clicks().subscribe {
                launchActivity(SearchHomeActivity::class.java)
            }

        }
    }

}
