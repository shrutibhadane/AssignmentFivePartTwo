package com.jetpack.assignmentfiveparttwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Section 2: Slots API (Composable Lambdas)
 * Demonstrates using @Composable () -> Unit lambdas for header and footer slots
 */

@Composable
fun SlotCard(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    footer: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header Slot
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp)
            ) {
                header()
            }

            // Content
            Box(modifier = Modifier.padding(16.dp)) {
                content()
            }

            // Footer Slot
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(16.dp)
            ) {
                footer()
            }
        }
    }
}

@Composable
fun SlotsApiSection() {
    Column {
        // First Card with different header/footer
        SlotCard(
            header = {
                Text(
                    text = "Welcome Card",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            footer = {
                Text(
                    text = "Footer: Learn More →",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            },
            content = {
                Text(
                    text = "This demonstrates the Slots API pattern. The header and footer are passed as composable lambdas!",
                    fontSize = 14.sp
                )
            }
        )

        // Second Card with different content
        SlotCard(
            header = {
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Text(
                        text = "🎉",
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Special Offer",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            },
            footer = {
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Claim Offer")
                }
            },
            content = {
                Text(
                    text = "Get 50% off on your next purchase! This slot contains completely different content.",
                    fontSize = 14.sp
                )
            }
        )
    }
}
