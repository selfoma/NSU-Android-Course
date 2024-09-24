package nsu.fomin.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ReevesMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.reeves_activity_main)

        findViewById<Button>(R.id.switchButton)
            .setOnClickListener {
                startActivity(Intent(this, CranstonActivity::class.java))
        }
    }
}
