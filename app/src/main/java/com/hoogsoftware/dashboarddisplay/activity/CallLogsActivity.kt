package com.hoogsoftware.dashboarddisplay.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import com.hoogsoftware.dashboarddisplay.R
import com.hoogsoftware.dashboarddisplay.adapter.CallLogsAdapter
import com.hoogsoftware.dashboarddisplay.databinding.ActivityCallLogsBinding
import com.hoogsoftware.dashboarddisplay.databinding.ActivityMainBinding
import com.hoogsoftware.dashboarddisplay.model.CallLogsModel

class CallLogsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCallLogsBinding
    var layoutAnimationController: LayoutAnimationController?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallLogsBinding.inflate(layoutInflater);
        setContentView(binding.root)



        if (this is AppCompatActivity) {
            (this as AppCompatActivity).setSupportActionBar(binding.toolbar)
            (this as AppCompatActivity).supportActionBar?.title = "Call Logs"

        }
        var adapter=CallLogsAdapter(this, listOf(CallLogsModel("8588888888888"),
            CallLogsModel("9588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("7588888888888"),
            CallLogsModel("6588888888888"),
            CallLogsModel("9588888888888"),
            CallLogsModel("9588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("5588888888888"),
            CallLogsModel("6588888888888"),
            CallLogsModel("9588888888888"),
            CallLogsModel("6588888888888"),
            CallLogsModel("5588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888"),
            CallLogsModel("8588888888888")
        ))
        binding.recChapters.adapter=adapter
        layoutAnimationController= AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation)
        binding.recChapters.layoutAnimation=layoutAnimationController
    }
}