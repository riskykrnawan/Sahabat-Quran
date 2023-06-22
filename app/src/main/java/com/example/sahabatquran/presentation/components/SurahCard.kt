package com.example.sahabatquran.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sahabatquran.R
import com.example.sahabatquran.presentation.ui.theme.SahabatQuranTheme

@Composable
fun SurahCard(modifier: Modifier = Modifier) {
    Column {
        ListItem(
            headlineContent = { Text("Al-Fatihah") },
            supportingContent = { Text("The Opener • 7 Ayahs") },
            trailingContent = {
                Text(
                    color = MaterialTheme.colorScheme.primary,
                    text = "الفاتحة",
                    style = MaterialTheme.typography.titleLarge
                )
            },
            leadingContent = {
                Box(modifier = Modifier.size(48.dp), contentAlignment = Alignment.Center) {
                    Image(
                        modifier = modifier.matchParentSize(),
                        painter = painterResource(id = R.drawable.ic_ayah_24),
                        contentDescription = "Number of ayah",
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
                    )
                    Text(
                        text = "1",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        )
        Divider()
    }
}

@Preview(showBackground = false)
@Composable
fun SurahCardPreview() {
    SahabatQuranTheme {
        SurahCard()
    }
}