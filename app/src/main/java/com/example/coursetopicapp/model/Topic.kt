package com.example.coursetopicapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @DrawableRes val topicImage: Int,
    @StringRes val topicName: Int,
    val numberOfCourses: Int
    )
