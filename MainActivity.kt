package com.example.vainafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview(){
    Home()
}

@Composable
fun Home(){
    val participantes = listOf(
        "Sherlock Holmes",
        "Ellen Ripley",
        "Indiana Jones",
        "Leia Organa",
        "Neil Armstrong",
        "Ada Lovelace",
        "Steve Jobs",
        "Marie Curie"
    )

    var vencedores by remember { mutableStateOf(emptyList<String>()) }

    fun sorteio(){
        val sorteados = participantes.shuffled().take(3)
        vencedores = sorteados
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "App de Sorteio",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        Button(
            onClick = {
                sorteio()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF009688)
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text(
                text = "Realizar Sorteio",
                color = Color.White,
                fontSize = 18.sp
            )
        }
        if (vencedores.isNotEmpty()) {
            vencedores.forEachIndexed { index, vencedor ->
                Text(
                    text = "Vencedor ${index + 1}: $vencedor",
                    fontSize = 18.sp,
                    color = Color(0xFF009688),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}