package dev.virunarala.christmas.gallery.model

import androidx.annotation.DrawableRes

data class GalleryPhoto(
    @DrawableRes val resId: Int,
    val viewType: GalleryPhotoType
)

