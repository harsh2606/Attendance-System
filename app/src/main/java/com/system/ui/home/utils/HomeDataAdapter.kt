package com.system.ui.home.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.system.R
import com.system.databinding.ItemSideMenuBinding

class HomeDataAdapter() : RecyclerView.Adapter<HomeDataAdapter.MyViewHolder>() {

    private lateinit var mEventListener: EventListener

    private var data = mutableListOf<String>()
    lateinit var context: Context
    var isClickable = true


    constructor(context: Context) : this() {
        this.context = context
    }

    fun setEventListener(eventListener: EventListener) {
        mEventListener = eventListener
    }


    interface EventListener {
        fun onItemClick(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemBinding = DataBindingUtil.inflate<ItemSideMenuBinding>(
            inflater,
            R.layout.item_side_menu, parent, false
        )
        return MyViewHolder(itemBinding)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    fun getItem(p: Int): String {
        return data[p]

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.setIsRecyclable(false)
//        val item = getItem(position)
        try {

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

        if (isClickable) {
            holder.itemBinding.root.setOnClickListener {
                mEventListener.onItemClick(position)
            }
        }
    }

    fun addAll(mData: List<String>) {
        data.clear()
        data.addAll(mData)
        notifyDataSetChanged()
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    inner class MyViewHolder(internal var itemBinding: ItemSideMenuBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}