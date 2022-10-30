package com.qamar.composablewidgets.ui.sendemail

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SendEmailExample(){
    val ctx = LocalContext.current
    Button(onClick = {
        val i = Intent(Intent.ACTION_SEND)
        // on below line we are passing email address,
        // email subject and email body
        i.putExtra(Intent.EXTRA_EMAIL,"test@gmailc.om")
        i.putExtra(Intent.EXTRA_SUBJECT,"Test From Compose")
        i.putExtra(Intent.EXTRA_TEXT,"This is a test email from compose")
        i.type = "message/rfc822"

        // on the below line we are starting our activity to open email application.
        ctx.startActivity(Intent.createChooser(i,"Choose an Email client : "))

    }) {
        // on the below line creating a text for our button.
        Text(
            // on below line adding a text ,
            // padding, color and font size.
            text = "Send Email",
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            fontSize = 15.sp
        )
    }
}