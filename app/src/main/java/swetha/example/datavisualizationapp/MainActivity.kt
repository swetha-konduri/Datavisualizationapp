package swetha.example.datavisualizationapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupBarChart()
        setupPieChart()
        setupLineChart()
    }

    private fun setupBarChart() {
        val barChart = findViewById<BarChart>(R.id.barChart)
        
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, 450f))
        entries.add(BarEntry(1f, 630f))
        entries.add(BarEntry(2f, 320f))
        entries.add(BarEntry(3f, 500f))
        entries.add(BarEntry(4f, 590f))

        val labels = arrayOf("Jan", "Feb", "Mar", "Apr", "May")

        val dataSet = BarDataSet(entries, "Monthly Sales ($)")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 12f

        val barData = BarData(dataSet)
        barChart.data = barData
        
        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        barChart.xAxis.position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
        barChart.xAxis.setDrawGridLines(false)
        barChart.xAxis.granularity = 1f
        
        barChart.description.isEnabled = false
        barChart.animateY(1500)
        barChart.invalidate()
    }

    private fun setupPieChart() {
        val pieChart = findViewById<PieChart>(R.id.pieChart)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(35f, "Brand A"))
        entries.add(PieEntry(25f, "Brand B"))
        entries.add(PieEntry(20f, "Brand C"))
        entries.add(PieEntry(20f, "Brand D"))

        val dataSet = PieDataSet(entries, "Market Share")
        dataSet.colors = ColorTemplate.JOYFUL_COLORS.toList()
        dataSet.valueTextColor = Color.WHITE
        dataSet.valueTextSize = 14f

        val pieData = PieData(dataSet)
        pieChart.data = pieData
        
        pieChart.centerText = "Mobile Market"
        pieChart.setCenterTextSize(18f)
        pieChart.description.isEnabled = false
        pieChart.animateXY(1500, 1500)
        pieChart.invalidate()
    }

    private fun setupLineChart() {
        val lineChart = findViewById<LineChart>(R.id.lineChart)

        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 10f))
        entries.add(Entry(1f, 25f))
        entries.add(Entry(2f, 18f))
        entries.add(Entry(3f, 45f))
        entries.add(Entry(4f, 30f))
        entries.add(Entry(5f, 60f))

        val dataSet = LineDataSet(entries, "Revenue Trend")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK
        dataSet.lineWidth = 2f
        dataSet.setCircleColor(Color.RED)
        dataSet.setDrawFilled(true)
        dataSet.fillColor = Color.LTGRAY

        val lineData = LineData(dataSet)
        lineChart.data = lineData
        
        lineChart.description.isEnabled = false
        lineChart.animateX(1500)
        lineChart.invalidate()
    }
}
