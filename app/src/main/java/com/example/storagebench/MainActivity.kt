
package com.example.storagebench

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.components.Legend
import com.example.storagebench.databinding.ActivityMainBinding
import kotlin.math.sin
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        setupChart()
        drawDemo()
    }

    private fun setupChart() {
        b.lineChart.description.isEnabled = false
        b.lineChart.legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        b.lineChart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        b.lineChart.setTouchEnabled(true)
        b.lineChart.setPinchZoom(true)
    }

    private fun drawDemo() {
        val t = (0..30)
        val base = t.map { x -> 950 + 50 * sin(x / 4.0) }
        val run1 = base.map { it + Random(1).nextDouble(-20.0, 20.0) }
        val run2 = base.map { it*0.98 + Random(2).nextDouble(-22.0, 22.0) }
        val run3 = base.map { it*1.02 + Random(3).nextDouble(-25.0, 25.0) }

        val e1 = t.map { x -> Entry(x.toFloat(), run1[x].toFloat()) }
        val e2 = t.map { x -> Entry(x.toFloat(), run2[x].toFloat()) }
        val e3 = t.map { x -> Entry(x.toFloat(), run3[x].toFloat()) }

        val ds1 = LineDataSet(e1, "Run 1").apply { lineWidth = 2f; setDrawCircles(false); setDrawValues(false) }
        val ds2 = LineDataSet(e2, "Run 2").apply { lineWidth = 2f; setDrawCircles(false); setDrawValues(false) }
        val ds3 = LineDataSet(e3, "Run 3").apply { lineWidth = 2f; setDrawCircles(false); setDrawValues(false) }

        b.lineChart.data = LineData(ds1, ds2, ds3)
        b.lineChart.invalidate()
    }
}
