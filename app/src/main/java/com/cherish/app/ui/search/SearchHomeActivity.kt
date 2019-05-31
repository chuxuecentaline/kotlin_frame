package com.cherish.app.ui.search

import android.view.Menu
import android.view.MenuItem
import com.cherish.app.R
import com.cherish.common.recycler.OnMenuItemClickListener
import com.cherish.common.spreadfun.applyToolBar
import com.cherish.common.spreadfun.controlKeyboard
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.ToastUtil
import com.cherish.common.widget.drop.MenuEntity
import com.cherish.common.widget.drop.OnHideCallback
import com.cherish.common.widget.drop.singlemenu.OnResultCallback
import com.cherish.common.widget.drop.singlemenu.Price.OnPriceResultCallback
import com.cherish.common.widget.drop.singlemenu.Price.PriceMenuView
import com.cherish.common.widget.drop.singlemenu.SimpleMenuView
import com.cherish.common.widget.drop.singlemenu.category.CategoryMoreView
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
        applyMenu()
    }

    /**
     * 初始化筛选菜单
     */
    private fun applyMenu() {

        val menuView = SimpleMenuView(this)
        menuView.initAdapter(object : OnResultCallback {
            override fun result(entity: MenuEntity) {
                menu_tab.applyTitle(0, entity.title)
                //todo 接口请求
                ToastUtil.short("点击${entity.id}")
            }

        })
        menuView.apply {
            loadData(SearchParamsHelper().list)
        }
        val categoryMoreView = CategoryMoreView(this)
        categoryMoreView.apply {
            initConfig()
            loadData(SearchParamsHelper().more)
            create().compose(bindToDestroy()).subscribe {
                ToastUtil.short("点击$it")
            }
        }

        val priceMenuView = PriceMenuView(this)
        priceMenuView.apply {
            initConfig()
            setOnResultCallback(object : OnPriceResultCallback {
                override fun result(minPrice: String, maxPrice: String) {
                    //todo 接口请求
                    ToastUtil.short("$minPrice - $maxPrice")
                    controlKeyboard(false)
                }


            })
        }

        drop_menu.apply {
            addChild(0, menuView)
            addChild(1, categoryMoreView)
            addChild(2, priceMenuView)
            hideKeyboard(object : OnHideCallback {
                override fun hide() {
                    controlKeyboard(false)
                }
            })
        }

        menu_tab.initAdapter(4, object : OnMenuItemClickListener {
            override fun onclick(position: Int) {
                when (position) {
                    0, 1 -> {
                        drop_menu?.operator(position)
                    }
                    2 -> {
                        drop_menu?.commit()
                    }
                    else -> {
                        drop_menu?.operator(2)
                    }
                }
            }

        })
        menu_tab.applyTitles(SearchParamsHelper().resource)

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
