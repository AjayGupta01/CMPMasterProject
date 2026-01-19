package org.udbhav.core.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection

fun Modifier.excludeTopPadding(
    paddingValues: PaddingValues,
    layoutDirection: LayoutDirection
): Modifier = this.padding(
    PaddingValues(
        start = paddingValues.calculateStartPadding(layoutDirection),
        end = paddingValues.calculateEndPadding(layoutDirection),
        bottom = paddingValues.calculateBottomPadding()
    )
)

fun Modifier.onlyIncludeTopPadding(paddingValues: PaddingValues): Modifier {
    return this.padding(
        PaddingValues(
            top = paddingValues.calculateTopPadding()
        )
    )
}
