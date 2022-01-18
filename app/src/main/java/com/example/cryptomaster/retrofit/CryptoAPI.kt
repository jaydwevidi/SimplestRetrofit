package com.example.cryptomaster.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface CryptoAPI {

    @GET("coins")
    suspend fun getCrypto() : Response<CryptoList>
}