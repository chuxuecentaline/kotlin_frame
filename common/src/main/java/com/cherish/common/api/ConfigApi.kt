package com.cherish.common.api

import com.cherish.common.entity.HomeEntity
import com.cherish.common.entity.ListEntity
import com.cherish.common.entity.ResponseEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author: cherish
 * @description: 配置
 * @date: 2019/5/7 13:06
 * @version: 2.0
 */
interface ConfigApi {
    @Headers(RequestHeader.HEADER_PAGING)
    @GET("users")
    fun getGithubAccount(@Query("since") id: Long, @Query("per_page") perPage: Int):
            Observable<ResponseEntity<List<HomeEntity>>>


    @GET("front/businessProduct/quantum/{page}/{size}")
    fun getList(@Path("page")page: Int , @Path("size") size:Int , @Query("productClassId") productClassId: String):
            Observable<ResponseEntity<ListEntity>>
}