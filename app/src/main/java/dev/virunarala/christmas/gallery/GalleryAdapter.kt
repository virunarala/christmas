package dev.virunarala.christmas.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.virunarala.christmas.databinding.ItemHorizontalPhotoBinding
import dev.virunarala.christmas.databinding.ItemVerticalPhotoBinding
import dev.virunarala.christmas.gallery.model.GalleryPhoto
import dev.virunarala.christmas.gallery.model.GalleryPhotoType

class GalleryAdapter: ListAdapter<GalleryPhoto, RecyclerView.ViewHolder>(DiffCallback) {

    object DiffCallback: DiffUtil.ItemCallback<GalleryPhoto>() {
        override fun areItemsTheSame(oldItem: GalleryPhoto, newItem: GalleryPhoto): Boolean {
            return oldItem.resId == newItem.resId
        }

        override fun areContentsTheSame(oldItem: GalleryPhoto, newItem: GalleryPhoto): Boolean {
            return oldItem.resId == newItem.resId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            GalleryPhotoType.Vertical.id -> {
                return VerticalPhotoViewHolder(ItemVerticalPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }

            GalleryPhotoType.Horizontal.id -> {
                return HorizontalPhotoViewHolder(ItemHorizontalPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }

            GalleryPhotoType.Banner.id -> {
                return VerticalPhotoViewHolder(ItemVerticalPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }

            else -> {
                return VerticalPhotoViewHolder(ItemVerticalPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val galleryPhoto = getItem(position)
        when(holder.itemViewType) {
            GalleryPhotoType.Vertical.id -> {
                (holder as VerticalPhotoViewHolder).bind(galleryPhoto)
            }

            GalleryPhotoType.Horizontal.id -> {
                (holder as HorizontalPhotoViewHolder).bind(galleryPhoto)
            }

            GalleryPhotoType.Banner.id -> {
                (holder as VerticalPhotoViewHolder).bind(galleryPhoto)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item.viewType.id
    }

    inner class VerticalPhotoViewHolder(val binding: ItemVerticalPhotoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryPhoto: GalleryPhoto) {
            binding.imagePhoto.setImageDrawable(AppCompatResources.getDrawable(binding.root.context,galleryPhoto.resId))
        }
    }

    inner class HorizontalPhotoViewHolder(val binding: ItemHorizontalPhotoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryPhoto: GalleryPhoto) {
            binding.imagePhoto.setImageDrawable(AppCompatResources.getDrawable(binding.root.context,galleryPhoto.resId))
        }
    }
}