package com.aurora.system.ui

import com.aurora.system.R
import com.aurora.common.ui.BaseActivity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_second.*
import java.util.concurrent.TimeUnit

class SecondActivity : BaseActivity() {

    override fun setContentId() = R.layout.activity_second

    override fun initConfig() {

    }
    override fun bindData() {


    }

    override fun injectListener() {
        Flowable.intervalRange(0, 100,0,1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe({
            atv_content.setText("倒计时${100-it}")
        })
    }


}
