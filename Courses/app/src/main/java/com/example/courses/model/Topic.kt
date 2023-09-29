package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId_name: Int,
    val stringResourceId_courses: Int,
    @DrawableRes val imageResourceId: Int,
)
