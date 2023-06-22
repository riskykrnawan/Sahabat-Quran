package com.example.sahabatquran.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatquran.presentation.navigation.NavGraph
import com.example.sahabatquran.presentation.ui.theme.SahabatQuranTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SahabatQuranTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}