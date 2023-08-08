package dev.virunarala.christmas

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.virunarala.christmas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var navHostFragment: FragmentContainerView
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupBottomNavigation(navController)
        setupDrawerNavigation(navController)
    }

    private fun setupBottomNavigation(navController: NavController) {
        NavigationUI.setupWithNavController(binding.bottomNav,navController)
    }

    private fun setupDrawerNavigation(navController: NavController) {
        NavigationUI.setupWithNavController(binding.navDrawer,navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun showBottomNav() {
        binding.bottomNav.visibility = View.VISIBLE
    }

    fun hideBottomNav() {
        binding.bottomNav.visibility = View.GONE
    }

    fun showToolbar() {
        binding.toolbar.visibility = View.VISIBLE
    }

    fun hideToolbar() {
        binding.toolbar.visibility = View.GONE
    }

    fun setToolbarTitle(title: String) {
        binding.toolbar.title = title
    }

    fun setToolbarNavigationIcon(drawable: Drawable?) {
        binding.toolbar.navigationIcon = drawable
    }

    fun enableNavDrawer() {
        binding.layoutNavDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        binding.toolbar.setNavigationOnClickListener {
            binding.layoutNavDrawer.openDrawer(GravityCompat.START)
        }
    }

    fun disableNavDrawer() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.layoutNavDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        binding.toolbar.setNavigationOnClickListener {
            navController.navigate(R.id.home)
        }
    }
}