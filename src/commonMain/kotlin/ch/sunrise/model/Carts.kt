package ch.sunrise.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Carts(
    @SerialName("carts") var carts: List<Cart> = emptyList(),
    @SerialName("total") var total: Int? = null,
    @SerialName("skip") var skip: Int? = null,
    @SerialName("limit") var limit: Int? = null
)

@Serializable
data class Cart(
    @SerialName("id") var id: Int? = null,
    @SerialName("products") var products: List<Product> = emptyList(),
    @SerialName("total") var total: Int? = null,
    @SerialName("discountedTotal") var discountedTotal: Int? = null,
    @SerialName("userId") var userId: Int? = null,
    @SerialName("totalProducts") var totalProducts: Int? = null,
    @SerialName("totalQuantity") var totalQuantity: Int? = null
)

@Serializable
data class Product(
    @SerialName("id") var id: Int? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("price") var price: Int? = null,
    @SerialName("quantity") var quantity: Int? = null,
    @SerialName("total") var total: Int? = null,
    @SerialName("discountPercentage") var discountPercentage: Double? = null,
    @SerialName("discountedPrice") var discountedPrice: Int? = null
)
