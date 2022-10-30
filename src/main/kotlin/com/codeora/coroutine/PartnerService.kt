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
        return partnerSpec.getCoins().map {
            coinsMap.getValue(it.code)
        }.also {
            logger.info("got coins")
        }
    }

    suspend fun getCustomers(): List<Customer> {
        logger.info("start getting customers")
        delay(1000)
        return partnerSpec.getCustomers().map { Customer(it.id, it.email) }
            .also { "got customers" }
    }
}