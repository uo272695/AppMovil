package com.example.appmovil

import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.appmovil.databinding.ActivityMainBinding
import domain.SitiosViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var toast:Toast
    val model: SitiosViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.comprobar->{
                if(isOnline()){
                    Toast.makeText(applicationContext, "Dispositivo conectado a la red", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(
                        applicationContext,
                        "Dispositivo NO conectado a la red",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline():Boolean {
        val connectivityManager = getSystemService(ConnectivityManager::class.java)
        val currentNetwork = connectivityManager.activeNetwork
        if (currentNetwork != null)
            return true
        return false
    }
}