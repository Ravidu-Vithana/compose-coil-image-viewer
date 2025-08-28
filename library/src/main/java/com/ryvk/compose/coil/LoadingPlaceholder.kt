package com.ryvk.compose.coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun LoadingPlaceholder(
    fillMaxWidth: Boolean,
    containerSize: Dp,
    iconSize: Dp,
    isCircular: Boolean,
    backgroundColor: Color = Color.LightGray,
    progressColor: Color = Color.Gray
) {

    var boxModifier: Modifier = Modifier
    var iconModifier: Modifier = Modifier
    val configuration = LocalConfiguration.current
    val boxHeight = configuration.screenWidthDp * 0.75
    val newIconSize = configuration.screenWidthDp * 0.25

    if(isCircular){
        boxModifier = boxModifier.clip(CircleShape)
    }
    if(fillMaxWidth){
        boxModifier = boxModifier
            .fillMaxWidth()
            .height(boxHeight.dp)
        iconModifier = iconModifier
            .size(newIconSize.dp)
    }else {
        boxModifier = boxModifier.size(containerSize)
        iconModifier = iconModifier.size(iconSize)
    }

    Box(
        modifier = boxModifier
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = iconModifier,
            color = progressColor
        )
    }
}