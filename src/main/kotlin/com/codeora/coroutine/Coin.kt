package com.codeora.coroutine

enum class Coin(
    val label: String,
    val code: String,
    val sign: Char,
) {
    Bitcoin("Bitcoin", "BTC", '₿'),
    Ethereum("Ethereum", "ETH", 'Ξ')
}
