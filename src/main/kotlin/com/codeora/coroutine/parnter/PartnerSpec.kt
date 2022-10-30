package com.codeora.coroutine.parnter

import retrofit2.Response
import retrofit2.http.GET

interface PartnerSpec {
    @GET("coins")
    suspend fun getCoins(): Response<List<CoinResp>>
    @GET("customers")
    suspend fun getCustomers(): Response<List<CustomerResp>>
}