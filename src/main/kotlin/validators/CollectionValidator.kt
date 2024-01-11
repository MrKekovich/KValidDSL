package validators

import kotlin.reflect.KProperty

typealias CollectionProperty<T> = KProperty<Collection<T>>

interface CollectionValidator : Validator {
    fun <T> CollectionProperty<T>.empty(): CollectionProperty<T> =
        validate("must be empty") { isEmpty() }

    fun <T> CollectionProperty<T>.notEmpty(): CollectionProperty<T> =
        validate("must not be empty") { !isEmpty() }

    fun <T> CollectionProperty<T>.hasSize(size: Int): CollectionProperty<T> =
        validate("must have size $size") { this.size == size }

    fun <T> CollectionProperty<T>.notHasSize(size: Int): CollectionProperty<T> =
        validate("must not have size $size") { this.size != size }

    fun <T> CollectionProperty<T>.hasSizeBetween(min: Int, max: Int): CollectionProperty<T> =
        validate("must have size between $min and $max") { size in min..max }

    fun <T> CollectionProperty<T>.notHasSizeBetween(min: Int, max: Int): CollectionProperty<T> =
        validate("must not have size between $min and $max") { size !in min..max }

    fun <T> CollectionProperty<T>.minSize(min: Int): CollectionProperty<T> =
        validate("must have at least $min elements") { size >= min }

    fun <T> CollectionProperty<T>.maxSize(max: Int): CollectionProperty<T> =
        validate("must have at most $max elements") { size <= max }

    fun <T> CollectionProperty<T>.contains(element: T): CollectionProperty<T> =
        validate("must contain $element") { contains(element) }

    fun <T> CollectionProperty<T>.notContains(element: T): CollectionProperty<T> =
        validate("must not contain $element") { !contains(element) }

    fun <T> CollectionProperty<T>.containsAll(elements: Collection<T>): CollectionProperty<T> =
        validate("must contain all $elements") { containsAll(elements) }

    fun <T> CollectionProperty<T>.notContainsAll(elements: Collection<T>): CollectionProperty<T> =
        validate("must not contain all $elements") { !containsAll(elements) }

    fun <T> CollectionProperty<T>.any(predicate: (T) -> Boolean): CollectionProperty<T> =
        validate("must contain at least one element matching $predicate") { any(predicate) }

    fun <T> CollectionProperty<T>.none(predicate: (T) -> Boolean): CollectionProperty<T> =
        validate("must not contain any element matching $predicate") { none(predicate) }

    fun <T> CollectionProperty<T>.all(predicate: (T) -> Boolean): CollectionProperty<T> =
        validate("must contain all elements matching $predicate") { all(predicate) }
}