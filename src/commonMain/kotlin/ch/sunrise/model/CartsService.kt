package ch.sunrise.model

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class CartsService {

    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(json)
        }
    }

    fun getCarts(): Flow<Carts> = flow {
        val carts: Carts = httpClient.get("https://dummyjson.com/carts").body()
        emit(carts)
    }
}
