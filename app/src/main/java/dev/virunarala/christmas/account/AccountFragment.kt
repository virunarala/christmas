package dev.virunarala.christmas.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import dev.virunarala.christmas.MainActivity
import dev.virunarala.christmas.R
import dev.virunarala.christmas.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    companion object {
        private const val TAG = "AccountFragment"
    }

    private var _binding: FragmentAccountBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClickListeners()
    }

    override fun onResume() {
        (requireActivity() as MainActivity).apply {
            setToolbarTitle(getString(R.string.label_account))
            showBottomNav()
            showToolbar()
            disableNavDrawer()
            setToolbarNavigationIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.back))
        }
        super.onResume()
    }

    private fun setClickListeners() {
        val navController = findNavController()
        binding.apply {
            textHome.setOnClickListener { navController.navigate(R.id.home) }
            textAboutUs.setOnClickListener { navController.navigate(R.id.about_us) }
            textGallery.setOnClickListener { navController.navigate(R.id.gallery) }
            textLogout.setOnClickListener {
                navController.navigate(R.id.signup)
            }
        }
    }

}