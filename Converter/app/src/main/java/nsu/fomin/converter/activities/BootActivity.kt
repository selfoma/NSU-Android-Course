package nsu.fomin.converter.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.Deferred
import nsu.fomin.converter.R
import nsu.fomin.converter.valute.ValuteMapProvider
import nsu.fomin.converter.valute.ValuteMap

class BootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.boot_activity)

        val intent = Intent(this, ConverterActivity::class.java)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                val deferred = catchValuteMap()
                val valuteMap = deferred.await()
                intent.putExtra(getString(R.string.valute_map_extra), valuteMap)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun catchValuteMap() : Deferred<ValuteMap?> {
         return lifecycleScope.async {
            ValuteMapProvider().downloadValuteJSON()
        }
    }
}