import ch.sunrise.internal.observeAsResult
import ch.sunrise.model.CartsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsExport
@JsName("CartService")
object CartsServiceJs {

    private val cartsService = CartsService()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    fun getCartsPromise(): Promise<CartsJs> = scope.promise {
        getCartsJs().first()
    }

    fun getCarts(onResult: (carts: ResultJs<CartsJs>) -> Unit) {
        scope.observeAsResult(
            getCartsJs(),
            onResult
        )
    }

    private fun getCartsJs() = cartsService.getCarts().map { it.toJs() }
}
