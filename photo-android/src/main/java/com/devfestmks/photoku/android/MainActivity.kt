package com.devfestmks.photoku.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.devfestmks.photoku.android.ui.PhotosScreen
import com.devfestmks.photoku.android.ui.components.PhotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoTheme {
                PhotosScreen()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PhotoTheme {
        PhotosScreen()
    }
}
