package newapp.eduardo.com.br.newapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handle = Handler()
        handle.postDelayed(Runnable { iniciarApp() }, 2000)
    }

    private fun iniciarApp() {
        //Chamar o activity login
        val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
            //Finalizar o activity splash
            finish()
    }

}
