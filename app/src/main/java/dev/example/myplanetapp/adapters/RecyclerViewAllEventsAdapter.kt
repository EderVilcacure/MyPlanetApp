package dev.example.myplanetapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import dev.example.myplanetapp.R
import dev.example.myplanetapp.model.VolunteeringEvent

class RecyclerViewAllEventsAdapter(options: FirestoreRecyclerOptions<VolunteeringEvent>) :
    FirestoreRecyclerAdapter<VolunteeringEvent, RecyclerViewAllEventsAdapter.ViewHolder>(options)
{

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val eventPicture: ImageView = itemView.findViewById(R.id.eventPicture)
        val eventTitle: TextView = itemView.findViewById(R.id.eventTitle)
        val eventTime: TextView = itemView.findViewById(R.id.eventTime)
        val eventSpots: TextView = itemView.findViewById(R.id.eventSpots)
        val eventSponsor: TextView = itemView.findViewById(R.id.eventSponsor)
        val eventCalendarDay: TextView = itemView.findViewById(R.id.eventDay)
        val eventCalendarMonth: TextView = itemView.findViewById(R.id.eventMonth)
        val eventSponsorLogo: ImageView = itemView.findViewById(R.id.sponsorLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.event_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: VolunteeringEvent) {
        holder.eventTitle.text = model.title
        holder.eventTime.text = model.time
        holder.eventSpots.text = model.spots.toString()
        holder.eventSponsor.text = model.sponsor
        holder.eventCalendarDay.text = model.day.toString()
        holder.eventCalendarMonth.text = model.month

        val storageReference = FirebaseStorage.getInstance().reference
        val picRef = storageReference.child(model.picture.toString())
        val logoRef = storageReference.child(model.sponsor_logo.toString())

        GlideApp.with(holder.itemView)
            .load(picRef)
            .into(holder.eventPicture)

        GlideApp.with(holder.itemView)
            .load(logoRef)
            .into(holder.eventSponsorLogo)

    }

}