package com.devfestmks.photoku.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devfestmks.photoku.android.R
import com.devfestmks.photoku.android.ui.components.PhotoRow
import com.devfestmks.photoku.android.ui.components.WhiteStatusBar
import com.devfestmks.photoku.presentation.PhotoEvent
import com.devfestmks.photoku.presentation.PhotoViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PhotosScreen() {
    val viewModel: PhotoViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    WhiteStatusBar()
    
    viewModel.onTriggerEvent(PhotoEvent.GetPhotos)

    LazyVerticalStaggeredGrid(
        modifier = Modifier.background(Color.White),
        columns = StaggeredGridCells.Fixed(2)
    ) {
        item {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.app_title),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp)
                )
            }
        }

        items(items = state.photos) { photo ->
            PhotoRow(
                photo = photo,
                modifier = Modifier.padding(all = 6.dp)
            )
        }
    }
}