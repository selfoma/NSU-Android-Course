package nsu.fomin.layout.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import nsu.fomin.layout.R
import nsu.fomin.layout.details.AdvertisementDetails
import nsu.fomin.layout.details.TrackDetails
import java.security.InvalidParameterException

class PlayerRecyclerAdapter(private val tracks: List<TrackDetails>, private val ads: List<AdvertisementDetails>)
    : RecyclerView.Adapter<ViewHolder>() {

    private enum class PlayerViewType {
        ADVERTISEMENT,
        TRACK
    }

    class TrackViewHolder(itemView: View) : ViewHolder(itemView) {
        val trackPoster = itemView.findViewById<ImageView>(R.id.track_poster)
        val trackTitle = itemView.findViewById<TextView>(R.id.track_title)
        val trackPerformer = itemView.findViewById<TextView>(R.id.track_performer)
        val trackPlayIcon = itemView.findViewById<ImageView>(R.id.play_icon)
    }

    class AdvertisementViewHolder(itemView: View) : ViewHolder(itemView) {
        val adCategory = itemView.findViewById<TextView>(R.id.ad_category)
        val adTitle = itemView.findViewById<TextView>(R.id.ad_title)
        val adAbstract = itemView.findViewById<TextView>(R.id.ad_abstract)
        val adImage = itemView.findViewById<ImageView>(R.id.ad_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         when(viewType) {
             PlayerViewType.ADVERTISEMENT.ordinal -> {
                val itemView: View  = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.track_item, parent, false)
                return TrackViewHolder(itemView)
            }
            else -> {
                 val itemView: View = LayoutInflater
                     .from(parent.context)
                     .inflate(R.layout.advertisement_item, parent, false)
                 return AdvertisementViewHolder(itemView)
             }
         }
    }

    override fun getItemCount(): Int = ads.size + tracks.size

    override fun getItemViewType(position: Int) : Int = position % 3

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder) {
            is AdvertisementViewHolder -> {
                val realPosition = position % ads.size
                holder.apply {
                    adCategory.text = ads[realPosition].category
                    adTitle.text = ads[realPosition].title
                    adAbstract.text = ads[realPosition].abstract
                    adImage.setImageResource(ads[realPosition].image)
                }
            }
            else -> {
                val realPosition = position % tracks.size
                (holder as TrackViewHolder).apply {
                    trackPoster.setImageResource(tracks[realPosition].poster)
                    trackTitle.text = tracks[realPosition].title
                    trackPerformer.text = tracks[realPosition].performer
                    trackPlayIcon.setImageResource(tracks[realPosition].playIcon)
                }
            }
        }
    }
}