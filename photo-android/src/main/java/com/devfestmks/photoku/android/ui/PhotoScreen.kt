package com.devfestmks.photoku.android.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devfestmks.photoku.android.ui.components.WhiteStatusBar
import com.devfestmks.photoku.getPlatform

@Composable
fun PhotosScreen() {

    WhiteStatusBar()

    Text("Hello, " + getPlatform().appPlatform)
}