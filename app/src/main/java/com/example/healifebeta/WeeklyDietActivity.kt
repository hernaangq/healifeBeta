package com.example.healifebeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healifebeta.ui.theme.HealifeBetaTheme

class WeeklyDietActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealifeBetaTheme {
                WeeklyDietScreen()
            }
        }
    }
}

@Composable
fun WeeklyDietScreen() {
    Scaffold(
        topBar = {
            // Top Header "WEEKLY DIET"
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
                    text = "WEEKLY DIET",
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
        },
        bottomBar = {
            WeeklyDietBottomBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Introduction Text
            Text(
                text = "Plan your personalized diet according to your needs!",
                color = Color(0xFF2E8B57),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            // The Grid of 4 Options
            val options = listOf(
                DietOption("Workout\nschedule", Icons.Default.Face), // Placeholder icon for dumbbell
                DietOption("Cooking\ncomplexity", Icons.Default.Star),
                DietOption("Cooking\navailability", Icons.Default.DateRange), // Placeholder for clock
                DietOption("Batch cooking", Icons.Default.Home) // Placeholder for chef
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(options) { option ->
                    DietOptionCard(option)
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // "GET MY DIET!" Button
            Button(
                onClick = { /* TODO: Generate Diet Action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, Color(0xFF2E8B57)), // Green border
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "GET MY DIET!",
                    color = Color(0xFF2E8B57),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class DietOption(val title: String, val icon: ImageVector)

@Composable
fun DietOptionCard(option: DietOption) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD8F3DC) // Light Mint color
        ),
        modifier = Modifier
            .aspectRatio(1f) // Makes it a perfect square
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp) // Flat look
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = option.title,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Icon Logic
            if (option.title.contains("complexity")) {
                // Draw Stars for complexity
                Row {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Black
                        )
                    }
                }
            } else {
                // Standard Icon
                Icon(
                    imageVector = option.icon,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun WeeklyDietBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8F3DC))
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Icon (Not selected)
        NavIconCircle(selected = false, icon = Icons.Default.Face) // Replace with Profile Icon
        // Diet Icon (Selected - Center)
        NavIconCircle(selected = true, icon = Icons.Default.DateRange) // Replace with Fork/Knife Icon
        // Grocery Icon (Not selected)
        NavIconCircle(selected = false, icon = Icons.Default.ShoppingCart) // Replace with Grocery Icon
    }
}

@Composable
fun NavIconCircle(selected: Boolean, icon: ImageVector) {
    Surface(
        shape = CircleShape,
        color = if (selected) Color.White else Color.Transparent,
        shadowElevation = if (selected) 4.dp else 0.dp,
        modifier = Modifier.size(56.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (selected) Color(0xFF3498DB) else Color.Gray, // Blue tint when selected
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeeklyDietPreview() {
    HealifeBetaTheme {
        WeeklyDietScreen()
    }
}
