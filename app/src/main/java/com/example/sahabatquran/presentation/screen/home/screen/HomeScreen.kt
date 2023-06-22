package com.example.sahabatquran.presentation.screen.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sahabatquran.R
import com.example.sahabatquran.presentation.components.LastReadCard
import com.example.sahabatquran.presentation.components.Search
import com.example.sahabatquran.presentation.components.SurahCard
import com.example.sahabatquran.presentation.components.model.TabLayoutItem
import com.example.sahabatquran.presentation.ui.theme.SahabatQuranTheme

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Banner()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(0) }
    val items = listOf(
        TabLayoutItem(stringResource(R.string.surah), painterResource(id = R.drawable.ic_quran_24)),
        TabLayoutItem(
            stringResource(R.string.bookmarks),
            painterResource(id = R.drawable.ic_bookmarks_24)
        )
    )

//    val indicator = @Composable { tabPositions: List<TabPosition> ->
//        FancyAnimatedIndicator(tabPositions = tabPositions, selectedTabIndex = state)
//    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        LastReadCard()
        Spacer(modifier = modifier.height(16.dp))
        Search()
        Spacer(modifier = modifier.height(16.dp))
        Column {
            TabRow(
                selectedTabIndex = state,
            ) {
                items.forEachIndexed { index, item ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = { Text(item.title) },
                        icon = {
                            Icon(
                                painter = item.icon,
                                contentDescription = item.title
                            )
                        }
                    )
                }
            }
            if (state == 0) {
                SurahCard()
                SurahCard()
                SurahCard()
                SurahCard()
                SurahCard()
                SurahCard()
            } else {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    text = stringResource(R.string.feature_not_available),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BannerPreview() {
    SahabatQuranTheme {
        Banner()
    }
}