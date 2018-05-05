package newapp.eduardo.com.br.newapp.View


import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import android.content.Context

import android.databinding.DataBindingUtil
import android.graphics.Rect
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import es.dmoral.toasty.Toasty

import newapp.eduardo.com.br.newapp.R
import newapp.eduardo.com.br.newapp.ViewModel.LoginViewModel
import newapp.eduardo.com.br.newapp.ViewModel.LoginViewModelFactory

import newapp.eduardo.com.br.newapp.Interface.LoginResultCallBacks
import newapp.eduardo.com.br.newapp.databinding.ActivityLoginBinding

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT)
                .show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT)
                .show()
    }

    /**
     * Função para ocultar o teclado quando ele ficar fora do foco do EditText
     */
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            var v = currentFocus
            if (v is EditText) {
                var outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val inputManager:InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        activityLoginBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)
    }

}

