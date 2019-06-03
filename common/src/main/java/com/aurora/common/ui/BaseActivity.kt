package com.aurora.common.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aurora.common.R
import com.aurora.common.utils.ToastUtil
import com.aurora.common.widget.dialog.LottieDialogFragment
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.*

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
    fun callPhone(phone: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            RxPermissions(this@BaseActivity).request(Manifest.permission.CALL_PHONE).observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if (it) {
                            call(phone)
                        } else {
                            ToastUtil.short(getString(R.string.noPermission_call))
                        }
                    }
        }

    }

    private fun call(phone: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse(String.format(Locale
                .CHINESE, "tel:%s", phone)))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
