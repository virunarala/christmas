package dev.virunarala.christmas.home

import androidx.lifecycle.ViewModel
import dev.virunarala.christmas.R
import dev.virunarala.christmas.gallery.model.GalleryPhoto
import dev.virunarala.christmas.gallery.model.GalleryPhotoType

class HomeViewModel : ViewModel() {
    val christmasPhotos = listOf(
        GalleryPhoto(R.drawable.christmas1, GalleryPhotoType.Horizontal),
        GalleryPhoto(R.drawable.christmas2,GalleryPhotoType.Horizontal),
        GalleryPhoto(R.drawable.christmas3,GalleryPhotoType.Horizontal),
        GalleryPhoto(R.drawable.christmas4,GalleryPhotoType.Horizontal),
        GalleryPhoto(R.drawable.christmas5,GalleryPhotoType.Horizontal)
    )
}