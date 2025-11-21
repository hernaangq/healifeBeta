package com.example.healifebeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healifebeta.ui.theme.HealifeBetaTheme
import android.content.Intent // <--- Add this
import androidx.compose.ui.platform.LocalContext // <--- Add this


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealifeBetaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainMenuScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainMenuScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current // <--- Get the context here

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .drawBackgroundWaves()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            // Header Text
            Text(
                text = "Welcome back, John!",
                color = Color(0xFF2E8B57),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 32.dp, bottom = 48.dp)
            )

            // Menu Buttons Column
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Profile Button (Left aligned)
                // vvvvv UPDATED BUTTON LOGIC vvvvv
                Button(
                    onClick = {
                        // Navigate to ProfileActivity
                        val intent = Intent(context, ProfileActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .align(Alignment.Start)
                        .width(240.dp)
                        .height(100.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD8F3DC)),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(
                            text = "PROFILE",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }
                }
                // ^^^^^ END UPDATED BUTTON ^^^^^


                // ... Previous Profile Button code ...

                // Weekly Diet Button (Right aligned)
                // vvvvv UPDATED CODE vvvvv
                Button(
                    onClick = {
                        val intent = Intent(context, WeeklyDietActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                        .offset(x = (-20).dp)
                        .width(240.dp)
                        .height(100.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD8F3DC)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 6.dp
                    ),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(
                            text = "WEEKLY DIET",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }
                }
// ^^^^^ END UPDATED CODE ^^^^^

// ... Groceries Button ...



            }
        }
    }
}
@Composable
fun MenuButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /* TODO: Handle click */ },
        modifier = modifier
            .width(240.dp)
            .height(100.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFD8F3DC) // Light green/mint color
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Icon Container
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(24.dp))

            // Text
            Text(
                text = text,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }
    }
}

// Helper extension to draw the abstract green waves in the background
fun Modifier.drawBackgroundWaves() = this.drawBehind {
    val width = size.width
    val height = size.height

    // Light Green Wave
    val path = Path().apply {
        moveTo(0f, height * 0.3f)
        cubicTo(
            width * 0.5f, height * 0.2f,
            width * 0.5f, height * 0.8f,
            width, height * 0.6f
        )
    }

    // Draw multiple strokes to simulate the "wireframe" look
    for (i in 0..20) {
        drawPath(
            path = path,
            color = Color(0xFF4CAF50).copy(alpha = 0.1f),
            style = Stroke(width = 2f),

            )
        // Slightly offset path for next line to create volume effect
        path.translate(Offset(5f, 5f))
    }

    // Add a solid subtle wave line
    drawPath(
        path = Path().apply {
            moveTo(width * 0.2f, 0f)
            quadraticBezierTo(width * 0.8f, height * 0.5f, width * 0.4f, height)
        },
        color = Color(0xFFA5D6A7),
        style = Stroke(width = 4f)
    )
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun MainMenuPreview() {
    HealifeBetaTheme {
        MainMenuScreen()
    }
}
