package com.example.sahabatquran.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.sahabatquran.presentation.components.model.BottomBarItem
import com.example.sahabatquran.R

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf(
        BottomBarItem("Al-Quran", painterResource(id = R.drawable.ic_quran_24)),
        BottomBarItem("Learn Quran", painterResource(id = R.drawable.ic_quran_24)),
        BottomBarItem("Tajwid List", painterResource(id = R.drawable.ic_quran_24)),
        BottomBarItem("Hadith", painterResource(id = R.drawable.ic_quran_24)),
    )

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = { Text(item.label) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}