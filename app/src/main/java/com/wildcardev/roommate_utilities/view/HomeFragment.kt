package com.wildcardev.roommate_utilities.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.wildcardev.roommate_utilities.R
import com.wildcardev.roommate_utilities.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        Log.d("HELLO", "HELLO")
        binding.addRoommate.setOnClickListener {
            findNavController().navigate(R.id.contactListFragment)
//            parentFragmentManager.beginTransaction()
//                .add(R.id.homeFragment, ContactListFragment(), "CONTACT_LIST_FRAGMENT")
//                .commit()
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}