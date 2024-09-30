package io.github.mrkekovich.validators

import io.github.mrkekovich.Violation
import kotlin.reflect.KProperty

interface Validator {
    val violations: MutableList<Violation>
    val KProperty<*>.alias: String

    fun <T> KProperty<T>.validate(message: String? = null, block: T.() -> Boolean): KProperty<T> {
        if (!block(value)) {
            violation { message ?: "$alias is invalid" }
        }
        return this
    }

    fun <T> KProperty<T>.validateIf(condition: Boolean, message: String? = null, block: T.() -> Boolean): KProperty<T> {
        if (condition) validate(message, block)
        return this
    }

    fun <T> KProperty<T>.notNull(message: String = "$alias must not be null"): KProperty<T> =
        validate("must not be null") { value != null }
}
