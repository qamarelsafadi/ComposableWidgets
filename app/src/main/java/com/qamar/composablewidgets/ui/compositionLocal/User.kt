package com.qamar.composablewidgets.ui.compositionLocal

import androidx.compose.runtime.compositionLocalOf

data class User(val name: String, val age: Int)
val LocalActiveUser = compositionLocalOf<User> { error("No user found!") }