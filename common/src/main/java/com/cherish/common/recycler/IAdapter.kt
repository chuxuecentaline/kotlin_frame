package com.cherish.common.recycler

/**
 * IAdapter
 *
 * Created by cherish
 */
interface IAdapter<E> {

    fun load(temp: List<E>, refresh: Boolean = false)

    fun reload()

    fun empty()

    fun error(errorTip: String?)
}