package dev.effence.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.effence.mycontacts.databinding.ContactListItemBinding

class ContactRvAdapter (var ContactList:List<Contact>):
    RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        var binding =ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        binding.cvContact

        var contactViewHolder = ContactViewHolder(binding)
        return   contactViewHolder

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val context=holder.itemView.context
        var currentContact=ContactList.get(position)
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvemail.text=currentContact.email
        holder.binding.tvlocation.text=currentContact.address
        holder.binding.tvPhonenumber.text=currentContact.Phonenumber
        holder.binding.cvContact.setOnClickListener{
            val intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("PHONENUMBER",currentContact.Phonenumber)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }

        holder.binding.ivContact.setOnClickListener{
            Toast.makeText(context,"you have clicked my image",Toast.LENGTH_LONG).show()
        }


        Picasso.get().load(currentContact.image).placeholder(R.drawable.ic_baseline_person_24).error(R.drawable.ic_baseline_error_outline_24).resize(350,350).centerCrop().into(holder.binding.ivContact)

    }

    override fun getItemCount(): Int {
        return ContactList.size
    }
}

class ContactViewHolder(var binding:ContactListItemBinding):RecyclerView.ViewHolder(binding.root)






