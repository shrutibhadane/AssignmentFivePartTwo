package com.jetpack.assignmentfiveparttwo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Section 4: LazyRow + Horizontal Scrolling
 * Demonstrates horizontal scrolling with selectable categories and state management
 */

data class Category(val id: Int, val name: String, val icon: String)

@Composable
fun CategoriesSection() {
    var selectedCategory by remember { mutableStateOf(0) }
    val categories = remember {
        listOf(
            Category(0, "Home", "🏠"),
            Category(1, "Shop", "🛍️"),
            Category(2, "Electronics", "💻"),
            Category(3, "Fashion", "👗"),
            Category(4, "Books", "📚"),
            Category(5, "Sports", "⚽"),
            Category(6, "Food", "🍔"),
            Category(7, "Travel", "✈️")
        )
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        items(categories) { category ->
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .clickable { 
                        // Update selected state on click
                        selectedCategory = category.id 
                    },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = if (selectedCategory == category.id) 8.dp else 2.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedCategory == category.id)
                        MaterialTheme.colorScheme.primaryContainer
                    else
                        MaterialTheme.colorScheme.surface
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = category.icon,
                        fontSize = 32.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = category.name,
                        fontSize = 14.sp,
                        fontWeight = if (selectedCategory == category.id)
                            FontWeight.Bold
                        else
                            FontWeight.Normal,
                        color = if (selectedCategory == category.id)
                            MaterialTheme.colorScheme.onPrimaryContainer
                        else
                            MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
