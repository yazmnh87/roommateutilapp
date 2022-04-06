package com.wildcardev.roommate_utilities.view

import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wildcardev.roommate_utilities.databinding.RoommateListItemBinding
import com.wildcardev.roommate_utilities.model.models.Contact

class RoommateViewHolder(binding: RoommateListItemBinding) : RecyclerView.ViewHolder(binding.root){

var contactName: TextView = binding.contactName

}

class RoommateRecyclerViewAdapter(private var contactList: ArrayList<Contact>) : RecyclerView.Adapter<RoommateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoommateViewHolder {
        val binding = RoommateListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RoommateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoommateViewHolder, position: Int) {
        var contact = contactList[position]
//        holder.contactName = contact.name
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}