package com.codeora.coroutine

import com.codeora.coroutine.parnter.PartnerSpec
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class PartnerService(
    private val partnerSpec: PartnerSpec
): Logging {
    suspend fun getCoins(): List<Coin> {
        logger.info("start getting coins")
        delay(1000)
        val coinsMap = Coin.values().associateBy { it.code }
        val response =  partnerSpec.getCoins()
        val result = if (response.isSuccessful) {
            response.body()?.map { coinsMap.getValue(it.code) } ?: emptyList()
        } else emptyList()
        logger.info("got coins")
        return result
    }

    suspend fun getCustomers(): List<Customer> {
        logger.info("start getting customers")
        delay(1000)
        val response = partnerSpec.getCustomers()
        val result = if(response.isSuccessful) {
            response.body()?.map {  Customer(it.id, it.email) } ?: emptyList()
        } else emptyList()
        logger.info("got customers")
        return result
    }
}