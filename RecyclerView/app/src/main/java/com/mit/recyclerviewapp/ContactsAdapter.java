package com.mit.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private ArrayList<Contact> contactDataList;

    public ContactsAdapter(ArrayList<Contact> contactDataList) {
        this.contactDataList = contactDataList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 1. Create a .xml layout file for UI of phonebookItems - DONE

        // 2. initialise Layout Inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 3. User inflater to create a view object of the  xml file in Step-1
        View view = inflater.inflate(R.layout.layout_contact_recycler_view_item, parent, false);

        // 4. Create and return object of ViewHolder using this view object in Step-3
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {


        // 1. Get the data item at `position`
        Contact contact = contactDataList.get(position);

        // Bind name data
        String fullName = contact.firstName + " " + contact.lastName;
        holder.fullNameTextView.setText(fullName);

        // Bind initials data
        String initials = contact.firstName.substring(0,1) + contact.lastName.substring(0,1);
        holder.displayPictureTextView.setText(initials);

        // Bind contact Number data
        holder.contactNumberTextView.setText(contact.contactNumber);
    }

    @Override
    public int getItemCount() {
        return contactDataList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView displayPictureTextView;
        TextView fullNameTextView;
        TextView contactNumberTextView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            /// Bind view objects
            displayPictureTextView = itemView.findViewById(R.id.display_initials_view);
            fullNameTextView = itemView.findViewById(R.id.fullname_text_view);
            contactNumberTextView = itemView.findViewById(R.id.contact_number_text_view);
        }
    }
}
