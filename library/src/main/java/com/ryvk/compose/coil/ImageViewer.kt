package com.ryvk.compose.coil

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage

@Composable
fun ImageViewer(
    imageUrl: String,
    fillMaxWidth: Boolean = false,
    contentDescription: String? = null,
    imageViewerProperties: ImageViewerProperties = ImageViewerProperties(),
) {
    Content(
        imageSource = imageUrl,
        fillMaxWidth = fillMaxWidth,
        contentDescription = contentDescription,
        imageViewerProperties = imageViewerProperties
    )
}

@Composable
fun ImageViewer(
    imageBytes: ByteArray,
    fillMaxWidth: Boolean = false,
    contentDescription: String? = null,
    imageViewerProperties: ImageViewerProperties = ImageViewerProperties(),
) {
    Content(
        imageSource = imageBytes,
        fillMaxWidth = fillMaxWidth,
        contentDescription = contentDescription,
        imageViewerProperties = imageViewerProperties
    )
}

@Composable
private fun Content(
    imageSource: Any,
    fillMaxWidth: Boolean = false,
    contentDescription: String? = null,
    imageViewerProperties: ImageViewerProperties = ImageViewerProperties(),
){
    val modifier = if (fillMaxWidth) {
        imageViewerProperties.modifier
            .fillMaxWidth()
            .aspectRatio(imageViewerProperties.aspectRatio)
    } else {
        imageViewerProperties.modifier.size(imageViewerProperties.containerSize)
    }

    SubcomposeAsyncImage(
        model = imageSource,
        contentDescription = contentDescription,
        modifier = if (imageViewerProperties.isCircular) modifier.clip(CircleShape) else modifier,
        contentScale = imageViewerProperties.contentScale,
    ) {
        val state = painter.state

        Crossfade (
            targetState = state,
            animationSpec = if (imageViewerProperties.crossFade) {
                tween(durationMillis = imageViewerProperties.crossFadeDuration)
            } else {
                tween(durationMillis = 0)
            },
            label = "image_crossfade"
        ) { currentState ->
            when (currentState) {
                is AsyncImagePainter.State.Loading -> {
                    LoadingPlaceholder(
                        fillMaxWidth = fillMaxWidth,
                        containerSize = imageViewerProperties.containerSize,
                        iconSize = imageViewerProperties.fallbackIconSize,
                        isCircular = imageViewerProperties.isCircular,
                    )
                }
                is AsyncImagePainter.State.Error -> {
                    NoImage(
                        containerSize = imageViewerProperties.containerSize,
                        iconSize = imageViewerProperties.fallbackIconSize,
                        isCircular = imageViewerProperties.isCircular
                    )
                }
                else -> {
                    Image(
                        painter = painter,
                        contentDescription = contentDescription,
                        contentScale = imageViewerProperties.contentScale,
                    )
                }
            }
        }
    }
}