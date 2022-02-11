package com.example.weatherapp.utils

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan

object TextUtils {

    internal fun formatMonthInYear(month: Int, year: Int): SpannableString {
        val monthInYear = "$year/$month"
        val formatMonthInYear = SpannableString(monthInYear)
        if (month < 10) {
            formatMonthInYear.setSpan(RelativeSizeSpan(0.8f), 0, formatMonthInYear.length - 1, 0)
            formatMonthInYear.setSpan(
                StyleSpan(Typeface.BOLD), formatMonthInYear.length - 1,
                formatMonthInYear.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        } else {
            formatMonthInYear.setSpan(RelativeSizeSpan(0.8f), 0, formatMonthInYear.length - 2, 0)
            formatMonthInYear.setSpan(
                StyleSpan(Typeface.BOLD), formatMonthInYear.length - 2,
                formatMonthInYear.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return formatMonthInYear
    }
}