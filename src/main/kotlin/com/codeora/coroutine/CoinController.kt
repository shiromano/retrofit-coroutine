package com.codeora.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoinController(
    private val partnerService: PartnerService
) {

    @GetMapping("/compound-info")
    fun getInformation(): CustomerInfo = runBlocking {
        // although there each remote call has a delay of 1s, OkHttp actually initiates two
        // calls almost at the same time, thanks to correct usage of coroutines
        val coins = async(Dispatchers.IO) {
            partnerService.getCoins()
        }
        val customers = async(Dispatchers.IO) {
            partnerService.getCustomers()
        }

        CustomerInfo(customers.await(), coins.await())
    }

}