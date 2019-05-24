package com.cherish.common.entity

import com.squareup.moshi.JsonClass

/**
 * @author: cherish
 * @description: 测试
 * @date: 2019/5/8 14:21
 * @version: 2.0
 */
@JsonClass(generateAdapter = true)
data class HomeEntity(val avatar_url: String,
                      val events_url: String,
                      val followers_url: String,
                      val following_url: String,
                      val gists_url: String,
                      val gravatar_id: String,
                      val html_url: String,
                      val login: String,
                      val node_id: String,
                      val organizations_url: String,
                      val received_events_url: String,
                      val repos_url: String,
                      val site_admin: Boolean,
                      val starred_url: String,
                      val subscriptions_url: String,
                      val type: String,
                      val url: String) : BaseEntity()