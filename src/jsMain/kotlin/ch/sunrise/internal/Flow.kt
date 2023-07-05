package ch.sunrise.internal

import ErrorJs
import IdleJs
import ResultJs
import SuccessJs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

internal fun <T> CoroutineScope.observeAsResult(
    flow: Flow<T>,
    onResult: (next: ResultJs<T>) -> Unit = {},
) {
    launch {
        flow
            .onStart {
                onResult(IdleJs())
            }
            .onEach { next ->
                onResult(SuccessJs(next))
            }
            .catch { throwable ->
                onResult(ErrorJs(throwable.message.orEmpty()))
            }
            .collect()
    }
}
