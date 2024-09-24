package nsu.fomin.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GoslingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.gosling_activity)

        findViewById<Button>(R.id.switchButton)
            .setOnClickListener {
                startActivity(Intent(this, ReevesMainActivity::class.java))
            }
    }
}