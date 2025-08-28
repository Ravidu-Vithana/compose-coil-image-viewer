package com.ryvk.compose.coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ryvk.asset_management.ui.theme.LightGray3
import com.ryvk.asset_management.ui.theme.TextTertiary
import androidx.compose.ui.graphics.Color
import compose.icons.FeatherIcons
import compose.icons.feathericons.Image

@Composable
fun NoImage(
    containerSize: Dp = 80.dp,
    fillMaxWidth: Boolean = false,
    iconSize: Dp = 30.dp,
    isCircular: Boolean = true
){
    var boxModifier: Modifier = Modifier
    var iconModifier: Modifier = Modifier
    val configuration = LocalConfiguration.current
    val boxHeight = configuration.screenWidthDp * 0.75
    val newIconSize = configuration.screenWidthDp * 0.25

    if(isCircular){
        boxModifier = boxModifier.clip(CircleShape)
    }
    if(fillMaxWidth){
        boxModifier = boxModifier.fillMaxWidth()
        boxModifier = boxModifier.height(boxHeight.dp)
        iconModifier = iconModifier.size(newIconSize.dp)
    }else{
        boxModifier = boxModifier.size(containerSize)
        iconModifier = iconModifier.size(iconSize)
    }
    Box(
        modifier = boxModifier
            .background(Color(0xFFF0F0F1)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = FeatherIcons.Image,
            contentDescription = "No Image",
            modifier = iconModifier,
            tint = Color(0xFF838489)
        )
    }
}