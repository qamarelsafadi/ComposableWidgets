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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.qamar.composablewidgets.utils.ComposeFileProvider

@Composable
fun ImagePicker(
) {
    val context = LocalContext.current

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var isImageCaptured by remember {
        mutableStateOf<Boolean>(false)
    }

    val imagePicker = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            isImageCaptured = true
            imageUri = uri
        }
    )
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            // to track if image is captured or not
            isImageCaptured = success
        }
    )


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        if (imageUri != null && isImageCaptured) {
            // I used Coil to implement uri in image you can convert uri to Bitmap or use Coil
                //     implementation("io.coil-kt:coil-compose:2.2.2")
            AsyncImage(
                model = imageUri,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
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
                    // make it false to re trigger once we re take an image
                    isImageCaptured = false
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Select Image"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    // make it false to re trigger once we re take an image
                    isImageCaptured = false

                    // get our image temp URI
                    val uri = ComposeFileProvider.getImageUri(context)
                    imageUri = uri
                    cameraLauncher.launch(uri)
                },
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Take Photo "
                )
            }
        }
    }
}