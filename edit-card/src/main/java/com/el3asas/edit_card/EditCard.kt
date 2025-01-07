package com.el3asas.edit_card

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.Spanned
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Pattern

class EditCard : AppCompatEditText {
    var cardType: String = "UNKNOWN"

    constructor(context: Context) : super(context) {
        addMagic()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        addMagic()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        addMagic()
    }

    private fun addMagic() {
        // Changing the icon when it's empty
        changeIcon()
        // Adding the TextWatcher
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, position: Int, before: Int, action: Int) {
                if (action == 1) {
                    if (cardType == "UNKNOWN" || cardType == "Visa" || cardType == "Discover" || cardType == "JCB") {
                        if (position == 3 || position == 8 || position == 13) {
                            if (!s.toString().endsWith("-")) {
                                append("-")
                            }
                        }
                    } else if (cardType == "American_Express" || cardType == "Diners_Club") {
                        if (position == 3 || position == 10) {
                            if (!s.toString().endsWith("-")) {
                                append("-")
                            }
                        }
                    }
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                changeIcon()
            }
        })
        // The input filters
        val filter: InputFilter = object : InputFilter {
            override fun filter(
                source: CharSequence?, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int
            ): CharSequence? {
                (start..<end).forEach { i ->
                    if (!Pattern.compile("[0-9\\-]*").matcher(source.toString()).matches()) {
                        return ""
                    }
                }
                return null
            }
        }
        // Setting the filters
        filters = arrayOf<InputFilter>(filter, LengthFilter(19))
    }

    private fun changeIcon() {
        val s = getText().toString().replace("-", "").trim { it <= ' ' }
        when {
            s.startsWith("4") || s.matches(CardPattern.VISA.toRegex()) -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.vi, 0)
                this.cardType = "Visa"
            }

            s.matches(CardPattern.MASTERCARD_SHORTER.toRegex()) || s.matches(CardPattern.MASTERCARD_SHORT.toRegex()) || s.matches(
                CardPattern.MASTERCARD.toRegex()
            )
                -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.mc, 0)
                this.cardType = "MasterCard"
            }

            s.matches(CardPattern.AMERICAN_EXPRESS.toRegex()) -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.am, 0)
                this.cardType = "American_Express"
            }

            s.matches(CardPattern.DISCOVER_SHORT.toRegex()) || s.matches(CardPattern.DISCOVER.toRegex()) -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ds, 0)
                this.cardType = "Discover"
            }

            s.matches(CardPattern.JCB_SHORT.toRegex()) || s.matches(CardPattern.JCB.toRegex()) -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.jcb, 0)
                this.cardType = "JCB"
            }

            s.matches(CardPattern.DINERS_CLUB_SHORT.toRegex()) || s.matches(CardPattern.DINERS_CLUB.toRegex()) -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dc, 0)
                this.cardType = "Diners_Club"
            }

            else -> {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.card, 0)
                this.cardType = "UNKNOWN"
            }
        }
    }

    val cardNumber: String
        get() = getText().toString().replace("-", "").trim { it <= ' ' }

    val isValid: Boolean
        get() {
            if (this.cardNumber.matches(CardPattern.VISA_VALID.toRegex())) return true
            if (this.cardNumber.matches(CardPattern.MASTERCARD_VALID.toRegex())) return true
            if (this.cardNumber.matches(CardPattern.AMERICAN_EXPRESS_VALID.toRegex())) return true
            if (this.cardNumber.matches(CardPattern.DISCOVER_VALID.toRegex())) return true
            if (this.cardNumber.matches(CardPattern.DINERS_CLUB_VALID.toRegex())) return true
            if (this.cardNumber.matches(CardPattern.JCB_VALID.toRegex())) return true
            return false
        }
}