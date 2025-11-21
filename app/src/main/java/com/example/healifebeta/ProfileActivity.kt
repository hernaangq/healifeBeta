package com.example.healifebeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healifebeta.ui.theme.HealifeBetaTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealifeBetaTheme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            // Top Header "PROFILE"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD8F3DC)) // Light Mint
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .padding(top = 24.dp), // Status bar spacing
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "PROFILE",
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
            // Bottom Navigation Bar
            BottomNavigationBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            // Profile Info Section (Text + Avatar)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Hi Luis!",
                        color = Color(0xFF2E8B57),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Your profile is 75% completed.",
                        color = Color(0xFF2E8B57),
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Finish it to achieve your goals!!",
                        color = Color(0xFF2E8B57),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Placeholder for Avatar Image
                // Note: In a real app, use R.drawable.your_avatar
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE0F2F1)), // Light background circle
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Avatar",
                        modifier = Modifier.size(64.dp),
                        tint = Color(0xFF4E342E)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Sections
            InfoSection("Nutritional goal", listOf("Maintain weight", "Lose fat", "Gain muscle", "Eat balanced meals"))
            InfoSection("Basic information", listOf("Name", "Height", "Date of birth", "Weight", "Gender", "Daily activity level"))
            InfoSection("Medical records", listOf("Allergies", "Intolerances", "Medical conditions", "Medications"))
            InfoSection("Preferences", listOf("Foods disliked", "Culinary culture"))

            // Extra spacer for scrolling past bottom bar
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InfoSection(title: String, items: List<String>) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // FlowRow automatically wraps items to the next line
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach { item ->
                InfoChip(text = item)
            }
        }
    }
}

@Composable
fun InfoChip(text: String) {
    Surface(
        color = Color(0xFFE0F2F1), // Very light teal/green
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.height(32.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 12.dp)) {
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8F3DC))
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Just using simple circular backgrounds for the icons as seen in design
        NavIcon(selected = true) // Profile Icon
        NavIcon(selected = false) // Diet Icon
        NavIcon(selected = false) // Grocery Icon
    }
}

@Composable
fun NavIcon(selected: Boolean) {
    Surface(
        shape = CircleShape,
        color = if (selected) Color.White else Color.Transparent,
        shadowElevation = if (selected) 4.dp else 0.dp,
        modifier = Modifier.size(56.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            // Placeholder icons - replace with real resources
            Icon(
                imageVector = Icons.Default.Person, // Placeholder
                contentDescription = null,
                tint = if (selected) Color(0xFF2E8B57) else Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    HealifeBetaTheme {
        ProfileScreen()
    }
}

