package com.yong.yongcalculator

import android.graphics.Color
import android.graphics.Rect
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

class MyDecoration(): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(10,10,10,10)

        view.setBackgroundColor(Color.parseColor("#f3f3f3"))
        ViewCompat.setElevation(view, 20.0f)
    }
}