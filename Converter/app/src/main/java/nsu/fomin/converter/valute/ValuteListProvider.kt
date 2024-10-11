package nsu.fomin.converter.valute

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import java.net.ConnectException
import java.net.URL

class ValuteListProvider {

    private val serializer: Json = Json { ignoreUnknownKeys = true }

    suspend fun downloadValuteJSON(link: String = "https://www.cbr-xml-daily.ru/daily_json.js") : ValuteMap {
        val deferred = CoroutineScope(Dispatchers.IO).async {
            download(link)
        }
        val json = deferred.await()
        return serializer.decodeFromString<ValuteMap>(json);
    }

    private fun download(link: String) : String {
        while (true) {
            try {
                return URL(link).readText()
            } catch (e: ConnectException) {
                println("retrying download valutes...")
                continue;
            }
        }
    }
}