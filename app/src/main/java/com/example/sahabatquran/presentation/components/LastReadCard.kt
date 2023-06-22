package com.example.sahabatquran.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahabatquran.R
import com.example.sahabatquran.presentation.ui.theme.SahabatQuranTheme

@Composable
fun LastReadCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(190.dp)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.tertiary,
                    )
                )
            )
            .fillMaxWidth()
            .padding(24.dp),
    ) {
        Column {
            Row {
                Image(
                    modifier = modifier.width(24.dp),
                    painter = painterResource(R.drawable.ic_quran_24),
                    contentDescription = "Card Quran Icon",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary),
                )
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = "Last Read",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
            Row {
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp, top = 16.dp)
                        .alpha(alpha = 0.85f),
                    painter = painterResource(R.drawable.ic_quran_kareem),
                    contentDescription = "Quran Image",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary),
                )
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Text(
                        text = "An-Nisa (The Women)",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                    Spacer(modifier = modifier.height(8.dp))
                    Text(
                        text = "Ayah No: 1",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Row {
                Text(
                    lineHeight = 24.sp,
                    text = "Continue reading",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                Image(
                    painter = painterResource(R.drawable.ic_right_24),
                    contentDescription = "Banner Image",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary),
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun LastReadCardPreview() {
    SahabatQuranTheme {
        LastReadCard()
    }
}