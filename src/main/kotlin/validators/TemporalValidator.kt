package validators

import java.time.Duration
import java.time.temporal.Temporal
import kotlin.reflect.KProperty

typealias TemporalProperty = KProperty<Temporal>

interface TemporalValidator : Validator {
    fun TemporalProperty.between(from: Temporal, to: Temporal): TemporalProperty =
        validate("must be between $from and $to") { between(from, to) }

    fun TemporalProperty.notBetween(from: Temporal, to: Temporal): TemporalProperty =
        validate("must not be between $from and $to") { !between(from, to) }

    fun TemporalProperty.after(temporal: Temporal): TemporalProperty =
        validate("must be after $temporal") { after(temporal) }

    fun TemporalProperty.notAfter(temporal: Temporal): TemporalProperty =
        validate("must not be after $temporal") { !after(temporal) }

    fun TemporalProperty.before(temporal: Temporal): TemporalProperty =
        validate("must be before $temporal") { before(temporal) }

    fun TemporalProperty.notBefore(temporal: Temporal): TemporalProperty =
        validate("must not be before $temporal") { !before(temporal) }
}

private fun Temporal.after(temporal: Temporal): Boolean =
    Duration.between(temporal, this) > Duration.ZERO

private fun Temporal.before(temporal: Temporal): Boolean =
    Duration.between(temporal, this) < Duration.ZERO

private fun Temporal.between(from: Temporal, to: Temporal): Boolean =
    Duration.between(from, this) >= Duration.ZERO
            && Duration.between(to, this) <= Duration.ZERO
