package com.example.sahabatquran.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sahabatquran.R
import com.example.sahabatquran.presentation.components.Search
import com.example.sahabatquran.presentation.ui.theme.SahabatQuranTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SahabatQuranTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Banner()
                }
            }
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            text = stringResource(R.string.al_quran)
        )
        Box(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.reading_surah)
        )
        Box(Modifier.height(16.dp))
        Search()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SahabatQuranTheme {
        Banner()
    }
}