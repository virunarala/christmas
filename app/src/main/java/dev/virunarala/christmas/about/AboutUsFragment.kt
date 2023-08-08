package dev.virunarala.christmas.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import dev.virunarala.christmas.MainActivity
import dev.virunarala.christmas.R

class AboutUsFragment : Fragment() {

    companion object {
        private const val TAG = "AboutUsFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onResume() {
        (requireActivity() as MainActivity).apply {
            setToolbarTitle(getString(R.string.label_about_us))
            showBottomNav()
            showToolbar()
            disableNavDrawer()
            setToolbarNavigationIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.back))
        }
        super.onResume()
    }

}