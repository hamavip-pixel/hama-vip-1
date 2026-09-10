package com.royalhama.engine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoyalHamaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF0F0F13)
                ) {
                    MainDashboard()
                }
            }
        }
    }
}

@Composable
fun RoyalHamaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFFFFD700),
            background = Color(0xFF0F0F13)
        ),
        content = content
    )
}

@Composable
fun MainDashboard() {
    var espEnabled by remember { mutableStateOf(true) }
    var autoPlay by remember { mutableStateOf(false) }
    var extendedLine by remember { mutableStateOf(true) }

    val infiniteTransition = rememberInfiniteTransition(label = "goldGlow")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "⚡ ROYAL HAMA ENGINE ⚡",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700),
            modifier = Modifier.shadow(8.dp * glowAlpha)
        )
        Text(
            text = "Gear 5 - 8 Ball Pool VIP",
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        ControlToggle("ESP 3D Prediction", espEnabled) { espEnabled = it }
        Spacer(modifier = Modifier.height(16.dp))
        ControlToggle("Auto-Play / Aimbot", autoPlay) { autoPlay = it }
        Spacer(modifier = Modifier.height(16.dp))
        ControlToggle("Extended Guideline", extendedLine) { extendedLine = it }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF2A2A35), Color(0xFF1A1A24))
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(1.dp, Color(0xFFFFD700).copy(alpha = glowAlpha), RoundedCornerShape(12.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "STATUS: ACTIVE (1D VIP LICENSE)",
                color = Color(0xFF00FF66),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun ControlToggle(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E28), RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFFFD700).copy(alpha = 0.3f), RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF0F0F13),
                checkedTrackColor = Color(0xFFFFD700)
            )
        )
    }
}
