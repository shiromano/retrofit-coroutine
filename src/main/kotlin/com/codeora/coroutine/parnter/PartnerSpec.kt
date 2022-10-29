package com.codeora.coroutine.parnter

import retrofit2.http.GET

interface PartnerSpec {
    @GET("coins")
    suspend fun getCoins(): List<CoinResp>
    @GET("customers")
    suspend fun getCustomers(): List<CustomerResp>
}