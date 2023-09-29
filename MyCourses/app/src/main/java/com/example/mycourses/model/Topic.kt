package com.example.mycourses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicResourceId: Int,
    val coursesResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
