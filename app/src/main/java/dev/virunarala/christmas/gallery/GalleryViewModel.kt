package dev.virunarala.christmas.gallery

import androidx.lifecycle.ViewModel
import dev.virunarala.christmas.R
import dev.virunarala.christmas.gallery.model.GalleryPhoto
import dev.virunarala.christmas.gallery.model.GalleryPhotoType

class GalleryViewModel : ViewModel() {
    val christmasPhotos = listOf(
        GalleryPhoto(R.drawable.christmas_gathering,GalleryPhotoType.Banner),
        GalleryPhoto(R.drawable.christmas1,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas2,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas3,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas4,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas5,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas6,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas7,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas8,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas9,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas10,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas11,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas12,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas13,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas14,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas15,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas16,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas17,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas18,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas19,GalleryPhotoType.Vertical),
        GalleryPhoto(R.drawable.christmas20,GalleryPhotoType.Vertical)
    )
}