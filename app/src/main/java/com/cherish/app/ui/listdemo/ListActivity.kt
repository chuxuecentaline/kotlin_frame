package com.cherish.app.ui.listdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cherish.app.Home.ByItemViewModel
import com.cherish.app.R
import com.cherish.common.api.ApiCreate
import com.cherish.common.api.ConfigApi
import com.cherish.common.entity.ListData
import com.cherish.common.entity.ListEntity
import com.cherish.common.room.AppDataBase
import com.cherish.common.rxJava.ApiThrowable
import com.cherish.common.rxJava.ApplyObserverTransform
import com.cherish.common.rxJava.OnRequestNext
import com.cherish.common.ui.BaseActivity
import com.cherish.common.utils.ToastUtil

class ListActivity : BaseActivity() {

    override fun setContentId()=R.layout.activity_list2

    override fun bindData() {

    }
    override fun injectListener() {

    }


}
