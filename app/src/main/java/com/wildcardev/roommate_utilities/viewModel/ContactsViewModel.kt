package com.wildcardev.roommate_utilities.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wildcardev.roommate_utilities.model.models.Contact


class ContactsViewModel(application: Application): BaseViewModel(application) {
val contactsList = MutableLiveData<Contact>()
//    val _contactsListi = LiveData<List<Contact>>()

    fun addContact(contact: Contact){
       contactsList.postValue(contact)
    }

    fun addContacts(contacts: ArrayList<Contact>){
        Log.d("ViewModeladdContacts","$contactsList")
    }

}