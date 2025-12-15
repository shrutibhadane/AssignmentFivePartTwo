package com.jetpack.assignmentfiveparttwo

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Section 14: Dark Mode Support
 * Demonstrates dynamic theme switching with MaterialTheme
 */

@Composable
fun DarkModeSection() {
    // Track global theme state
    val isAppInDarkTheme = ThemeManager.isDarkTheme.value
    val systemInDarkTheme = isSystemInDarkTheme()

    // If explicit setting exists, use it. Otherwise use system default.
    // For the UI switch, we can map:
    // Checked (Dark) if isAppInDarkTheme == true
    // Unchecked (Light) if isAppInDarkTheme == false
    // What about "System Default" (null)? 
    // For simplicity of this binary switch toggle requested by user flow:
    // If null, we default to system behavior. If user toggles, we set explicit true/false.
    
    val currentIsDark = isAppInDarkTheme ?: systemInDarkTheme

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Theme Toggle Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = if (currentIsDark)
                    MaterialTheme.colorScheme.surfaceVariant
                else
                    MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (currentIsDark) Icons.Default.DarkMode else Icons.Default.LightMode,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = if (currentIsDark) "Dark Mode" else "Light Mode",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (isAppInDarkTheme == null) "System Default" else "User Override",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Switch(
                    checked = currentIsDark,
                    onCheckedChange = { isChecked ->
                        // Directly update the singleton
                        ThemeManager.isDarkTheme.value = isChecked
                    }
                )
            }
        }

        if (isAppInDarkTheme != null) {
            TextButton(
                onClick = { ThemeManager.isDarkTheme.value = null },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Reset to System Default")
            }
        }

    }
}

