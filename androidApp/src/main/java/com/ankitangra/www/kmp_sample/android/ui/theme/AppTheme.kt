package com.ankitangra.www.kmp_sample.android.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define your light color palette
private val LightColorPalette = ColorScheme(
    primary = Color(0xFFD52B1E),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFCDD2),
    onPrimaryContainer = Color(0xFF49000A),
    inversePrimary = Color(0xFFFF9A9E),
    secondary = Color(0xFFFF7043),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFFCCBC),
    onSecondaryContainer = Color(0xFF5D0015),
    tertiary = Color(0xFFFFCC80),
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFFFFE0B2),
    onTertiaryContainer = Color(0xFF4F2B06),
    background = Color(0xFFF5F5F5),
    onBackground = Color(0xFF000000),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),
    surfaceVariant = Color(0xFFE0E0E0),
    onSurfaceVariant = Color(0xFF000000),
    surfaceTint = Color(0xFFD52B1E),
    inverseSurface = Color(0xFF303030),
    inverseOnSurface = Color(0xFFFFFFFF),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF370007),
    outline = Color(0xFF757575),
    outlineVariant = Color(0xFFBDBDBD),
    scrim = Color(0xFF000000),
)


@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    val colors = LightColorPalette
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}