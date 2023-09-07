package com.example.chatapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainChatsAdapter(private val list: List<mainChats>, private val context: Context) :
    RecyclerView.Adapter<MainChatsAdapter.MainChatsViewHolder>() {

    class MainChatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.mainChatsProfile_Uname)
        val chatsNumber: TextView = itemView.findViewById(R.id.UnreadChatsNumber)
        val image: ImageView = itemView.findViewById(R.id.mainChatsProfile_Uimage)
        val unreadLayout: LinearLayout = itemView.findViewById(R.id.unreadChatsLlayout)
        val lastseenLayout: LinearLayout = itemView.findViewById(R.id.lastSeenLayout)
        val arrowImg: ImageView = itemView.findViewById(R.id.dropUpDownIcon)
        val hiddenCardView: LinearLayout = itemView.findViewById(R.id.hiddenCardView)
        val btn_send: CardView = itemView.findViewById(R.id.btnSend)
        val online_layout: LinearLayout = itemView.findViewById(R.id.onlineLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainChatsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.chats_item_layout, parent, false)
        return MainChatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainChatsViewHolder, position: Int) {
        var show = true
        val currentPosition = list[position]
        holder.name.text = currentPosition.userName
        holder.image.setImageResource(currentPosition.userImage)
        if (currentPosition.unreadChats == 0) {
            if (currentPosition.isOnline) {
                holder.online_layout.visibility = View.VISIBLE
                holder.unreadLayout.visibility = View.GONE
            } else {
                holder.lastseenLayout.visibility = View.VISIBLE
                holder.unreadLayout.visibility = View.GONE
            }
        } else {
            holder.chatsNumber.text = currentPosition.unreadChats.toString()
        }
        holder.arrowImg.setOnClickListener { 
            if (show){
                Toast.makeText(context, "arrow ${position+1}", Toast.LENGTH_SHORT).show()
                holder.arrowImg.setImageResource(R.drawable.uparrow)
                holder.hiddenCardView.visibility = View.VISIBLE
                show = false
            }else{
                holder.arrowImg.setImageResource(R.drawable.downarrow)
                holder.hiddenCardView.visibility = View.GONE
                show = true
            }
        }
        holder.btn_send.setOnClickListener {
            Toast.makeText(context, "clicked ${position+1}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
//holder.arrowImg.setOnClickListener {
//    if (show) {
//        holder.arrowImg.setImageResource(R.drawable.uparrow)
//        holder.hiddenCardView.visibility = View.VISIBLE
//        show = false
//    }else{
//        holder.arrowImg.setImageResource(R.drawable.downarrow)
//        holder.hiddenCardView.visibility = View.GONE
//        show = true
//    }
//}
//holder.btn_send.setOnClickListener {
//    Toast.makeText(context, "clicked ${position+1}", Toast.LENGTH_SHORT).show()
//}
