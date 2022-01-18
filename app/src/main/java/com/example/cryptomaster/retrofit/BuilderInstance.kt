package com.example.cryptomaster.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object BuilderInstance  {
    private val baseURL = "https://api.coinpaprika.com/v1/"

    private val myBuilder by lazy {
        Retrofit
            .Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val builderAPI by lazy {
        myBuilder.create(CryptoAPI::class.java)
    }
}