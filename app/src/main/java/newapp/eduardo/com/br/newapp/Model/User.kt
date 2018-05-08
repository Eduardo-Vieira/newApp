package newapp.eduardo.com.br.newapp.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var email:String, private var password:String): BaseObservable() {
    val isDataValid: Boolean
    get() = (!TextUtils.isEmpty(getEmail()))
            && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
            && getPassword().length >= 6 //Comprimento padão da senha

    fun getPassword(): String {
        return password
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }

}

