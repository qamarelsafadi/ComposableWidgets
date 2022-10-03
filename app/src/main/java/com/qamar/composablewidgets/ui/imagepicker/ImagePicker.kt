package com.qamar.composablewidgets.ui.imagepicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImagePicker(
) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    // Step 1
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            imageUri = uri
        }
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (imageUri != null) {
            // I used Coil to implement uri in image you can convert uri to Bitmap or use Coil
                //     implementation("io.coil-kt:coil-compose:2.2.2")
            AsyncImage(
                model = imageUri,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Selected image",
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Select Image"
                )
            }
        }
    }
}