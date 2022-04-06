package com.wildcardev.roommate_utilities.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wildcardev.roommate_utilities.MainActivity
import com.wildcardev.roommate_utilities.databinding.ContactListItemBinding
import com.wildcardev.roommate_utilities.model.models.Contact
import com.wildcardev.roommate_utilities.viewModel.ContactsViewModel


interface OnItemClickListener{
   fun onItemClicked(contact: Contact)
}

class ContactListRecyclerViewHolder(val binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){

    var contactName: TextView = binding.contactNameList
    var contactCheckBox: ImageView = binding.contactItemCheckbox
    var contactItemContainer: View = binding.contactItemContainer
//    fun bind(item: Contact){
//    with(binding){
//        contactNameList.text = item.name
//    }

}


class ContactListRecyclerViewAdapter(private var contactList: ArrayList<Contact>) : RecyclerView.Adapter<ContactListRecyclerViewHolder>(){
    private val tempContactList = mutableListOf<Contact>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactListRecyclerViewHolder {
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        val viewHolder = ContactListRecyclerViewHolder(binding)

        return ContactListRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactListRecyclerViewHolder, position: Int) {
        val item = contactList[position]
        holder.contactName.text = item.name
        holder.contactItemContainer.setOnClickListener {
            Log.d("IMPORTANT!!","${item.id}")
            if(holder.contactCheckBox.visibility == View.INVISIBLE){
                holder.contactCheckBox.visibility = View.VISIBLE
            }else if(holder.contactCheckBox.visibility == View.VISIBLE){
                holder.contactCheckBox.visibility = View.INVISIBLE
            }

            tempContactList.add(item)
        }

    }

    //    override fun onBindViewHolder(holder: ContactListRecyclerViewHolder, position: Int) = {
//        holder.bind(contactList[position])
//
//    }


    //    inner class ViewHolder(val binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){
//        fun bind(item: Contact){
//            with(binding){
//                contactNameList.text = item.name
//            }
//        }
//    }

    override fun getItemCount(): Int {
        return contactList.size
    }




}