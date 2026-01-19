package extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import java.util.Locale

fun Project.getLibs(): VersionCatalog =
    extensions.findByType(VersionCatalogsExtension::class.java)?.named("libs")
        ?: error("Version catalog 'libs' not found")


//":abc:def" -> "AbcDef"
val Project.moduleName
    get() = path
        .split(":")
        .filter { it.isNotBlank() }
        .joinToString("") {
            it.capitalizeWord()
        }
//":abc:def" -> "abc.def"
val Project.modulePackageName get() = path
    .split(":")
    .filter { it.isNotBlank() }
    .joinToString(".") { it.lowercase() }


fun String.capitalizeWord(locale: Locale = Locale.getDefault()): String =
    replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(locale) else it.toString()
    }