package com.wildcardev.roommate_utilities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.wildcardev.roommate_utilities.databinding.ActivityMainBinding
import com.wildcardev.roommate_utilities.view.ContactListFragment
import com.wildcardev.roommate_utilities.view.HomeFragment
import com.wildcardev.roommate_utilities.view.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    val homeFragment = HomeFragment()
    val settingsFragment = SettingsFragment()
    val contactsFragment = ContactListFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        navController = findNavController(R.id.fragmentContainerView)
        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        binding.bottomNav.setupWithNavController(navController)
        contactsFragment.setHasOptionsMenu(true)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == R.id.contactListFragment){
                binding.bottomNav.visibility = View.GONE
            }else{
                binding.bottomNav.visibility = View.VISIBLE

            }
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            Log.d("IS this changing?", "${item.itemId}")
            when (item.itemId) {
                R.id.home-> makeCurrentFragment(homeFragment)
                R.id.settings -> makeCurrentFragment(settingsFragment)
            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.contactListFragment -> Log.d("WHEN?","${item.itemId}")
        }
        return super.onOptionsItemSelected(item)
    }


    fun makeCurrentFragment(fragment: Fragment) {
        Log.d("In FUNC","FUNKY")
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }
}