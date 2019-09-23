package com.example.reckotlin

import android.animation.AnimatorSet
import android.animation.ObjectAnimator

import androidx.recyclerview.widget.RecyclerView

object AnimationUtil {

    fun animate(holder: RecyclerView.ViewHolder, goesDown: Boolean) {

        val animatorSet = AnimatorSet()

        val objectAnimator =
            ObjectAnimator.ofFloat(holder.itemView, "translationY", if (goesDown) 200f else -200f, 0f)
        objectAnimator.setDuration(1000)

        animatorSet.playTogether(objectAnimator)
        animatorSet.start()

    }

}
