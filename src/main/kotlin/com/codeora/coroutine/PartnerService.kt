package com.codeora.coroutine

import com.codeora.coroutine.parnter.PartnerSpec
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class PartnerService(
    private val partnerSpec: PartnerSpec
) {
    suspend fun getCoins(): List<Coin> {
        delay(1000)
        val coinsMap = Coin.values().associateBy { it.code }
        return partnerSpec.getCoins().map {
            coinsMap.getValue(it.code)
        }
    }

    suspend fun getCustomers(): List<Customer> {
        delay(1000)
        return partnerSpec.getCustomers().map { Customer(it.id, it.email) }
    }
}