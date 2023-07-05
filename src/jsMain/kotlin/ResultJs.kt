
@JsName("Result")
@JsExport
sealed external interface ResultJs<out T>

@JsName("Idle")
@JsExport
class IdleJs : ResultJs<Nothing>

@JsName("Success")
@JsExport
class SuccessJs<T>(val value: T) : ResultJs<T>

@JsName("Error")
@JsExport
class ErrorJs(val message: String) : ResultJs<Nothing>
