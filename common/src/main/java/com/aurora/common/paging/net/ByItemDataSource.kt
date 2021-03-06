package com.aurora.system.Home

import androidx.paging.ItemKeyedDataSource
import com.aurora.common.api.ApiCreate
import com.aurora.common.api.ConfigApi
import com.aurora.common.entity.HomeEntity
import com.aurora.common.rxJava.ApiThrowable
import com.aurora.common.rxJava.ApplyObserverTransform
import com.aurora.common.rxJava.OnRequestNext
import io.reactivex.disposables.CompositeDisposable

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/8 16:07
 * @version: 2.0
 */
class ByItemDataSource(val compositeDisposable: CompositeDisposable) : ItemKeyedDataSource<Long, HomeEntity>() {
    private val mGitHubService by lazy {
        ApiCreate.create(ConfigApi::class.java)
    }

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<HomeEntity>) {
        mGitHubService.getGithubAccount(0, params.requestedLoadSize)
                .compose(ApplyObserverTransform.compose())
                .subscribe(object : OnRequestNext<List<HomeEntity>>(compositeDisposable) {
                    override fun success(it: List<HomeEntity>) {
                        it?.let { it1 -> callback.onResult(it1) }
                    }

                    override fun fail(apiThrowable: ApiThrowable) {

                    }


                })

    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<HomeEntity>) {
        mGitHubService.getGithubAccount(params.key, params.requestedLoadSize)
                .compose(ApplyObserverTransform.compose())
                .subscribe(object : OnRequestNext<List<HomeEntity>>(compositeDisposable) {
                    override fun success(it: List<HomeEntity>) {
                        it?.let { it1 -> callback.onResult(it1) }
                    }

                    override fun fail(apiThrowable: ApiThrowable) {

                    }

                })

    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<HomeEntity>) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: HomeEntity): Long = item.id!!.toLong()
}


