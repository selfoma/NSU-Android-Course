package nsu.fomin.converter.valute

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValuteMap (val map: Map<String, Valute>? = null)  : Parcelable {

    fun getValute(key: String) : Valute? {
        return map?.get(key)
    }
}

