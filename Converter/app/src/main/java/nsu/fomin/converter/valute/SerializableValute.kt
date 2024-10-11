package nsu.fomin.converter.valute

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kotlinx.serialization.json.JsonObject

@Serializable
@Parcelize
data class Valute(
    @JsonNames("NumCode")
    val numCode: String? = null,
    @JsonNames("CharCode")
    val charCode: String? = null,
    @JsonNames("Nominal")
    val nominal: Int? = null,
    @JsonNames("Name")
    val name: String? = null,
    @JsonNames("Value")
    val value: Double? = null,
    @JsonNames("Previous")
    val prevValue: Double? = null
) : Parcelable

@Serializable
@Parcelize
data class ValuteMap (
    @JsonNames("Valute")
    val map: Map<String, Valute>? = null
)  : Parcelable {

    fun getValute(key: String) : Valute? {
        return map?.get(key)
    }
}
