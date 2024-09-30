package io.github.mrkekovich.validators

import kotlin.reflect.KProperty

typealias ComparableProperty<T> = KProperty<Comparable<T>>

interface ComparableValidator : Validator {
    fun <T : Comparable<T>> ComparableProperty<T>.equalTo(value: T): ComparableProperty<T> =
        validate("$alias must be equal to $value") { this == value }

    fun <T : Comparable<T>> ComparableProperty<T>.notEqualTo(value: T): ComparableProperty<T> =
        validate("$alias must not be equal to $value") { this != value }

    fun <T : Comparable<T>> ComparableProperty<T>.greaterThan(min: T): ComparableProperty<T> =
        validate("$alias must be greater than $min") { this > min }

    fun <T : Comparable<T>> ComparableProperty<T>.greaterThanOrEqualTo(min: T): ComparableProperty<T> =
        validate("$alias must be greater than or equal to $min") { this >= min }

    fun <T : Comparable<T>> ComparableProperty<T>.lessThan(max: T): ComparableProperty<T> =
        validate("$alias must be less than $max") { this < max }

    fun <T : Comparable<T>> ComparableProperty<T>.lessThanOrEqualTo(max: T): ComparableProperty<T> =
        validate("$alias must be less than or equal to $max") { this <= max }
}