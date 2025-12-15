package com.jetpack.assignmentfiveparttwo

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Section 6: Animation Basics
 * Demonstrates size and color animations with smooth transitions
 */

@Composable
fun AnimationBasicsSection() {
    var isExpanded by remember { mutableStateOf(false) }
    var colorToggle by remember { mutableStateOf(false) }

    // Animate size change
    val boxSize by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        label = "size animation"
    )

    // Animate color change
    val boxColor by animateColorAsState(
        targetValue = if (colorToggle) Color(0xFF6200EE) else Color(0xFF03DAC5),
        animationSpec = tween(durationMillis = 500),
        label = "color animation"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Click the box to animate!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        // Animated Box
        Box(
            modifier = Modifier
                .size(boxSize)
                .background(boxColor, RoundedCornerShape(16.dp))
                .clickable {
                    isExpanded = !isExpanded
                    colorToggle = !colorToggle
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isExpanded) "Tap to Shrink" else "Tap to Expand",
                color = colorResource(R.color.white),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

    }
}
