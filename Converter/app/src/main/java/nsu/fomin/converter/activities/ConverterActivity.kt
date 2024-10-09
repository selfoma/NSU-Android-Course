package nsu.fomin.converter.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.IntentCompat
import nsu.fomin.converter.R
import nsu.fomin.converter.valute.ValuteConverter
import nsu.fomin.converter.valute.ValuteMap

class ConverterActivity : ComponentActivity() {

    private val valuteMap: ValuteMap by lazy {
        IntentCompat.getParcelableExtra(intent, "valuteMap", ValuteMap::class.java)
                                    as ValuteMap
    }

    private val inputView : EditText by lazy { findViewById(R.id.valute_input) }

    private lateinit var spinnerView: Spinner

    private val outputView: TextView by lazy { findViewById(R.id.output) }

    private val converter: ValuteConverter by lazy { ValuteConverter(valuteMap) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.converter_main_activity)

        syncScrollViews()
        fillValuteTable()
        buildConverterLogic()
    }

    private fun syncScrollViews() {
        val headerScroll = findViewById<HorizontalScrollView>(R.id.table_header_hscroll_view)
        val dataScroll = findViewById<HorizontalScrollView>(R.id.table_data_hscroll_view)

        headerScroll.setOnScrollChangeListener { _, scrollX, _, _, _ ->
            dataScroll.scrollTo(scrollX, 0)
        }
        dataScroll.setOnScrollChangeListener { _, scrollX, _, _, _ ->
            headerScroll.scrollTo(scrollX, 0)
        }
    }

    @SuppressLint("DefaultLocale", "SetTextI18n")
    private fun fillValuteTable() {
        val table = findViewById<TableLayout>(R.id.valute_table)
        for (v in valuteMap.map?.values!!) {
            val rowView = layoutInflater.inflate(R.layout.valute_list_row, table, false)
            with(rowView) {
                findViewById<TextView>(R.id.num_code).text = v.numCode
                findViewById<TextView>(R.id.char_code).text = v.numCode
                findViewById<TextView>(R.id.nominal).text = v.nominal.toString()
                findViewById<TextView>(R.id.valute).text = v.name
                findViewById<TextView>(R.id.value).text = v.value.toString()
                findViewById<TextView>(R.id.now_prev_diff).text = "(${String.format("%.2f", (v.value?.minus(v.prevValue!!)))})"
            }
            table.addView(rowView)
        }
    }

    @SuppressLint("DefaultLocale")
    private fun buildConverterLogic() {

        val valuteItems = valuteMap.map?.keys?.stream()?.toArray() as Array<*>
        val valuteAdapter = ArrayAdapter(this, R.layout.spinner_item, valuteItems)
        spinnerView = findViewById<Spinner>(R.id.valute_chooser).apply {
            adapter = valuteAdapter
        }

        findViewById<Button>(R.id.convert_button).setOnClickListener {
            val dstValute = (spinnerView.selectedView as TextView).text.toString()
            val result = runCatching {
                inputView.text.toString().toDouble()
            }
            result.onSuccess {
                val convertedValue = converter.convertTo(dstValute, result.getOrNull()!!)
                outputView.text = String.format("%.4f", convertedValue)
            }
            result.onFailure {
                outputView.text = getString(R.string.input_failure)
            }
        }
    }
}
