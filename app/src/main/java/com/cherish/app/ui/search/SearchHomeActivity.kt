package com.cherish.app.ui.search

import android.view.Menu
import android.view.MenuItem
import com.cherish.app.R
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.ToastUtil
import com.cherish.common.widget.view.search.SearchCallBack
import kotlinx.android.synthetic.main.activity_search_home.*

/**
 * @author: cherish
 * @description: 搜索主页
 * @date: 2019/5/29 9:20
 * @version: 2.0
 */
class SearchHomeActivity : BaseActivity() {

    override fun setContentId() = R.layout.activity_search_home
    override fun bindData() {

    }

    override fun injectListener() {
       /* searchView.setOnSearchListener(object : SearchCallBack {
            override fun onSearch(search: String) {
                ToastUtil.short(search)
            }

            override fun onClear() {
                ToastUtil.short("clear")
            }

        })*/

    }

/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                searchView.search()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }*/

}
