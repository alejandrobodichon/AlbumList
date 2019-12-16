package org.falabella.android.lia.ui.root

import android.content.Intent
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.core.content.ContextCompat
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.example.albumlistapplication.R
import com.example.albumlistapplication.ui.main.MainActivity
import javax.inject.Inject


class RootActivity : WolmoActivity() {

    @Inject lateinit var toastFactory: ToastFactory
    @Inject lateinit var retrofitServices: RetrofitServices
    override fun init() {

        changeStatusBarColor()

        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                goToAlbumsList()
            }
        }.start()
    }

    private fun goToAlbumsList(){
        startActivity( Intent(this, MainActivity::class.java).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK) })
    }

    override fun layout(): Int { return R.layout.activity_root
    }

    private fun changeStatusBarColor(){

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black_mediamonks)
    }
}
