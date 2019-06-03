package com.aurora.common.recycler

/**
 * IAdapter
 *
 * Created by aurora
 */
interface IAdapter<E> {

    fun load(temp: List<E>, refresh: Boolean = false)

    fun reload()

    fun empty()

    fun error(errorTip: String?)
}