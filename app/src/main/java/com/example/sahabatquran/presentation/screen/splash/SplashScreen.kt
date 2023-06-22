package com.example.sahabatquran.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sahabatquran.R
import com.example.sahabatquran.presentation.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    LaunchedEffect(true) {
        delay(3000)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier
                .width(100.dp)
                .height(100.dp),
            painter = painterResource(id = R.drawable.quran_kareem),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary),
            contentDescription = stringResource(R.string.splash_screen_al_quran),
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = stringResource(R.string.sahabat_quran),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium
        )
    }
}






