package com.hoogsoftware.dashboarddisplay

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.hoogsoftware.dashboarddisplay.activity.CallLogsActivity
import com.hoogsoftware.dashboarddisplay.databinding.ActivityMainBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent


class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)


        KeyboardVisibilityEvent.setEventListener(this
        ) {
         //  Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_SHORT).show()
            if (it){
                binding.smooth.visibility=View.GONE
                binding.smooth.visibility=View.GONE
                binding.smooth.visibility=View.GONE
                binding.smooth.visibility=View.GONE
            }
            else{
                binding.smooth.visibility=View.VISIBLE
                binding.smooth.visibility=View.VISIBLE
                binding.smooth.visibility=View.VISIBLE
                binding.smooth.visibility=View.VISIBLE
            }
        }
        // setContentView(R.layout.activity_main)
        toggle = ActionBarDrawerToggle(this, binding.drawerLay, binding.toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLay!!.addDrawerListener(toggle)
        toggle.syncState()
        var list=ArrayList<BarEntry>()
        list.add(BarEntry(2014f,100f))
        list.add(BarEntry(2015f,300f))
        list.add(BarEntry(2016f,400f))
        list.add(BarEntry(2017f,600f))
        list.add(BarEntry(2018f,700f))
        list.add(BarEntry(2019f,800f))
        list.add(BarEntry(2011f,900f))
        var basdataset= BarDataSet(list,"Call Logs")
        basdataset.setColors(listOf(resources.getColor(R.color.color1),resources.getColor(R.color.color2),
            resources.getColor(R.color.color3),resources.getColor(R.color.color4),
            resources.getColor(R.color.color5),resources.getColor(R.color.color6),
            resources.getColor(R.color.color7),resources.getColor(R.color.color8),
            resources.getColor(R.color.color9),resources.getColor(R.color.color10)
        ))
        //basdataset.setValueTextColors(Color.BLACK)
        var bardata= BarData(basdataset)
//        binding.barchat.setOnClickListener{
//            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT)
//
//        }

//        binding.piechat.setOnClickListener{
//            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT)
//        }

        binding.barchat.data=bardata
        binding.viewpager.clipToPadding=false
        binding.viewpager.clipChildren=false
        binding.viewpager.offscreenPageLimit=3
        var compositePageTransforme=CompositePageTransformer()
        compositePageTransforme.addTransformer(MarginPageTransformer(10))
        compositePageTransforme.addTransformer { page, position ->
            var flo=1-Math.abs(position)
            page.scaleY=(0.85f+flo*0.15f)
        }
        binding.viewpager.setPageTransformer(compositePageTransforme)
        binding.llqw.setOnClickListener{
        }
        binding.layCor.setOnClickListener{
            startActivity(Intent(this@MainActivity,CallLogsActivity::class.java))
        }
   binding.layUn.setOnClickListener{
            startActivity(Intent(this@MainActivity,CallLogsActivity::class.java))
        }
   binding.layWro.setOnClickListener{
            startActivity(Intent(this@MainActivity,CallLogsActivity::class.java))
        }
   binding.layUn1.setOnClickListener{
            startActivity(Intent(this@MainActivity,CallLogsActivity::class.java))
        }


        binding.piechat.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    //   Toast.makeText(this@MainActivity,"Pie chart was clicked.",Toast.LENGTH_SHORT).show()
                    var dialog: Dialog = Dialog(this@MainActivity)
                    dialog.setContentView(R.layout.dialog_box)
                    var pieChart: PieChart = dialog.findViewById(R.id.piechat12)
                    pieChart.visibility = View.VISIBLE
                    var list1 = ArrayList<PieEntry>()
                    list1.add(PieEntry(5f, "Sa"))
                    list1.add(PieEntry(6f, "De"))
                    list1.add(PieEntry(7f, "Pr"))
                    list1.add(PieEntry(8f, "Sh"))
                    list1.add(PieEntry(9f, "As"))
                    list1.add(PieEntry(4f, "Az"))

                    var piedataset = PieDataSet(list1, "Call Logs")
                    piedataset.setColors(
                        listOf(
                            resources.getColor(R.color.color1), resources.getColor(R.color.color2),
                            resources.getColor(R.color.color3), resources.getColor(R.color.color4),
                            resources.getColor(R.color.color5), resources.getColor(R.color.color6),
                            resources.getColor(R.color.color7), resources.getColor(R.color.color8),
                            resources.getColor(R.color.color9), resources.getColor(R.color.color10)
                        )
                    )
                    // basdataset.setColor(ColorTemplate.MATERIAL_COLORS[0])
                    // basdataset.setValueTextColors(Color.BLACK)

                    var piedata = PieData(piedataset)
                    pieChart.data = piedata

                    dialog.window!!.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    dialog.show()


                }
            }

            v?.onTouchEvent(event) ?: true
        }


        binding.barchat.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    //   Toast.makeText(this@MainActivity,"Pie chart was clicked.",Toast.LENGTH_SHORT).show()
                    var dialog: Dialog = Dialog(this@MainActivity)
                    dialog.setContentView(R.layout.dialog_box)
                    var pieChart: BarChart = dialog.findViewById(R.id.barchat12)
                    pieChart.visibility = View.VISIBLE
                    var list = ArrayList<BarEntry>()
                    list.add(BarEntry(2014f, 100f))
                    list.add(BarEntry(2015f, 300f))
                    list.add(BarEntry(2016f, 400f))
                    list.add(BarEntry(2017f, 600f))
                    list.add(BarEntry(2018f, 700f))
                    list.add(BarEntry(2019f, 800f))
                    list.add(BarEntry(2011f, 900f))
                    var basdataset = BarDataSet(list, "Call Logs")
                    basdataset.setColors(
                        listOf(
                            resources.getColor(R.color.color1), resources.getColor(R.color.color2),
                            resources.getColor(R.color.color3), resources.getColor(R.color.color4),
                            resources.getColor(R.color.color5), resources.getColor(R.color.color6),
                            resources.getColor(R.color.color7), resources.getColor(R.color.color8),
                            resources.getColor(R.color.color9), resources.getColor(R.color.color10)
                        )
                    )
                    //basdataset.setValueTextColors(Color.BLACK)
                    var bardata = BarData(basdataset)

                    //        binding.barchat.setOnClickListener{
                    //            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT)
                    //
                    //        }

                    //        binding.piechat.setOnClickListener{
                    //            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT)
                    //        }

                    pieChart.data = bardata

                    dialog.window!!.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    dialog.show()


                }
            }

            v?.onTouchEvent(event) ?: true
        }

        binding.viewpager.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
        binding.viewpager.adapter=ContactsAdapter(listOf<ContactsModel>(
            ContactsModel(R.drawable.image2),
            ContactsModel(R.drawable.imgone),
            ContactsModel(R.drawable.image2),
            ContactsModel(R.drawable.imgone),
            ContactsModel(R.drawable.image2),
            ContactsModel(R.drawable.imgone),
            ContactsModel(R.drawable.image2),
            ContactsModel(R.drawable.imgone),
            ContactsModel(R.drawable.image2),
            ContactsModel(R.drawable.imgone)))
        var list1=ArrayList<PieEntry>()
        list1.add(PieEntry(5f,"Sa"))
        list1.add(PieEntry(6f,"De"))
        list1.add(PieEntry(7f,"Pr"))
        list1.add(PieEntry(8f,"Sh"))
        list1.add(PieEntry(9f,"As"))
        list1.add(PieEntry(4f,"Az"))

        var piedataset=PieDataSet(list1,"Call Logs")
        piedataset.setColors(listOf(resources.getColor(R.color.color1),resources.getColor(R.color.color2),
            resources.getColor(R.color.color3),resources.getColor(R.color.color4),
            resources.getColor(R.color.color5),resources.getColor(R.color.color6),
            resources.getColor(R.color.color7),resources.getColor(R.color.color8),
            resources.getColor(R.color.color9),resources.getColor(R.color.color10)
        ))
        // basdataset.setColor(ColorTemplate.MATERIAL_COLORS[0])
        // basdataset.setValueTextColors(Color.BLACK)

        var piedata=PieData(piedataset)
        binding.piechat.data=piedata




        binding.navView!!.setNavigationItemSelectedListener {
            if (it.itemId==R.id.nav_share)
                else{
                    when (it.itemId) {
                        R.id.nav_chapters ->{}
                        R.id.nav_hcverma ->{}
                        R.id.nav_dc->{}
                        R.id.nav_iro ->{}
                        R.id.nav_prev ->{}
                        R.id.nav_jeenoti->{}
                        R.id.nav_cutoff->{}
                        R.id.nav_tests->{}
                        R.id.nav_rate->{}
                    }
                }
            binding.drawerLay!!.closeDrawer(GravityCompat.START)
            true
        }

        binding.edit.setOnClickListener{
            getPermission()
        }
        binding.imageview.setOnClickListener{
            getPermission()
        }
    }
    var dexter: Dexter?=null
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result -> dexter!!.check()
        }

    private fun getPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            dexter = Dexter.withContext(this)
                .withPermissions(
                    android.Manifest.permission.READ_MEDIA_IMAGES


//                Manifest.permission.READ_CALL_LOG
//                , Manifest.permission.READ_PHONE_STATE
//             //   , Manifest.permission.READ_MEDIA_AUDIO,
//                    ,Manifest.permission.RECORD_AUDIO
//             //   , Manifest.permission.READ_MEDIA_VIDEO
//                , Manifest.permission.READ_PHONE_NUMBERS
                    //     Manifest.permission.READ_EXTERNAL_STORAGE
//                , Manifest.permission.PROCESS_OUTGOING_CALLS
//                , Manifest.permission.READ_CONTACTS
                ).withListener(object : MultiplePermissionsListener {
                    @RequiresApi(Build.VERSION_CODES.R)
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        report.let {
                            if (report.areAllPermissionsGranted()) {
                                openGallery()
                            }
                            else {
                                AlertDialog.Builder(this@MainActivity, R.style.Theme_DashboardDisplay).apply {
                                    setMessage("please allow the required permissions")
                                        .setCancelable(false)
                                        .setPositiveButton("Settings") { _, _ ->
                                            val reqIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                                .apply {
                                                    val uri = Uri.fromParts("package", packageName, null)
                                                    data = uri
                                                }
                                            resultLauncher.launch(reqIntent)
                                        }
                                    val alert = this.create()
                                    alert.show()
                                }
                            }
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest?>?, token: PermissionToken?) {
                        token?.continuePermissionRequest()
                    }
                }).withErrorListener{
                    Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
                } as Dexter

        }
        else{
            dexter = Dexter.withContext(this)
                .withPermissions(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE


//                Manifest.permission.READ_CALL_LOG
//                , Manifest.permission.READ_PHONE_STATE
//             //   , Manifest.permission.READ_MEDIA_AUDIO,
//                    ,Manifest.permission.RECORD_AUDIO
//             //   , Manifest.permission.READ_MEDIA_VIDEO
//                , Manifest.permission.READ_PHONE_NUMBERS
                    //     Manifest.permission.READ_EXTERNAL_STORAGE
//                , Manifest.permission.PROCESS_OUTGOING_CALLS
//                , Manifest.permission.READ_CONTACTS
                ).withListener(object : MultiplePermissionsListener {
                    @RequiresApi(Build.VERSION_CODES.R)
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        report.let {
                            if (report.areAllPermissionsGranted()) {
                                openGallery()
                            }
                            else {
                                AlertDialog.Builder(this@MainActivity, R.style.Theme_DashboardDisplay).apply {
                                    setMessage("please allow the required permissions")
                                        .setCancelable(false)
                                        .setPositiveButton("Settings") { _, _ ->
                                            val reqIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                                .apply {
                                                    val uri = Uri.fromParts("package", packageName, null)
                                                    data = uri
                                                }
                                            resultLauncher.launch(reqIntent)
                                        }
                                    val alert = this.create()
                                    alert.show()
                                }
                            }
                        }
                    }
                    override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest?>?, token: PermissionToken?) {
                        token?.continuePermissionRequest()
                    }
                }).withErrorListener{
                    Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
                } as Dexter
        }
        dexter!!.check()
    }
    private val REQUEST_PICK_IMAGE=1
    private fun openGallery() {
        //getPermission()
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_PICK_IMAGE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_PICK_IMAGE -> {
                    val imageUri = data?.data
                    binding.imageview.setImageURI(imageUri)
                    // val add=getaddimage(imageUri)
//                    val file = imageUri!!.path?.let { File(it) } //create path from uri
//
//                  val split: List<String> = file!!.getPath().split(":") //split the path.
                    //updateadapter(MessageType.PHOTO, imageUri!!,audioFile!!)
  // Handle the selected image
                   // Toast.makeText(this,"Done picking Image  ${imageUri.toString()} ",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}