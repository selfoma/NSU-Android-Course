package nsu.fomin.converter.valute

class ValuteConverter(private val valuteMap: ValuteMap?){

    fun convertTo(dstValute: String, value: Double) : Double {
        val valute = valuteMap?.getValute(dstValute)
        return value * valute?.nominal!! / valute.value!!
    }
}