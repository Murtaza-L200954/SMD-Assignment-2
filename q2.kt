package com.example.question2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp()
        }
    }
}

@Composable
fun WeatherApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar()
        Location()
        CurrentWeather()
        DateAndTime()
        CityIllustration()
        Spacer(modifier = Modifier.weight(1f)) // Spacer to push forecasts to the bottom
        Forecast()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text("Search") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Location() {
    Text("Mumbai", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun CurrentWeather() {
    Column {
        Text("28°C", style = MaterialTheme.typography.headlineLarge)
        Text("Sunny", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DateAndTime() {
    Text("13 Feb, Sat 02:00pm", style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun CityIllustration() {
    // Add your illustration here
}

data class WeatherForecast(val dayOfWeek: String, val condition: String, val highTemp: Int, val lowTemp: Int)

val weatherIcons: Map<String, Painter> = mapOf(
    "Cloudy" to painterResource(id = R.drawable.cloudy),
    "Sunny" to painterResource(id = R.drawable.sunny),
    "Rainy" to painterResource(id = R.drawable.rainy)    // Add more weather conditions and icons as needed
)

@Composable
fun Forecast() {
    val forecasts = listOf(
        WeatherForecast("Monday", "Sunny", 30, 20),
        WeatherForecast("Tuesday", "Cloudy", 28, 18),
        WeatherForecast("Wednesday", "Rainy", 25, 15),
        WeatherForecast("Thursday", "Sunny", 32, 22),
        WeatherForecast("Friday", "Cloudy", 30, 20)
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        forecasts.forEach { forecast ->
            ForecastItem(forecast)
        }
    }
}

@Composable
fun ForecastItem(forecast: WeatherForecast) {
    Column {
        Text(text = forecast.dayOfWeek)
        val weatherIcon = weatherIcons[forecast.condition] ?: Icons.Default.CloudQueue
        Icon(
            imageVector = weatherIcon,
            contentDescription = null // Replace with your own weather icons
        )
        Text(text = "${forecast.highTemp}° / ${forecast.lowTemp}°")
    }
}

@Preview
@Composable
fun WeatherAppPreview() {
    WeatherApp()
}
