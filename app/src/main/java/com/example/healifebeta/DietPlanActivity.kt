package com.example.healifebeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healifebeta.ui.theme.HealifeBetaTheme

class DietPlanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealifeBetaTheme {
                DietPlanScreen()
            }
        }
    }
}

@Composable
fun DietPlanScreen() {
    Scaffold(
        topBar = { DietPlanTopBar() },
        bottomBar = { DietPlanBottomBar() }
    ) { innerPadding ->
        DayList(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun DietPlanTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8F3DC)) // Light Mint background
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .padding(top = 24.dp), // Status bar spacing
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Days",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E8B57)
        )
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "Messages",
            modifier = Modifier.size(32.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun DayList(modifier: Modifier = Modifier) {
    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        items(days) { day ->
            DayCard(day)
        }
    }
}

@Composable
fun DayCard(day: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD8F3DC) // Light Mint
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = day,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF2E8B57)
            )
        }
    }
}

@Composable
fun DietPlanBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8F3DC))
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // These icons are placeholders. For the actual app, you should use painterResource with your own assets.
        Icon(imageVector = Icons.Default.Restaurant, contentDescription = "Diet", tint = Color.Gray, modifier = Modifier.size(40.dp))

        Surface(
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 4.dp,
            modifier = Modifier.size(64.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Grocery",
                    tint = Color(0xFF2E8B57), // Green to match theme
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Icon(imageVector = Icons.Default.Person, contentDescription = "Chef", tint = Color.Gray, modifier = Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DietPlanScreenPreview() {
    HealifeBetaTheme {
        DietPlanScreen()
    }
}