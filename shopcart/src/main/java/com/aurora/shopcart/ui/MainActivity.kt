package com.aurora.shopcart.ui

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.aurora.common.recycler.MainAdapter
import com.aurora.common.recycler.OnItemClickListener
import com.aurora.common.ui.BaseActivity
import com.aurora.common.utils.ToastUtil
import com.aurora.shopcart.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), OnItemClickListener<String> {

    private lateinit var mAdapter: MainAdapter
    override fun setContentId() = R.layout.activity_main

    override fun initConfig() {

    }

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
