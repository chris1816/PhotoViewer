package com.example.photoviewer.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.photoviewer.R
import kotlinx.android.synthetic.main.activity_startup.*

class StartupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade)
        iv_Splash.startAnimation(animation)

        val thread = object : Thread() {
            override fun run() {
                super.run()
                try {
                    Thread.sleep(4000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                val intent = Intent(this@StartupActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        thread.start()
    }
}
