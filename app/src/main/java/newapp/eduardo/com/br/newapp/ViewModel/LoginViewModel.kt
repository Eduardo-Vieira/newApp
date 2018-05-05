package newapp.eduardo.com.br.newapp.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import newapp.eduardo.com.br.newapp.Model.User
import newapp.eduardo.com.br.newapp.Interface.LoginResultCallBacks

class LoginViewModel (private val listener:LoginResultCallBacks): ViewModel(){
    private val user:User

    init {
        this.user = User(email = "", password = "")
    }

    //Criar função para definir o E-mail após o usuário terminar a inserção de texto
    val emailTextWatcher:TextWatcher
        get() = object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }

    //Criar função para definir o Password após o usuário terminar a inserção de texto
    val passwordTextWatcher:TextWatcher
        get() = object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    //Criar função para processar o botão Login clicado
    fun onLoginClicked(v:View){
        if(user.isDataValid){
            listener.onSuccess("Login Success!")
        }else{
            listener.onError("Login Error")
        }
    }
}