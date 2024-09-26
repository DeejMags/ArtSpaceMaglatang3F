package com.example.artspacemaglatangrodrigon3f

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpaceArtDisplay() {
    val config = LocalConfiguration.current
    when (config.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            artSpaceDisplayLandscape()
        }
        else -> {
            artSpaceDisplayPortrait()
        }
    }
}

@Composable
fun artSpaceDisplayLandscape() {
    var currentImage by remember { mutableStateOf(0) }

    val images = listOf(
        Pair(R.drawable.milesmorales, R.string.first_image),
        Pair(R.drawable.spider_man_photography, R.string.second_image),
        Pair(R.drawable.playstationspiderman, R.string.third_image),
        Pair(R.drawable.theamazingspiderman, R.string.fourth_image)
    )

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.35f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtworkNavigationButtons(
                currentIndex = currentImage,
                onPreviousClick = { currentImage = (currentImage - 1).takeIf { it >= 0 } ?: images.size - 1 },
                onNextClick = { currentImage = (currentImage + 1) % images.size }
            )
        }

        ArtworkDisplay(
            imageRes = images[currentImage].first,
            descriptionRes = images[currentImage].second
        )
    }
}

@Composable
fun artSpaceDisplayPortrait() {
    var currentImage by remember { mutableStateOf(0) }

    val images = listOf(
        Pair(R.drawable.milesmorales, R.string.first_image),
        Pair(R.drawable.spider_man_photography, R.string.second_image),
        Pair(R.drawable.playstationspiderman, R.string.third_image),
        Pair(R.drawable.theamazingspiderman, R.string.fourth_image)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkDisplay(
            imageRes = images[currentImage].first,
            descriptionRes = images[currentImage].second
        )

        ArtworkNavigationButtons(
            currentIndex = currentImage,
            onPreviousClick = { currentImage = (currentImage - 1).takeIf { it >= 0 } ?: images.size - 1 },
            onNextClick = { currentImage = (currentImage + 1) % images.size }
        )
    }
}

@Composable
fun ArtworkDisplay(@DrawableRes imageRes: Int, @StringRes descriptionRes: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(400.dp)
            .border(BorderStroke(3.dp, SolidColor(Color.White)), RectangleShape)
            .shadow(10.dp, RectangleShape),
        shape = RoundedCornerShape(5.dp),
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(id = descriptionRes),
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(15.dp)
        )
    }

    Spacer(modifier = Modifier.height(10.dp))

    Surface(
        modifier = Modifier.fillMaxWidth(0.9f),
        color = Color(0xFFECEBF4)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = stringResource(id = descriptionRes),
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(id = R.string.author),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " (" + stringResource(id = R.string.year) + ")",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun ArtworkNavigationButtons(
    currentIndex: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onPreviousClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(73, 93, 146)),
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = "Previous", color = Color.White)
        }

        Button(
            onClick = onNextClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(73, 93, 146)),
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = "Next", color = Color.White)
        }
    }
}