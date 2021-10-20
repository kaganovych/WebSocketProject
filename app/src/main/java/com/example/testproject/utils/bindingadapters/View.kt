package com.example.testproject.utils.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.example.testproject.ui.widget.CircleView

@BindingConversion
fun visibleOrGone(expression: Boolean?): Int {
    return if (expression == true) View.VISIBLE else View.GONE
}

@BindingAdapter("setCircleBackground")
fun CircleView.setInnerBackground(color: String) {
    setCircleBackground(color)
}