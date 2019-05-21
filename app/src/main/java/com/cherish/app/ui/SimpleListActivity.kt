package com.cherish.app.ui

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cherish.app.Home.ByItemViewModel
import com.cherish.app.Home.HomeAdapter
import com.cherish.app.R
import com.cherish.common.entity.HomeEntity
import com.cherish.common.recycler.OnItemClickListener
import com.cherish.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_list.*
class SimpleListActivity : BaseActivity() {

    private lateinit var mAdapter: HomeAdapter
    private lateinit var mByItemViewModel: ByItemViewModel

    override fun setContentId() = R.layout.activity_list

    override fun bindData() {
        mByItemViewModel = ViewModelProviders.of(this).get(ByItemViewModel::class.java)
        mAdapter = HomeAdapter()
        recyclerView.adapter = mAdapter
        mByItemViewModel.accounts.observe(this, Observer(mAdapter::submitList))
    }

    override fun injectListener() {
        mAdapter.setOnItemClickListener(object : OnItemClickListener<HomeEntity> {
            override fun onClick(position: Int, data: HomeEntity) {
                startActivity(Intent(this@SimpleListActivity, SecondActivity::class.java))
            }

        })

    }

}
