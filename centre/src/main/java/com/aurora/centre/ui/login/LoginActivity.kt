package com.aurora.centre.ui.login

import android.app.Activity
import android.content.Intent

import androidx.lifecycle.ViewModelProviders
import androidx.annotation.StringRes
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route

import com.aurora.centre.R
import com.aurora.common.spreadfun.afterTextChanged
import com.aurora.common.ui.BaseActivity
import com.aurora.common.utils.IntentExtra
import com.aurora.common.utils.SharePreUtils
import com.aurora.common.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = IntentExtra.Arouter.LOGIN)
class LoginActivity : BaseActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun setContentId() = R.layout.activity_login

    override fun initConfig() {

    }
    override fun bindData() {
        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory())
                .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer
            dismissDialog()
            SharePreUtils.put(IntentExtra.SP.LOGIN_STATUS,true)
            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            var intent = Intent()
            intent.putExtra(IntentExtra.SUCCESS,"login Success")
            setResult(Activity.RESULT_OK, intent)
            //Complete and destroy login activity once successful
            finish()
        })
    }

    override fun injectListener() {
        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                        username.text.toString(),
                        password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                                username.text.toString(),
                                password.text.toString()
                        )
                }
                false
            }

            login.setOnClickListener {
                loading.visibility = View.VISIBLE
                loadingDialog()
                loginViewModel.login(username.text.toString(), password.text.toString())
            }
        }
    }


    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        ToastUtil.long("$welcome $displayName")
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

