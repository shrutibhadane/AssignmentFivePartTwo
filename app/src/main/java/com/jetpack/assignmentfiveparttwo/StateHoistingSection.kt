package com.jetpack.assignmentfiveparttwo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Section 13: State Hoisting + Stateless UI
 * Demonstrates Compose best practices with stateless components
 */

@Composable
fun StateHoistingSection() {
    // State is managed in the parent composable
    var counter1 by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var counter3 by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "All counters are stateless. State is managed here in the parent.",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Total count display
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Total Count",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${counter1 + counter2 + counter3}",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Stateless Counter 1
        StatelessCounter(
            count = counter1,
            onIncrement = { counter1++ },
            onDecrement = { counter1-- },
            label = "Counter 1",
            color = MaterialTheme.colorScheme.primaryContainer
        )

        // Stateless Counter 2
        StatelessCounter(
            count = counter2,
            onIncrement = { counter2++ },
            onDecrement = { counter2-- },
            label = "Counter 2",
            color = MaterialTheme.colorScheme.secondaryContainer
        )

        // Stateless Counter 3
        StatelessCounter(
            count = counter3,
            onIncrement = { counter3++ },
            onDecrement = { counter3-- },
            label = "Counter 3",
            color = MaterialTheme.colorScheme.tertiaryContainer
        )

        // Reset All Button
        Button(
            onClick = {
                counter1 = 0
                counter2 = 0
                counter3 = 0
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Reset All Counters", modifier = Modifier.padding(8.dp))
        }
    }
}

/**
 * Stateless Counter Component
 * This component doesn't manage its own state.
 * State is hoisted to the parent composable.
 */
@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    label: String,
    color: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Decrement Button
                IconButton(
                    onClick = onDecrement,
                    enabled = count > 0
                ) {
                    Icon(
                        Icons.Default.Remove,
                        contentDescription = "Decrement",
                        modifier = Modifier.size(32.dp)
                    )
                }

                // Count Display
                Text(
                    text = count.toString(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                // Increment Button
                IconButton(onClick = onIncrement) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Increment",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}
