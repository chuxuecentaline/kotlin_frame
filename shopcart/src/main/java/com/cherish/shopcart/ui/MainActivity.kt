package com.cherish.shopcart.ui

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.cherish.common.recycler.MainAdapter
import com.cherish.common.recycler.OnItemClickListener
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.ToastUtil
import com.cherish.shopcart.R
import com.cherish.square.ui.MainParamsHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), OnItemClickListener<String> {
    private lateinit var mAdapter: MainAdapter
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
