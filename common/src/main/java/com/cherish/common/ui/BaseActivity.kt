package com.cherish.common.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.cherish.common.R
import com.jaeger.library.StatusBarUtil
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    /**
     * 管理订阅
     */
    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isPortrait()) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        setContentView(setContentId())
        bindData()
        injectListener()
    }

    /**
     * 是否竖屏
     */
    private fun isPortrait() = true

    /**
     * 布局
     */
    abstract fun setContentId(): Int

    /**
     * 绑定数据
     */
    abstract fun bindData()

    /**
     * 事件监听
     */
    abstract fun injectListener()

    /**
     * 管理订阅
     */
    protected fun compositeDisposable() = compositeDisposable

    companion object {
        val mContext = this


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    /**
     * 无参
     */
    fun launchActivity(clazz: Class<out Activity>) {
        val intent = Intent(this, clazz)
        startActivity(intent)

    }

    /**
     * 有参
     */
    fun launchActivity(clazz: Class<out Activity>, bundle: Bundle) {
        val intent = Intent(this, clazz)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    /**
     *  获取 Drawable 资源
     */
    fun getDrawableCompat(res: Int): Drawable? {
        return ContextCompat.getDrawable(this, res)
    }

    /**
     * 软键盘开启、关闭
     */
    protected fun controlKeyboard(isShow: Boolean) {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
            if (isShow) {
                if (currentFocus!= null) {
                    //有焦点打开
                    imm.showSoftInput(currentFocus, 0)
                } else {
                    //无焦点打开
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                }
            } else {
                if (currentFocus != null) {
                    //有焦点关闭
                    imm.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                } else {
                    //无焦点关闭
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


}
