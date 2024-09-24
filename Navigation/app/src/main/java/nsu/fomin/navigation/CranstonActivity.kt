package nsu.fomin.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CranstonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cranston_activity)

        findViewById<Button>(R.id.switchButton)
            .setOnClickListener {
                startActivity(Intent(this, GoslingActivity::class.java))
            }
    }
}