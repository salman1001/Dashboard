package com.hoogsoftware.dashboarddisplay.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hoogsoftware.dashboarddisplay.R
import com.hoogsoftware.dashboarddisplay.model.CallLogsModel
import com.makeramen.roundedimageview.RoundedImageView

class CallLogsAdapter(var context: Context, var chapterlist:List<CallLogsModel>):
    RecyclerView.Adapter<CallLogsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chaptername: TextView? = null
        var chapterimage: ImageView?=null



        init {
            chaptername = itemView.findViewById(R.id.number1) as TextView
         //  chapterimage=itemView.findViewById(R.id.imag_chapter) as RoundedImageView

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_call_logs, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.chaptername!!.text = chapterlist[position].string

    }

    override fun getItemCount(): Int {
        return chapterlist.size
    }

}