package dev.virunarala.christmas.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dev.virunarala.christmas.MainActivity
import dev.virunarala.christmas.R
import dev.virunarala.christmas.databinding.FragmentHomeBinding
import dev.virunarala.christmas.gallery.GalleryAdapter

class HomeFragment : Fragment() {

    companion object {
        private const val TAG = "HomeFragment"
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val adapter = GalleryAdapter()
        binding.rvPhotoGallery.adapter = adapter
        adapter.submitList(viewModel.christmasPhotos)
    }

    override fun onResume() {
        (requireActivity() as MainActivity).apply {
            setToolbarTitle(getString(R.string.label_home))
            hideBottomNav()
            enableNavDrawer()
            showToolbar()
            setToolbarNavigationIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.menu_alt))
        }

        binding.buttonViewMore.setOnClickListener {
            findNavController().navigate(R.id.gallery)
        }

        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}