package com.jetpack.assignmentfiveparttwo

import androidx.compose.runtime.mutableStateOf

object ThemeManager {
    // null represents "System Default"
    // true represents "Dark Mode"
    // false represents "Light Mode"
    val isDarkTheme = mutableStateOf<Boolean?>(null)
}
