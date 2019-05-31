package com.cherish.app.ui.search

import android.view.Menu
import android.view.MenuItem
import com.cherish.app.R
import com.cherish.common.recycler.OnMenuItemClickListener
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.ToastUtil
import com.cherish.common.widget.applyToolBar
import com.cherish.common.widget.drop.CommitCallback
import com.cherish.common.widget.drop.singlemenu.SimpleMenuView
import com.cherish.common.widget.view.search.SearchCallBack
import kotlinx.android.synthetic.main.activity_search_home.*
import kotlinx.android.synthetic.main.activity_search_home.view.*

/**
 * @author: cherish
 * @description: 搜索主页
 * @date: 2019/5/29 9:20
 * @version: 2.0
 */
class SearchHomeActivity : BaseActivity() {

    override fun setContentId() = R.layout.activity_search_home

    override fun initConfig() {
        applyToolBar()
        menu_tab.initAdapter(4, object : OnMenuItemClickListener {
            override fun onclick(position: Int) {
                when (position) {
                    0 -> {
                        drop_menu.operator(0)
                    }
                    2, 3 -> {

                    }
                    else->{
                     //   drop_menu.operator(2)
                    }
                }
            }

        })
        menu_tab.appTitles(SearchParamsHelper().resource)
        val menuView = SimpleMenuView(this)
        menuView.apply {
            initAdapter()
            loadData(SearchParamsHelper().list)
            setCommitCallback(object :CommitCallback{
                override fun commit(id: Int) {
                  //todo 请求相关接口
                }

            })
        }
        drop_menu.addChild(0,menuView)
    }

    override fun bindData() {

    }

    override fun injectListener() {
        /**
         * search
         */
        searchView.setOnSearchListener(object : SearchCallBack {
            override fun onSearch(search: String) {
                ToastUtil.short(search)
            }

            override fun onClear() {
                controlKeyboard(false)
                ToastUtil.short("clear")
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                searchView.search()
                controlKeyboard(false)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
