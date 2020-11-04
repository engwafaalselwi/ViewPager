package com.example.viewpager

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class PageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        if (page.tag == 0) {

        } else if (page.tag == 1) {

        }
    }

}