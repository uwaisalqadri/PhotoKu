package com.devfestmks.photoku.android.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WhiteStatusBar() {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = Color.White
    )
}