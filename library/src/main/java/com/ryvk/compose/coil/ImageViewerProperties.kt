package com.ryvk.compose.coil

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ImageViewerProperties(
    var modifier: Modifier = Modifier,
    val contentScale: ContentScale = ContentScale.Crop,
    val isCircular: Boolean = true,
    val crossFade: Boolean = true,
    val centerCrop: Boolean = true,
    val containerSize: Dp = 80.dp,
    val fallbackIconSize: Dp = 30.dp,
    val aspectRatio: Float = 4f / 3f
)