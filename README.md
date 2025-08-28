# Compose Coil Image Viewer

A custom Jetpack Compose image component with Coil for efficient image loading and state management.

## Features
- ✅ Image loading with Coil from URL or byte array
- ✅ Loading state with progress indicator
- ✅ Error state with fallback icon
- ✅ Circular image support
- ✅ Customizable properties
- ✅ Responsive layout
- ✅ Optimized for Lazy Layouts (LazyColumn, LazyRow, LazyVerticalGrid)

## Installation
Add the dependency to your `build.gradle`:

```groovy
dependencies {
    implementation 'io.github.Ravidu-Vithana:compose-coil-image-viewer:0.1.0-alpha'
}
```

## Usage

### Basic Usage
```kotlin
import com.ryvk.compose.coil.ImageViewer
import com.ryvk.compose.coil.ImageViewerProperties

ImageViewer(
    imageUrl = "https://example.com/image.jpg",
    contentDescription = "Profile image",
    imageViewerProperties = ImageViewerProperties(
        isCircular = true,
        containerSize = 120.dp
    )
)
```

### With Lazy Layouts (Optimized Performance)
```kotlin
LazyColumn {
    items(imagesList) { imageData ->
        ImageViewer(
            imageUrl = imageData.url,
            contentDescription = "Image ${imageData.id}",
            imageViewerProperties = ImageViewerProperties(
                isCircular = false,
                containerSize = 200.dp,
                contentScale = ContentScale.Crop
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

LazyVerticalGrid(
    columns = GridCells.Adaptive(120.dp)
) {
    items(imagesList) { imageData ->
        ImageViewer(
            imageUrl = imageData.url,
            contentDescription = "Grid image",
            imageViewerProperties = ImageViewerProperties(
                isCircular = true,
                containerSize = 120.dp
            )
        )
    }
}
```

### Advanced Usage with Custom Properties
```kotlin
ImageViewer(
    imageUrl = "https://example.com/image.jpg",
    fillMaxWidth = true, // Perfect for full-width images in lists
    contentDescription = "Full width image",
    imageViewerProperties = ImageViewerProperties(
        modifier = Modifier.padding(16.dp),
        contentScale = ContentScale.Fit,
        isCircular = false,
        containerSize = 200.dp,
        fallbackIconSize = 48.dp
    )
)
```

## Properties

| Parameter              | Type                 | Default            | Description                              |
|------------------------|----------------------|--------------------|------------------------------------------|
| imageUrl              | String               | Required           | Image URL or byte array to load          |
| contentDescription    | String?              | null               | Accessibility description                 |
| fillMaxWidth          | Boolean              | false              | Fill available width (great for lists)   |
| imageViewerProperties | ImageViewerProperties| Default            | Customization options                     |

### ImageViewerProperties

| Property            | Type          | Default            | Description                              |
|---------------------|---------------|--------------------|------------------------------------------|
| modifier            | Modifier      | Modifier           | Additional layout modifiers              |
| contentScale        | ContentScale  | ContentScale.Crop  | Image scaling behavior                   |
| isCircular          | Boolean       | true               | Circular image shape                     |
| containerSize       | Dp            | 80.dp              | Container size for non-full-width images |
| fallbackIconSize    | Dp            | 30.dp              | Size of error/loading icons              |

## Lazy Layout Optimization 🚀
This component is specifically optimized for use with Compose Lazy layouts:

### Performance Benefits:
- **Automatic State Management**: Handles loading states efficiently in scrollable lists
- **Memory Efficient**: Properly manages image loading and unloading during scroll
- **Smooth Scrolling**: Non-blocking UI during image loading
- **Placeholder Support**: Shows loading indicators without layout shifts

### Best Practices with Lazy Layouts:
```kotlin
LazyColumn {
    items(images) { image ->
        ImageViewer(
            imageUrl = image.url,
            fillMaxWidth = true, // ← Recommended for list items
            contentDescription = "List image",
            imageViewerProperties = ImageViewerProperties(
                isCircular = false,
                contentScale = ContentScale.Crop // ← Better for consistent aspect ratios
            )
        )
    }
}
```

### Byte Array Support:
```kotlin
// Load from byte array (great for cached images)
val imageByteArray: ByteArray = getImageData()
ImageViewer(
    imageUrl = imageByteArray, // ← Works with byte arrays too!
    contentDescription = "Cached image"
)
```

## Error Handling
The component provides basic error handling through Coil's built-in mechanisms:
- General Error States: Shows a fallback icon when image loading fails
- Loading States: Displays a progress indicator during image loading
- Network Issues: Handles basic network-related failures through Coil
