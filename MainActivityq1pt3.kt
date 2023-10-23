package com.example.q1part3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableInfoApp()
        }
    }
}

@Composable
fun ComposableInfoApp() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                ComposableQuadrant(1)
                ComposableQuadrant(2)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                ComposableQuadrant(3)
                ComposableQuadrant(4)
            }
        }
    }
}

@Composable
fun ComposableQuadrant(quadrantNumber: Int) {
    val colors = listOf(
        Color(0xFFEADDFF),
        Color(0xFFD0BCFF),
        Color(0xFFB69DF8),
        Color(0xFFF6EDFF)
    )

    val composableName = when (quadrantNumber) {
        1 -> "Text composable"
        2 -> "Image composable"
        3 -> "Row composable"
        4 -> "Column composable"
        else -> ""
    }

    val composableDescription = when (quadrantNumber) {
        1 -> "Displays text and follows the recommended Material Design guidelines."
        2 -> "Creates a composable that lays out and draws a given Painter class object."
        3 -> "A layout composable that places its children in a horizontal sequence."
        4 -> "A layout composable that places its children in a vertical sequence."
        else -> ""
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors[quadrantNumber - 1])
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = composableName,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = composableDescription,
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(bottom = 16.dp))
        }
    }
}

