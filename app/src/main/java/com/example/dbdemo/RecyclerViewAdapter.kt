package com.example.dbdemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView

import com.example.dbdemo.model.Contact

import java.util.ArrayList

class RecyclerViewAdapter(private val context: Context, private val contactList: ArrayList<Contact>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        //what we want to see on single cart as view holder.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        // jub mil jay to usky ky sath kia karna hai.
        val contact = contactList[position]

        holder.contactName.text = contact.name
        holder.phoneNumber.text = contact.phoneNumber


    }

    override fun getItemCount(): Int {
        // ktny hain us mein ye btana hai.

        return contactList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var contactName: TextView
        var phoneNumber: TextView
        var iconButton: ImageView

        init {
            itemView.setOnClickListener(this)
            contactName = itemView.findViewById(R.id.name)
            phoneNumber = itemView.findViewById(R.id.phone_number)
            iconButton = itemView.findViewById(R.id.icon_button)

            iconButton.setOnClickListener(this)

        }

        override fun onClick(view: View) {
            val position = this.adapterPosition
            val contact = contactList[position]
            val id = contact.id
            val name = contact.name
            val phone = contact.phoneNumber
            Toast.makeText(context, "The position is " + position.toString() +
                    " Name: " + name + ", Phone:" + phone, Toast.LENGTH_SHORT).show()

            val intent = Intent(context, displayContact::class.java)
            intent.putExtra("Rid", id)
            intent.putExtra("Rname", name)
            intent.putExtra("Rphone", phone)
            context.startActivity(intent)

        }
    }
}
