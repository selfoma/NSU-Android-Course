package nsu.fomin.layout.activitiy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nsu.fomin.layout.R
import nsu.fomin.layout.details.AdvertisementDetails
import nsu.fomin.layout.details.TrackDetails
import nsu.fomin.layout.recycler.PlayerRecyclerAdapter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.player_activity)

        val recyclerView: RecyclerView = findViewById(R.id.player_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PlayerRecyclerAdapter(trackListItems(), adListItems())
    }

    private fun trackListItems() : List<TrackDetails> {
        return listOf(
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon_round
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
            TrackDetails(
                R.drawable.egor_creed_58_track_poster,
                getString(R.string.track_title),
                getString(R.string.track_performer),
                R.mipmap.play_icon
            ),
        )
    }

    private fun adListItems() : List<AdvertisementDetails> {
        return listOf(
            AdvertisementDetails(
                getString(R.string.ad_category),
                getString(R.string.ad_title),
                getString(R.string.ad_abstract),
                R.drawable.morgenshtern_naked_ad
            )
        )
    }
}