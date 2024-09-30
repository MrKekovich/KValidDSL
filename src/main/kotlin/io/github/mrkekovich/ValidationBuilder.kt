package io.github.mrkekovich

import io.github.mrkekovich.validators.CollectionValidator
import io.github.mrkekovich.validators.ComparableValidator
import io.github.mrkekovich.validators.StringValidator
import io.github.mrkekovich.validators.TemporalValidator
import io.github.mrkekovich.validators.value
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation

open class ValidationBuilder :
    StringValidator, CollectionValidator, ComparableValidator, TemporalValidator {
    override val violations: MutableList<Violation> = mutableListOf()
    override val KProperty<*>.alias: String
        get() = findAnnotation<Alias>()?.value
            ?: getter.findAnnotation<Alias>()?.value
            ?: name

    infix fun <V> KProperty<V?>.ifNotNull(block: KProperty<V>.() -> Unit) {
        @Suppress("UNCHECKED_CAST")
        if (value != null) block(this as KProperty<V>)
    }

    operator fun <V> KProperty<V>.invoke(block: KProperty<V>.() -> Unit) = block()
}
