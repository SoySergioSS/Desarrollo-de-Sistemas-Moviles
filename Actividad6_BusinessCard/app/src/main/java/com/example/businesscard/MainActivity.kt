package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPrincipal(
                        stringResource(R.string.name),
                        stringResource(R.string.description),
                        stringResource(R.string.logout),
                        stringResource(R.string.cardholder),
                        stringResource(R.string.type),
                        stringResource(R.string.balance),
                        stringResource(R.string.last_trip),
                        stringResource(R.string.starting_station),
                        stringResource(R.string.final_station),
                        stringResource(R.string.date_and_time),
                        stringResource(R.string.top_up),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(
    name: String,
    description: String,
    logout: String,
    cardholder: String,
    type: String,
    balance: String,
    last_trip: String,
    starting_station: String,
    final_station: String,
    date_and_time: String,
    top_up: String,
    modifier: Modifier = Modifier
) {
    Box() {
        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = null,
            alpha = 0.7f,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 5.dp,
                    vertical = 20.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Header(name, description, logout)

            Spacer(modifier = Modifier.height(12.dp))

            DatosUsuario(cardholder, type)

            Spacer(modifier = Modifier.height(12.dp))

            Saldo(balance)

            Spacer(modifier = Modifier.height(12.dp))

            UltimoViaje(
                last_trip,
                starting_station,
                final_station,
                date_and_time
            )

            Spacer(modifier = Modifier.height(16.dp))

            Footer(top_up)
        }
    }
}

@Composable
fun Header(
    name: String,
    description: String,
    logout: String,
    modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 5.dp,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.lima_metro_linea_1_svg),
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier.padding(start = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = description,
                    fontSize = 20.sp
                )
            }
        }

        Button(
            onClick = { /* acción de cerrar sesión */ },
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
            modifier = Modifier.width(120.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logout),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
            )
            Text(
                text = logout,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun DatosUsuario(
    cardholder: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .padding(end = 3.dp)
                .clip(CircleShape)
                .border(2.dp, Color.White, CircleShape)

        )
        Text(
            text = "$cardholder: Sergio Marcos Juarez",
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "$type: Medio pasaje",
            fontSize = 25.sp
        )
    }
}

@Composable
fun Saldo(
    balance: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "$balance: 12.56",
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.padding(16.dp)
            .background(color = Color.Yellow)
    )
}

@Composable
fun UltimoViaje(
    last_trip: String,
    starting_station: String,
    final_station: String,
    date_and_time: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "$last_trip:",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            InfoRow(starting_station, "San Juan")
            InfoRow(final_station, "La cultura")
            InfoRow(date_and_time, "27-08-2025")
        }
    }
}

@Composable
private fun InfoRow(text: String, text2: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp) // un poco de aire entre filas
    ) {
        Image(
            painter = painterResource(R.drawable.chevron_right_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(Color.Gray)
        )
        Spacer(modifier = Modifier.width(8.dp)) // espacio entre icono y texto
        Text(
            text = "$text: $text2",
            fontSize = 24.sp
        )
    }
}

@Composable
fun Footer(
    top_up: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = { /* acción de recargar */ },
            contentPadding = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.paid),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = top_up,
                fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        PantallaPrincipal(
           stringResource(R.string.name),
            stringResource(R.string.description),
            stringResource(R.string.logout),
            stringResource(R.string.cardholder),
            stringResource(R.string.type),
        stringResource(R.string.balance),
        stringResource(R.string.last_trip),
        stringResource(R.string.starting_station),
        stringResource(R.string.final_station),
        stringResource(R.string.date_and_time),
        stringResource(R.string.top_up)
        )
    }
}