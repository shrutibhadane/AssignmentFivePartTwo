package com.jetpack.assignmentfiveparttwo

import android.R.attr.text
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Slideshow
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.assignmentfiveparttwo.ui.theme.AssignmentFivePartTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Observe globally
            val isDarkTheme = ThemeManager.isDarkTheme.value
            val systemDark = androidx.compose.foundation.isSystemInDarkTheme()
            val finalDarkTheme = isDarkTheme ?: systemDark

            AssignmentFivePartTwoTheme(darkTheme = finalDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

data class Section(
    val number: Int,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val activityClass: Class<*>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current

    val sections = listOf(
        Section(
            1,
            stringResource(R.string.custom_profile_cards),
            stringResource(R.string.reusable_composable_components),
            Icons.Default.Person, ProfileCardsActivity::class.java
        ),
        Section(
            2,
            stringResource(R.string.slots_api),
            stringResource(R.string.header_footer_slots_pattern),
            Icons.Default.ViewAgenda,
            SlotsApiActivity::class.java
        ),
        Section(
            3,
            stringResource(R.string.lazycolumn),
            stringResource(R.string._30_students_list_with_scroll),
            Icons.Default.List,
            StudentsListActivity::class.java
        ),
        Section(
            4,
            stringResource(R.string.lazyrow),
            stringResource(R.string.horizontal_categories_scroll),
            Icons.Default.ViewCarousel,
            CategoriesActivity::class.java
        ),
        Section(
            5,
            stringResource(R.string.grid_layout),
            stringResource(R.string.products_in_grid_format),
            Icons.Default.GridView,
            ProductsGridActivity::class.java
        ),
        Section(
            6,
            stringResource(R.string.animation_basics),
            stringResource(R.string.compose_animations_demo),
            Icons.Default.Animation,
            AnimationBasicsActivity::class.java
        ),
        Section(
            7,
            stringResource(R.string.custom_textfield),
            stringResource(R.string.styled_input_components),
            Icons.Default.Edit,
            CustomTextFieldActivity::class.java
        ),
        Section(
            8,
            stringResource(R.string.form_validation),
            stringResource(R.string.input_validation_patterns),
            Icons.Default.CheckCircle,
            FormValidationActivity::class.java
        ),
        Section(
            9,
            stringResource(R.string.navigation),
            stringResource(R.string.navigation_with_arguments),
            Icons.Default.Navigation,
            NavigationDemoActivity::class.java
        ),
        Section(
            10,
            stringResource(R.string.dialogs_sheets),
            stringResource(R.string.modal_dialogs_bottom_sheets),
            Icons.Default.Message,
            DialogsBottomSheetsActivity::class.java
        ),
        Section(
            11,
            stringResource(R.string.tabs_pager),
            stringResource(R.string.tabbed_interface_with_pager),
            Icons.Default.Tab,
            TabsPagerActivity::class.java
        ),
        Section(
            12,
            stringResource(R.string.list_filtering),
            stringResource(R.string.search_filter_functionality),
            Icons.Default.Search,
            ListFilteringActivity::class.java
        ),
        Section(
            13,
            stringResource(R.string.state_hoisting),
            stringResource(R.string.stateless_ui_pattern),
            Icons.Default.Upload,
            StateHoistingActivity::class.java
        ),
        Section(
            14,
            stringResource(R.string.dark_mode),
            stringResource(R.string.theme_switching_support),
            Icons.Default.DarkMode,
            DarkModeActivity::class.java
        ),
        Section(
            15,
            stringResource(R.string.onboarding),
            stringResource(R.string.welcome_screens_flow),
            Icons.Default.Slideshow,
            OnboardingActivity::class.java
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = stringResource(R.string.jetpack_compose_demo),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = stringResource(R.string._15_comprehensive_examples),
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Category: Basic Compose Concepts (1-5)
            item {
                CategoryHeader(stringResource(R.string.basic_compose_concepts))
            }

            items(sections.filter { it.number in 1..5 }) { section ->
                SectionCard(section) {
                    context.startActivity(Intent(context, section.activityClass))
                }
            }

            // Category: Intermediate Concepts (6-10)
            item {
                Spacer(modifier = Modifier.height(8.dp))
                CategoryHeader(stringResource(R.string.intermediate_concepts))
            }

            items(sections.filter { it.number in 6..10 }) { section ->
                SectionCard(section) {
                    context.startActivity(Intent(context, section.activityClass))
                }
            }

            // Category: Advanced Concepts (11-15)
            item {
                Spacer(modifier = Modifier.height(8.dp))
                CategoryHeader(stringResource(R.string.advanced_concepts))
            }

            items(sections.filter { it.number in 11..15 }) { section ->
                SectionCard(section) {
                    context.startActivity(Intent(context, section.activityClass))
                }
            }
        }
    }
}

@Composable
fun CategoryHeader(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun SectionCard(section: Section, onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Surface(
                modifier = Modifier.size(48.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = section.icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Content
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${section.number}. ${section.title}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = section.description,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // Arrow
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Navigate",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}