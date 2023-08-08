package dev.virunarala.christmas.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.virunarala.christmas.MainActivity
import dev.virunarala.christmas.R
import dev.virunarala.christmas.databinding.FragmentGalleryBinding
import dev.virunarala.christmas.gallery.model.GalleryPhotoType

class GalleryFragment : Fragment() {

    companion object {
        private const val TAG = "GalleryFragment"
    }

    private var _binding: FragmentGalleryBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        (requireActivity() as MainActivity).apply {
            setToolbarTitle(getString(R.string.label_gallery))
            showBottomNav()
            showToolbar()
            disableNavDrawer()
            setToolbarNavigationIcon(AppCompatResources.getDrawable(requireContext(),R.drawable.back))
        }
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[GalleryViewModel::class.java]

        val adapter = GalleryAdapter()
        binding.rvPhotoGallery.adapter = adapter
        adapter.submitList(viewModel.christmasPhotos)

        setLayoutManager(binding.rvPhotoGallery)
    }

    private fun setLayoutManager(recyclerView: RecyclerView) {
        val gridLayoutManager = GridLayoutManager(requireContext(),2)
        gridLayoutManager.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val adapter = recyclerView.adapter
                return when(adapter?.getItemViewType(position)) {
                    GalleryPhotoType.Horizontal.id -> 1
                    GalleryPhotoType.Vertical.id -> 1
                    GalleryPhotoType.Banner.id -> 2
                    else -> 2
                }
            }
        }
        recyclerView.layoutManager = gridLayoutManager
    }

}