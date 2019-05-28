package com.cherish.centre.ui

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.cherish.centre.R
import com.cherish.common.recycler.MainAdapter
import com.cherish.common.recycler.OnItemClickListener
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*


/**
 * @author: cherish
 * @description: 模块入口
 * @date: 2019/5/28 11:34
 * @version: 2.0
 */
class MainActivity : BaseActivity(), OnItemClickListener<String> {

    lateinit var mAdapter: MainAdapter
    override fun setContentId() = R.layout.activity_main

    override fun bindData() {
        val paramsHelper = MainParamsHelper()
        mAdapter = MainAdapter(arrayListOf())
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL))
            adapter = mAdapter
        }
        mAdapter.setData(paramsHelper.resource)

    }

    override fun injectListener() {
        mAdapter.setOnItemClickListener(this@MainActivity)

    }

    override fun onClick(position: Int, data: String) {
       ToastUtil.short(data)
    }

}
