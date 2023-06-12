package com.qamar.composablewidgets.ui.form

import androidx.compose.runtime.mutableStateOf

data class ContactFormState(
    val mobile: InputWrapper = InputWrapper(
        validationType = ValidationType.Phone
    ),
    val name: InputWrapper = InputWrapper(
        validationType = ValidationType.Text
    ),
    val email: InputWrapper = InputWrapper(
        validationType = ValidationType.Email
    ),
    val password: InputWrapper = InputWrapper(
        validationType = ValidationType.Password
    )
) {
    fun isSendEnabled() =
                   name.inputValue.value.isNotEmpty()
                && name.validationMessage.isNullOrEmpty()
                && mobile.inputValue.value.isNotEmpty()
                && mobile.validationMessage.isNullOrEmpty()
                && email.inputValue.value.isNotEmpty()
                && email.validationMessage.isNullOrEmpty()
}