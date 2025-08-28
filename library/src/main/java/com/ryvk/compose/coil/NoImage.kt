package com.ryvk.compose.coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun NoImage(
    containerSize: Dp = 80.dp,
    iconSize: Dp = 30.dp,
    isCircular: Boolean = true,
    backgroundColor: Color = Color.LightGray,
    iconColor: Color = Color.Gray
) {
    Box(
        modifier = Modifier
            .size(containerSize)
            .let { if (isCircular) it.clip(CircleShape) else it }
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = android.R.drawable.ic_menu_report_image),
            contentDescription = "No image",
            modifier = Modifier.size(iconSize),
            tint = iconColor
        )
    }
}