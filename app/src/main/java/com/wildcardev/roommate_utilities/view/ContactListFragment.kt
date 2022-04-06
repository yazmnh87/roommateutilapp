package com.wildcardev.roommate_utilities.view

import android.content.ContentResolver
import android.content.DialogInterface
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildcardev.roommate_utilities.databinding.ContactListItemBinding
import com.wildcardev.roommate_utilities.databinding.FragmentContactListBinding
import com.wildcardev.roommate_utilities.model.models.Contact
import com.wildcardev.roommate_utilities.viewModel.ContactsViewModel


class ContactListFragment : Fragment() {
    private lateinit var binding: FragmentContactListBinding
    private lateinit var _binding: ContactListItemBinding
    private lateinit var adapter: ContactListRecyclerViewAdapter
    private val viewModel: ContactsViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(inflater, container, false)
        _binding = ContactListItemBinding.inflate(inflater, container, false)
        val permissions = checkPermissions()
        Log.d("permissions","${permissions}")
        if (permissions == -1) {
            Log.d("IMPORTANT", "HERE1")

            ActivityCompat.requestPermissions((activity as AppCompatActivity), arrayOf(android.Manifest.permission.READ_CONTACTS),1)
            binding.contactListRecyclerView.layoutManager = LinearLayoutManager(context)
            adapter = ContactListRecyclerViewAdapter(getContacts())
            binding.contactListRecyclerView.adapter = adapter


}else{
    Log.d("ELSE","ELSE")
            binding.contactListRecyclerView.layoutManager = LinearLayoutManager(context)
            adapter = ContactListRecyclerViewAdapter(getContacts())
            binding.contactListRecyclerView.adapter = adapter
}

    binding.addContacts.setOnClickListener {
        Log.d("Button","${viewModel.contactsList}")
    }

        return binding.root
    }


    private fun checkPermissions(): Int?{
        val permissions = context?.let {

            return ContextCompat.checkSelfPermission(it, android.Manifest.permission.READ_CONTACTS)
        }
        return permissions
    }

    private fun getContacts(): ArrayList<Contact> {
        Log.d("IMPOORTANT","GETTING ME SOME CONTACTS")
        val resolver: ContentResolver? = getActivity()?.contentResolver
        var contactsArray = ArrayList<Contact>()

        var getContactsCursor: Cursor? = resolver?.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, arrayOf(
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                //                ContactsContract.CommonDataKinds.Phone.PHOTO_FILE_ID
            ), null, null, null
        )

        if (getContactsCursor != null) {
            Log.d("CUSOR?","$getContactsCursor")
            while (getContactsCursor.moveToNext()) {
                val contactId: Long = getContactsCursor.getLong(0)
                val contactName: String = getContactsCursor.getString(1)
                val contactPhoneNumber: String = getContactsCursor.getString(2)
//                val contactPhoto: String? = getContactsCursor.getString(3)
                Log.d("whats here?", "$contactId, $contactName")
                 contactsArray.add(Contact(contactId, contactName, contactPhoneNumber, ""))
            }
            Log.d("contacts", "${contactsArray.size},$contactsArray")
            getContactsCursor.close()
        }
//
        return contactsArray
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
    }

    private fun setUpToolBar(){
        val toolbar = binding.contactListToolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController((activity as AppCompatActivity), findNavController())
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

    }

}