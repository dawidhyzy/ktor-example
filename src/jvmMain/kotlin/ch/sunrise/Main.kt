package ch.sunrise

import ch.sunrise.model.CartsService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val cartsService = CartsService()
    val cart = cartsService.getCarts().first()
    println("Carts: $cart")
}
