import ch.sunrise.model.Cart
import ch.sunrise.model.Carts
import ch.sunrise.model.Product

@JsExport
@JsName("Carts")
data class CartsJs(
    var carts: Array<CartJs>,
    var total: Int? = null,
    var skip: Int? = null,
    var limit: Int? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.js != other::class.js) return false

        other as CartsJs

        if (!carts.contentEquals(other.carts)) return false
        if (total != other.total) return false
        if (skip != other.skip) return false
        if (limit != other.limit) return false

        return true
    }

    override fun hashCode(): Int {
        var result = carts.contentHashCode()
        result = 31 * result + (total ?: 0)
        result = 31 * result + (skip ?: 0)
        result = 31 * result + (limit ?: 0)
        return result
    }
}

@JsExport
@JsName("Cart")
data class CartJs(
    var id: Int? = null,
    var products: Array<ProductJs>,
    var total: Int? = null,
    var discountedTotal: Int? = null,
    var userId: Int? = null,
    var totalProducts: Int? = null,
    var totalQuantity: Int? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.js != other::class.js) return false

        other as CartJs

        if (id != other.id) return false
        if (!products.contentEquals(other.products)) return false
        if (total != other.total) return false
        if (discountedTotal != other.discountedTotal) return false
        if (userId != other.userId) return false
        if (totalProducts != other.totalProducts) return false
        if (totalQuantity != other.totalQuantity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + products.contentHashCode()
        result = 31 * result + (total ?: 0)
        result = 31 * result + (discountedTotal ?: 0)
        result = 31 * result + (userId ?: 0)
        result = 31 * result + (totalProducts ?: 0)
        result = 31 * result + (totalQuantity ?: 0)
        return result
    }
}

@JsExport
@JsName("Product")
data class ProductJs(
    var id: Int?,
    var title: String?,
    var price: Int?,
    var quantity: Int?,
    var total: Int?,
    var discountPercentage: Double?,
    var discountedPrice: Int?
)

internal fun Carts.toJs() = CartsJs(
    carts.map { it.toJs() }.toTypedArray(),
    total,
    skip,
    limit,
)

private fun Cart.toJs() = CartJs(
    id = id,
    products = products.map { it.toJs() }.toTypedArray(),
    total = total,
    discountedTotal = discountedTotal,
    userId = userId,
    totalProducts = totalProducts,
    totalQuantity = totalQuantity,
)

private fun Product.toJs() = ProductJs(
    id = id,
    title = title,
    price = price,
    quantity = quantity,
    total = total,
    discountPercentage = discountPercentage,
    discountedPrice = discountedPrice,
)
