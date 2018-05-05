package newapp.eduardo.com.br.newapp.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import newapp.eduardo.com.br.newapp.Interface.LoginResultCallBacks

class LoginViewModelFactory(private val listener:LoginResultCallBacks): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) : T {
        return LoginViewModel(listener) as T
    }
}