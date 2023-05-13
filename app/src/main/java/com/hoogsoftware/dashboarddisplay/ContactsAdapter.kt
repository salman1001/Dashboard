package com.hoogsoftware.dashboarddisplay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.random.nextInt

class ContactsAdapter (
    private var courseList: List<ContactsModel>
) : RecyclerView.Adapter<ContactsAdapter.CallLogsViewModel>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CallLogsViewModel {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.itemviewpager,
            parent, false
        )


        return CallLogsViewModel(itemView)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<ContactsModel>) {
        // below line is to add our filtered
        // list in our course array list.
        courseList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }
    fun getLastNCharsOfString(str: String, n: Int): String? {
        var lastnChars = str
        if (lastnChars.length > n) {
            lastnChars = lastnChars.substring(lastnChars.length - n, lastnChars.length)
        }
        return lastnChars
    }
    var listOfColor= listOf<Int>(R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,R.color.color7
        ,R.color.color8,R.color.color9,R.color.color10,R.color.color11,R.color.color12,R.color.color13,R.color.color14)

    override fun onBindViewHolder(holder: CallLogsViewModel, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.name.setImageResource(courseList.get(position).image)



//        holder.courseIV.setTextColor(ContextCompat.getColor(context,listOfColor.get(Random.nextInt(listOfColor.indices) )))


    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return courseList.size
    }

    class CallLogsViewModel(itemView: View) : RecyclerView.ViewHolder(itemView){
        // on below line we are initializing our course name text view and our image view.
        val name: ImageView = itemView.findViewById(R.id.imagepager)



    }
}