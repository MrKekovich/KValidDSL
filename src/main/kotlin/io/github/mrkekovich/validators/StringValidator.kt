package io.github.mrkekovich.validators

import kotlin.reflect.KProperty

typealias StringProperty = KProperty<String>

interface StringValidator : Validator {
    fun StringProperty.notBlank(message: String = "$alias must not be blank"): StringProperty =
        validate(message) { isNotBlank() }

    fun StringProperty.notEmpty(message: String = "$alias must not be empty"): StringProperty =
        validate(message) { isNotEmpty() }

    fun StringProperty.length(
        min: Long,
        max: Long,
        message: String = "$alias length must in range $min..$max",
    ): StringProperty = validate(message) { length in min..max }

    fun StringProperty.length(
        range: LongRange,
        message: String = "$alias length must in range $range",
    ): StringProperty =
        validate(message) { length in range }

    fun StringProperty.length(range: IntRange, message: String = "$alias length must in range $range"): StringProperty =
        validate(message) { length in range }

    fun StringProperty.maxLength(max: Long, message: String = "$alias length must be at most $max"): StringProperty =
        validate(message) { length <= max }

    fun StringProperty.minLength(min: Long, message: String = "$alias length must be at least $min"): StringProperty =
        validate(message) { length >= min }

    fun StringProperty.matches(regex: Regex, message: String = "$alias must match $regex"): StringProperty =
        validate(message) { matches(regex) }

    fun StringProperty.notMatches(regex: Regex, message: String = "$alias must not match $regex"): StringProperty =
        validate(message) { !matches(regex) }

    fun StringProperty.isEmail(message: String = "$alias must be an email"): StringProperty =
        validate(message) { matches(EMAIL_REGEX) }

    fun StringProperty.isUrl(message: String = "$alias must be an url"): StringProperty =
        validate(message) { matches(URL_REGEX) }

    fun StringProperty.isUuid(message: String = "$alias must be an uuid"): StringProperty =
        validate(message) { matches(UUID_REGEX) }

    fun StringProperty.isIpv4(message: String = "$alias must be an ipv4"): StringProperty =
        validate(message) { matches(IPV4_REGEX) }

    fun StringProperty.isIpv6(message: String = "$alias must be an ipv6"): StringProperty =
        validate(message) { matches(IPV6_REGEX) }

    fun StringProperty.isIpAddress(message: String = "$alias must be an ip address"): StringProperty =
        validate(message) { matches(IP_ADDRESS_REGEX) }

    fun StringProperty.isMacAddress(message: String = "$alias must be an mac address"): StringProperty =
        validate(message) { matches(MAC_ADDRESS_REGEX) }

    fun StringProperty.isCreditCard(message: String = "$alias must be a credit card"): StringProperty =
        validate(message) { matches(CREDIT_CARD_REGEX) }

    fun StringProperty.isBase64(message: String = "$alias must be base64"): StringProperty =
        validate(message) { matches(BASE64_REGEX) }

    fun StringProperty.isHex(message: String = "$alias must be hex"): StringProperty =
        validate(message) { matches(HEX_REGEX) }

    fun StringProperty.isHexColor(message: String = "$alias must be hex color"): StringProperty =
        validate(message) { matches(HEX_COLOR_REGEX) }

    fun StringProperty.isAscii(message: String = "$alias must be ascii"): StringProperty =
        validate(message) { matches(ASCII_REGEX) }

    fun StringProperty.isAsciiPrintable(message: String = "$alias must be ascii printable"): StringProperty =
        validate(message) { matches(ASCII_PRINTABLE_REGEX) }

    fun StringProperty.isAlphanumeric(message: String = "$alias must be alphanumeric"): StringProperty =
        validate(message) { matches(ALPHANUMERIC_REGEX) }

    fun StringProperty.isAlphabetic(message: String = "$alias must be alphabetic"): StringProperty =
        validate(message) { matches(ALPHABETIC_REGEX) }

    fun StringProperty.isNumeric(message: String = "$alias must be numeric"): StringProperty =
        validate(message) { matches(NUMERIC_REGEX) }

    fun StringProperty.startsWith(prefix: String, message: String = "$alias must start with $prefix"): StringProperty =
        validate(message) { startsWith(prefix) }

    fun StringProperty.notStartsWith(
        prefix: String,
        message: String = "$alias must not start with $prefix",
    ): StringProperty = validate(message) { !startsWith(prefix) }

    fun StringProperty.endsWith(suffix: String, message: String = "$alias must end with $suffix"): StringProperty =
        validate(message) { endsWith(suffix) }

    fun StringProperty.notEndsWith(
        suffix: String,
        message: String = "$alias must not end with $suffix",
    ): StringProperty = validate(message) { !endsWith(suffix) }

    fun StringProperty.contains(substring: String, message: String = "$alias must contain $substring"): StringProperty =
        validate(message) { contains(substring) }

    fun StringProperty.notContains(
        substring: String,
        message: String = "$alias must not contain $substring",
    ): StringProperty = validate(message) { !contains(substring) }

    fun StringProperty.containsAny(
        vararg substrings: String,
        message: String = "$alias must contain any of $substrings",
    ): StringProperty = validate(message) { substrings.any { contains(it) } }

    fun StringProperty.notContainsAny(
        vararg substrings: String,
        message: String = "$alias must not contain any of $substrings",
    ): StringProperty = validate(message) { substrings.none { contains(it) } }

    fun StringProperty.containsAll(
        vararg substrings: String,
        message: String = "$alias must contain all of $substrings",
    ): StringProperty = validate(message) { substrings.all { contains(it) } }
}