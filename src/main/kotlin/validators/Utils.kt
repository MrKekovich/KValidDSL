package validators

import ValidationBuilder
import Violation
import kotlin.reflect.KProperty

fun Validator.violation(message: () -> String) {
    violations.add(Violation(message()))
}

fun validateAll(block: ValidationBuilder.() -> Unit): MutableList<Violation> =
    ValidationBuilder().apply(block).violations

fun <T : ValidationBuilder> validateAll(validator: T, block: T.() -> Unit): MutableList<Violation> =
    validator.apply(block).violations

val <T> KProperty<T>.value: T
    get() = runCatching { getter.call() }.getOrElse {
        throw RuntimeException("Cannot get value of $name. Please use \"instance::$name\"")
    }

