package com.el3asas.edit_card


object CardPattern {
    // VISA
    const val VISA: String = "4[0-9]{12}(?:[0-9]{3})?"
    const val VISA_VALID: String = "^4[0-9]{12}(?:[0-9]{3})?$"

    // MasterCard
    const val MASTERCARD: String =
        "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$"
    const val MASTERCARD_SHORT: String =
        "^(?:222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)"
    const val MASTERCARD_SHORTER: String = "^(?:5[1-5])"
    const val MASTERCARD_VALID: String =
        "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$"

    // American Express
    const val AMERICAN_EXPRESS: String = "^3[47][0-9]{0,13}"
    const val AMERICAN_EXPRESS_VALID: String = "^3[47][0-9]{13}$"

    // DISCOVER
    const val DISCOVER: String = "^6(?:011|5[0-9]{1,2})[0-9]{0,12}"
    const val DISCOVER_SHORT: String = "^6(?:011|5)"
    const val DISCOVER_VALID: String = "^6(?:011|5[0-9]{2})[0-9]{12}$"

    // JCB
    const val JCB: String = "^(?:2131|1800|35\\d{0,3})\\d{0,11}$"
    const val JCB_SHORT: String = "^2131|1800"
    const val JCB_VALID: String = "^(?:2131|1800|35\\d{3})\\d{11}$"

    // Discover
    const val DINERS_CLUB: String = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"
    const val DINERS_CLUB_SHORT: String = "^30[0-5]"
    const val DINERS_CLUB_VALID: String = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"
}
