package com.github.johnnysc.coremvvm.presentation.adapter

import android.content.Context
import android.util.AttributeSet

/**
 * @author Asatryan on 01.06.2022
 */
class MyTextView : androidx.appcompat.widget.AppCompatTextView, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun show(text: CharSequence) {
        setText(text)
    }

    override fun show(textId: Int) {
        setText(textId)
    }
}

abstract class MyImageView : androidx.appcompat.widget.AppCompatImageView, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun showImageResource(id: Int) {
        setImageResource(id)
    }
}

class MyCheckBox : androidx.appcompat.widget.AppCompatCheckBox, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun check(checked: Boolean) {
        isChecked = checked
    }

    override fun handleClick(listener: OnClickListener) = setOnClickListener(listener)
}

class MyButton : androidx.appcompat.widget.AppCompatButton, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun enable(enabled: Boolean) {
        isEnabled = enabled
    }

    override fun show(textId: Int) {
        setText(textId)
    }

    override fun show(text: CharSequence) {
        setText(text)
    }

    override fun handleClick(listener: OnClickListener) {
        setOnClickListener(listener)
    }
}