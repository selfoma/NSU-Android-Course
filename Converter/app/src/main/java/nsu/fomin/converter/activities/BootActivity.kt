package nsu.fomin.converter.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.Deferred
import nsu.fomin.converter.R
import nsu.fomin.converter.valute.ValuteListProvider
import nsu.fomin.converter.valute.ValuteMap

class BootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.boot_activity)

        val intent = Intent(this, ConverterActivity::class.java)
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            val deferred = catchValuteMap()
            val valuteMap = deferred.await()
            intent.putExtra("valuteMap", valuteMap)
            startActivity(intent)
            finish()
        }
    }

    private fun catchValuteMap() : Deferred<ValuteMap?> {
         return CoroutineScope(Dispatchers.IO + SupervisorJob()).async {
            ValuteListProvider().downloadValuteJSON()
        }
    }
}