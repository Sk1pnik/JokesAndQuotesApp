package com.skipnik.jokeapp.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.skipnik.jokeapp.core.presentation.EnableView
import com.skipnik.jokeapp.core.presentation.ShowImage
import com.skipnik.jokeapp.core.presentation.ShowText
import com.skipnik.jokeapp.core.presentation.ShowView

class CorrectTextView : androidx.appcompat.widget.AppCompatTextView, ShowText {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun show(arg: String) {
        text = arg
    }
}

class CorrectButton : androidx.appcompat.widget.AppCompatButton, EnableView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun enable(enable: Boolean) {
        isEnabled = enable
    }
}

class CorrectImageButton : androidx.appcompat.widget.AppCompatImageButton, ShowImage {
    //region constructors
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    //endregion
    override fun show(arg: Int) {
        setImageResource(arg)
    }
}

class CorrectProgress : ProgressBar, ShowView {
    //region constructors
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    //endregion
    override fun show(arg: Boolean) {
        visibility = if (arg) View.VISIBLE else View.INVISIBLE
    }
}