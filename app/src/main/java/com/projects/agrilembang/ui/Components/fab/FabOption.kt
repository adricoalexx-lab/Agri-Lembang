package com.projects.agrilembang.ui.Components.fab

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Immutable
interface FabOption {
    @Stable val iconTint: Color
    @Stable val backgroundTint: Color
    @Stable val showLabel: Boolean
}

private class FabOptionImpl(
    override val iconTint: Color,
    override val backgroundTint: Color,
    override val showLabel: Boolean,
    ): FabOption

@SuppressLint("ComposableNaming")
@Composable
fun fabOption(
    backgroundTint: Color = Color(0xFF155B36),
    iconTint: Color = contentColorFor(backgroundColor = backgroundTint),
    showLabel: Boolean = true
): FabOption = FabOptionImpl(iconTint, backgroundTint, showLabel)