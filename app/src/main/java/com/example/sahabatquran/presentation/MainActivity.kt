package com.example.sahabatquran.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sahabatquran.presentation.components.BottomNavigationBar
import com.example.sahabatquran.presentation.navigation.NavGraph
import com.example.sahabatquran.presentation.navigation.Screen
import com.example.sahabatquran.presentation.ui.theme.SahabatQuranTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SahabatQuranTheme {
                SahabatQuranApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SahabatQuranApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    if (navBackStackEntry?.destination?.route == Screen.Splash.route) {
        Scaffold(
            content = {
                Box(modifier = Modifier.padding(it)) {
                    NavGraph(navController = navController)
                }
            }
        )
    } else {
        if (navBackStackEntry?.destination?.route != Screen.Splash.route) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                "Sahabat Quran",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description"
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Outlined.Settings,
                                    contentDescription = "Localized description"
                                )
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomNavigationBar()
                },
                content = {
                    Box(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(it)
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SahabatQuranAppPreview() {
    SahabatQuranTheme {
        SahabatQuranApp()
    }
}