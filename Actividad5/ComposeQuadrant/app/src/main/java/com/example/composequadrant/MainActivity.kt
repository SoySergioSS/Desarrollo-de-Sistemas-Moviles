package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import com.example.composequadrant.ui.theme.rosa1
import com.example.composequadrant.ui.theme.rosa2
import com.example.composequadrant.ui.theme.rosa3
import com.example.composequadrant.ui.theme.rosa4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantCard(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuadrantCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            SingleCard(
                color = rosa1,
                title = stringResource(R.string.title_one_text),
                description = stringResource(R.string.description_one_text),
                modifier = Modifier.weight(1f)
            )
            SingleCard(
                color = rosa2,
                title = stringResource(R.string.title_two_text),
                description = stringResource(R.string.description_two_text),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            SingleCard(
                color = rosa3,
                title = stringResource(R.string.title_three_text),
                description = stringResource(R.string.description_three_text),
                modifier = Modifier.weight(1f)
            )
            SingleCard(
                color = rosa4,
                title = stringResource(R.string.title_four_text),
                description = stringResource(R.string.description_four_text),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SingleCard(
    color: Color,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color)
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantCard()
    }
}