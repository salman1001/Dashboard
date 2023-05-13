package com.hoogsoftware.dashboarddisplay

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.hoogsoftware.dashboarddisplay.databinding.ActivityDetailsDashBinding
import com.hoogsoftware.dashboarddisplay.databinding.ActivityMainBinding

class DetailsDash : AppCompatActivity() {
    lateinit var binding: ActivityDetailsDashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsDashBinding.inflate(layoutInflater);
        setContentView(binding.root)
        var list=ArrayList<BarEntry>()
        list.add(BarEntry(2014f,100f))
        list.add(BarEntry(2015f,300f))
        list.add(BarEntry(2016f,400f))
        list.add(BarEntry(2017f,600f))
        list.add(BarEntry(2018f,700f))
        list.add(BarEntry(2019f,800f))
        list.add(BarEntry(2011f,900f))
        var basdataset=BarDataSet(list,"Call Logs")
       // basdataset.setColor(ColorTemplate.MATERIAL_COLORS[0])
        //basdataset.setValueTextColors(Color.BLACK)
        var bardata=BarData(basdataset)
        binding.barchat.data=bardata



    }
}