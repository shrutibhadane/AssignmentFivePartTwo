package com.jetpack.assignmentfiveparttwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Section 5: Grid Layout in Compose
 * Demonstrates LazyVerticalGrid with 2-column layout for products
 */

data class Product(
    val id: Int,
    val title: String,
    val price: String,
    val image: String
)

@Composable
fun ProductsGridSection() {
    val products = remember {
        listOf(
            Product(1, "Laptop", "$999", "💻"),
            Product(2, "Smartphone", "$699", "📱"),
            Product(3, "Headphones", "$199", "🎧"),
            Product(4, "Camera", "$1299", "📷"),
            Product(5, "Watch", "$399", "⌚"),
            Product(6, "Tablet", "$599", "📱"),
            Product(7, "Speaker", "$149", "🔊"),
            Product(8, "Keyboard", "$89", "⌨️"),
            Product(9, "Mouse", "$49", "🖱️"),
            Product(10, "Monitor", "$449", "🖥️"),
            Product(11, "Printer", "$299", "🖨️"),
            Product(12, "Router", "$129", "📡")
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 64.dp)
    ) {
        items(products) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Product Image
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = product.image,
                            fontSize = 48.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Product Title
                    Text(
                        text = product.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    // Product Price
                    Text(
                        text = product.price,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
