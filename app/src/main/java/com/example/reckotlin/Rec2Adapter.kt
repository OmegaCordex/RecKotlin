package com.example.reckotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Rec2Adapter(var arrayName: Array<String>, var arrayNum: Array<String>) :
    RecyclerView.Adapter<Rec2Adapter.ViewHolder>() {

    var previousPosition : Int = 0

    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {

        fun onItemClick(v: View, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        var view = LayoutInflater.from(parent.context).inflate(R.layout.chv_card, parent, false)

        return ViewHolder(view, mListener)

    }

    override fun getItemCount(): Int {

        return arrayName.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvName.text = arrayName[position]
        holder.tvNum.text = arrayNum[position]

        if (position>previousPosition){

            AnimationUtil.animate(holder, true)

        }else{

            AnimationUtil.animate(holder, false)

        }

        previousPosition = position

    }

    class ViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById(R.id.textCHVname) as TextView
        val tvNum = itemView.findViewById(R.id.textCHVphone) as TextView

        init {

            itemView.setOnClickListener {
                if (listener != null) {

                    val position = adapterPosition

                    if (position != RecyclerView.NO_POSITION) {

                        listener.onItemClick(itemView, position)
                    }

                }
            }


        }

    }
}