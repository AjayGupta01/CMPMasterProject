package org.udbhav.core.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A standardized set of dimensions for views, icons, and layout widths.
 *
 * Use this to ensure consistent sizing for components like buttons, icons, or containers throughout the app.
 *
 * You can override the default dimension values using [CompositionLocalProvider] with [LocalDimension].
 *
 * Example:
 * ```
 * @Composable
 * fun MyScreen() {
 *     CompositionLocalProvider(LocalDimension provides Dimensions(viewNormal = 80.dp)) {
 *         val dimensions = LocalDimension.current
 *         Button(
 *             onClick = {},
 *             modifier = Modifier.height(dimensions.viewNormal)
 *         ) {
 *             Icon(
 *                 imageVector = Icons.Default.Home,
 *                 contentDescription = null,
 *                 modifier = Modifier.size(dimensions.iconSmall)
 *             )
 *             Text("Home")
 *         }
 *     }
 * }
 * ```
 *
 * @param viewTiny Height for very small views like chips or tight list items.
 * @param viewSmall Height for compact buttons or small cards.
 * @param viewNormal Standard height for regular buttons or inputs.
 * @param viewBig Slightly larger view height for emphasis or spacious layouts.
 * @param viewLarge Large height for prominent UI sections.
 * @param iconTiny Tiny icon size for badges or labels.
 * @param iconSmall Small icon size for buttons or tight layouts.
 * @param iconNormal Standard icon size.
 * @param iconBig Larger icon for emphasis.
 * @param iconLarge Largest icon size, often used in headers or splash areas.
 * @param maxWidthSmall Suggested maximum width for constrained elements like dialogs or cards.
 */
data class Dimensions(
    val viewTiny: Dp = 40.dp,
    val viewSmall: Dp = 48.dp,
    val viewNormal: Dp = 56.dp,
    val viewBig: Dp = 64.dp,
    val viewLarge: Dp = 72.dp,
    val iconTiny: Dp = 16.dp,
    val iconSmall: Dp = 20.dp,
    val iconNormal: Dp = 24.dp,
    val iconBig: Dp = 28.dp,
    val iconLarge: Dp = 32.dp,
    val maxWidthSmall: Dp = 300.dp,
)


val LocalDimension = compositionLocalOf { Dimensions() }