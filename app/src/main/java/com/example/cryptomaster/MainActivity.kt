package com.example.cryptomaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.cryptomaster.databinding.ActivityMainBinding
import com.example.cryptomaster.retrofit.BuilderInstance
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMain.text = "haha asd"

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