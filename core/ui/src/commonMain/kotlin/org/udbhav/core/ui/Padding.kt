package org.udbhav.core.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * A standardized set of padding values used across the UI.
 *
 * Use this to apply consistent spacing (e.g., `tiny`, `normal`, `large`) throughout your composables.
 *
 * You can override the default padding values using [CompositionLocalProvider] with [LocalPadding].
 *
 * Example:
 * ```
 * @Composable
 * fun MyScreen() {
 *     CompositionLocalProvider(LocalPadding provides Padding(large = 48.dp)) {
 *         val padding = LocalPadding.current
 *         Button(
 *             onClick = {},
 *             modifier = Modifier.padding(padding.large)
 *         ) {
 *             Text("Click Me")
 *         }
 *     }
 * }
 * ```
 *
 * @param tiny Smallest padding, typically for compact UI elements
 * @param small Slightly larger than tiny, useful for subtle spacing
 * @param normal Default padding size for most components
 * @param big Larger spacing for structural separation
 * @param large Largest spacing for major layout separation
 */
data class Padding(
    val tiny: Dp = 8.dp,
    val small: Dp = 12.dp,
    val normal: Dp = 16.dp,
    val big: Dp = 20.dp,
    val large: Dp = 24.dp,
)


val LocalPadding = compositionLocalOf { Padding() }




