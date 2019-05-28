package com.cherish.app.Home

import android.content.Intent
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.cherish.app.R
import com.cherish.app.ui.listdemo.ListActivity
import com.cherish.common.picengine.glide.SimpleImageLoad
import com.cherish.common.ui.BaseFragment
import com.google.android.material.snackbar.Snackbar
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
        loadingDialog()

    }

    override fun initConfigure(view: View) {

        btn_click1.let {
            btn_click1.setOnClickListener {

                startActivity(Intent(activity, ListActivity::class.java))
            }
        }
        iv_bg.apply {
            setOnClickListener {
                Snackbar.make(iv_bg, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }
        SimpleImageLoad<String>(requireActivity()).load(iv_bg, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558419894267&di=d04afdd1fce989f18534f335dbd1f316&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201708%2F02%2F20170802172403_YVvPG.thumb.700_0.gif")

    }


}
