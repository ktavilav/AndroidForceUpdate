package com.example.lanzardados;

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MainActivity : Activity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 segundos
    private val versionProduccion = 10
    private val versionActual = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d("MainActivity", "Splash screen mostrado correctamente")
        if (versionActual === versionProduccion ){
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val intent = Intent(this@MainActivity, DidesActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }, SPLASH_TIME_OUT)
        } else {
            Toast.makeText(this, "Debe actualizar", Toast.LENGTH_SHORT).show()
            // Redireccionar al usuario a la tienda de aplicaciones
            val appPackageName = packageName
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
            } catch (e: android.content.ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
            }
        }
    }
}
