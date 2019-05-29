package com.cherish.app.ui.listdemo

import androidx.lifecycle.MutableLiveData
import com.cherish.common.api.ApiCreate
import com.cherish.common.api.ConfigApi
import com.cherish.common.entity.ListData
import com.cherish.common.entity.ListEntity
import com.cherish.common.rxJava.ApiThrowable
import com.cherish.common.rxJava.ApplyObserverTransform
import com.cherish.common.rxJava.OnRequestNext
import com.cherish.common.ui.BaseViewModel

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/17 11:56
 * @version: 2.0
 */
class ListViewModel : BaseViewModel() {

    private var mList = MutableLiveData<List<ListData>>()
    private var error= MutableLiveData<String>()
    private val mGitHubService by lazy {
        ApiCreate.create(ConfigApi::class.java)
    }

    fun getList(index: Int): MutableLiveData<List<ListData>> {
        list(index)
        return mList
    }

    private fun list(index: Int) {
        mGitHubService.getList(index, 20, "999").compose(ApplyObserverTransform.compose())
                .subscribe(object : OnRequestNext<ListEntity>(compositeDisposable()) {
                    override fun success(t: ListEntity) {
                        mList.postValue(t.list)
                    }

                    override fun fail(apiThrowable: ApiThrowable) {
                        error.value = apiThrowable.message
                    }

                })
    }

    open fun getError(): MutableLiveData<String> {
        error = MutableLiveData()
        return error
    }


}