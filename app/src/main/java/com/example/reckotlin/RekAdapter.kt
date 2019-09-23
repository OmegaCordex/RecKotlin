package com.example.reckotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RekAdapter : RecyclerView.Adapter<RekAdapter.ViewHolder>() {

    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_card, parent, false)

        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class ViewHolder(itemView: View, listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        init {

            itemView.setOnClickListener {
                if (listener != null) {

                    val position = adapterPosition

                    if (position != RecyclerView.NO_POSITION) {

                        listener.onItemClick(position)
                    }

                }
            }


        }
    }
}
