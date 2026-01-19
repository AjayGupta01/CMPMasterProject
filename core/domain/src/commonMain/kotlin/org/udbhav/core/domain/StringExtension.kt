package org.udbhav.core.domain

fun String.delimitAndJoin(delimiter: String, joinWith: String = ""): String =
    this.split(delimiter)
        .filter { it.isNotBlank() }
        .joinToString(joinWith)


fun String.capitalizeDelimited(delimiter: String, joinWith: String = ""): String =
    this.split(delimiter)
        .filter { it.isNotBlank() }
        .joinToString(joinWith) { part ->
            part.capitalizeWord()
        }


fun String.capitalizeWord(): String =
    this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase() else it.toString()
    }

