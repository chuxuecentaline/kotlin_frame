package com.cherish.square.ui.demo

import android.view.Menu
import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.IntentExtra
import com.cherish.square.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_scrolling.*


@Route(path = IntentExtra.Arouter.SCROLLING)
class ScrollingActivity : BaseActivity() {

    var list = arrayListOf(
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558610004143&di=53af0e2c92a0b518be0669c7052ee327&imgtype=0&src=http%3A%2F%2Fbaiducdn.pig66.com%2Fuploadfile%2F2017%2F0511%2F20170511074941292.jpg", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=395856847,2865233529&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558610043019&di=655f1186ce0f7498aeddc1a5d840080d&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201701%2F29%2F20170129220732_TVhrm.thumb.700_0.jpeg", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558610061492&di=858852fbcb7083eaa72b8dc19823da0e&imgtype=0&src=http%3A%2F%2Fupload.mnw.cn%2F2017%2F0814%2F1502698443566.jpg", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558610061491&di=82484be46fe876d2948be1e103a3f082&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201701%2F29%2F20170129220718_3nkUi.jpeg")

    override fun setContentId() = R.layout.activity_scrolling

    override fun bindData() {

        customHeadView.setData(list)
        setSupportActionBar(toolbar)
        supportActionBar.apply {
            this?.setHomeButtonEnabled(true)
        }

    }

    override fun injectListener() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
