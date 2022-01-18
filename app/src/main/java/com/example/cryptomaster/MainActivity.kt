package com.example.cryptomaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.cryptomaster.retrofit.BuilderInstance
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycleScope.launchWhenCreated {
            val response = try {
                BuilderInstance.builderAPI.getCrypto()
            }catch (e : Exception){
                Log.e(TAG, "onCreate: Some Exception")
                return@launchWhenCreated
            }
            if(response.isSuccessful){
                Log.e(TAG, "response : ${response.body()}")
            }
        }



    }
}