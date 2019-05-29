package com.cherish.common.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cherish.common.R
import com.cherish.common.utils.ToastUtil
import com.cherish.common.widget.dialog.LottieDialogFragment
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import java.util.function.Consumer

abstract class BaseActivity : AppCompatActivity() {

    private val lottieDialogFragment: LottieDialogFragment by lazy {
        LottieDialogFragment()
    }

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
        initConfig()
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
    @LayoutRes
    abstract fun setContentId(): Int

    /**
     * view 配置
     */
    abstract fun initConfig()

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
                if (currentFocus != null) {
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

    /**
     * 是否还在执行
     */
    protected fun isLoading() = lottieDialogFragment.isVisible

    /**
     * cancelable 点击外部是否消失
     */
    protected fun loadingDialog(cancelable: Boolean = true) {
        lottieDialogFragment.apply {
            isCancelable = cancelable
            show(supportFragmentManager, LottieDialogFragment.TAG)
        }
    }

    fun dismissDialog() {
        lottieDialogFragment.dismiss()
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
     * 拨打电话
     */
    fun callPhone(phone:String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            RxPermissions(this@BaseActivity).request(Manifest.permission.CALL_PHONE).observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if(it){
                            call(phone)
                        }else{
                            ToastUtil.short(getString(R.string.noPermission_call))
                        }
                    }
        }

    }

    private fun call(phone:String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse(String.format(Locale
                .CHINESE, "tel:%s", phone)))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
