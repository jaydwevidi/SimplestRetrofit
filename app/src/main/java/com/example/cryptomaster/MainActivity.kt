package com.example.cryptomaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptomaster.databinding.ActivityMainBinding
import com.example.cryptomaster.recyclerView.MyRvAdapter
import com.example.cryptomaster.retrofit.BuilderInstance
import com.example.cryptomaster.retrofit.CryptoList
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMain.text = "haha ad"
        var dataset : CryptoList = CryptoList()

        lifecycleScope.launchWhenCreated {
            val response = try {
                BuilderInstance.builderAPI.getCrypto()
            }catch (e : Exception){
                Log.e(TAG, "onCreate: Some Exception")
                return@launchWhenCreated
            }
            if(response.isSuccessful){
                Log.e(TAG, "response : ${response.body()}")
                dataset = response.body()!!

                binding.myRv.apply {
                    adapter = MyRvAdapter(response.body()!!)
                    layoutManager = LinearLayoutManager( context , LinearLayoutManager.VERTICAL , false)
                }
            }
        }





    }
}