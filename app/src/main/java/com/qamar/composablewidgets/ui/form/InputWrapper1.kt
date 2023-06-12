package com.qamar.composablewidgets.ui.form

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

enum class ValidationType {
    Text, Phone, Email, Password
}

data class InputWrapper (
    var inputValue: MutableState<String> = mutableStateOf(""),
    var borderColor: String = "#FFFFFF",
    val validationType: ValidationType? = ValidationType.Text
) {
    var validationMessage: String? = ""
    fun onValueChange(input: String) {
        inputValue.value = input
        val errorMessage = when (validationType){
              ValidationType.Email -> "your validation message"
              ValidationType.Phone -> "your validation message"
              ValidationType.Text -> "your validation message"
              ValidationType.Password -> "your validation message"
              else-> "your validation message"
          }
        if (errorMessage.isNotEmpty()) {
            validationMessage = errorMessage
            borderColor = "#EF4B5F" // make border red if input is not valid
        } else {
            validationMessage = ""
            borderColor = "#F2F2F2"// make border gray if input is valid
        }
    }
}