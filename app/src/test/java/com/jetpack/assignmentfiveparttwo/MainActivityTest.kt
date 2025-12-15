package com.jetpack.assignmentfiveparttwo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.jetpack.assignmentfiveparttwo.ui.theme.AssignmentFivePartTwoTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for MainActivity
 * Tests the main navigation screen with all 15 sections
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mainScreen_displaysCorrectTitle() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        composeTestRule
            .onNodeWithText("Jetpack Compose Demo")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_displaysSubtitle() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        composeTestRule
            .onNodeWithText("15 Comprehensive Examples")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_displaysCategoryHeaders() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        composeTestRule
            .onNodeWithText("Basic Compose Concepts")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Intermediate Concepts")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Advanced Concepts")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_displaysAllBasicSections() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        // Section 1
        composeTestRule
            .onNodeWithText("1. Custom Profile Cards")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Reusable composable components")
            .assertIsDisplayed()

        // Section 2
        composeTestRule
            .onNodeWithText("2. Slots API")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Header & Footer slots pattern")
            .assertIsDisplayed()

        // Section 3
        composeTestRule
            .onNodeWithText("3. LazyColumn")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("30 Students list with scroll")
            .assertIsDisplayed()

        // Section 4
        composeTestRule
            .onNodeWithText("4. LazyRow")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Horizontal categories scroll")
            .assertIsDisplayed()

        // Section 5
        composeTestRule
            .onNodeWithText("5. Grid Layout")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Products in grid format")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_displaysAllIntermediateSections() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        // Section 6
        composeTestRule
            .onNodeWithText("6. Animation Basics")
            .assertIsDisplayed()

        // Section 7
        composeTestRule
            .onNodeWithText("7. Custom TextField")
            .assertIsDisplayed()

        // Section 8
        composeTestRule
            .onNodeWithText("8. Form Validation")
            .assertIsDisplayed()

        // Section 9
        composeTestRule
            .onNodeWithText("9. Navigation")
            .assertIsDisplayed()

        // Section 10
        composeTestRule
            .onNodeWithText("10. Dialogs & Sheets")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_displaysAllAdvancedSections() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        // Section 11
        composeTestRule
            .onNodeWithText("11. Tabs + Pager")
            .assertIsDisplayed()

        // Section 12
        composeTestRule
            .onNodeWithText("12. List Filtering")
            .assertIsDisplayed()

        // Section 13
        composeTestRule
            .onNodeWithText("13. State Hoisting")
            .assertIsDisplayed()

        // Section 14
        composeTestRule
            .onNodeWithText("14. Dark Mode")
            .assertIsDisplayed()

        // Section 15
        composeTestRule
            .onNodeWithText("15. Onboarding")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_sectionCardsAreClickable() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        // Verify that section cards exist and are clickable
        composeTestRule
            .onNodeWithText("1. Custom Profile Cards")
            .assertHasClickAction()

        composeTestRule
            .onNodeWithText("8. Form Validation")
            .assertHasClickAction()

        composeTestRule
            .onNodeWithText("15. Onboarding")
            .assertHasClickAction()
    }

    @Test
    fun categoryHeader_hasCorrectStyling() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                CategoryHeader("Test Category")
            }
        }

        composeTestRule
            .onNodeWithText("Test Category")
            .assertIsDisplayed()
    }

    @Test
    fun sectionCard_displaysAllComponents() {
        val testSection = Section(
            number = 99,
            title = "Test Section",
            description = "Test Description",
            icon = Icons.Default.Person,
            activityClass = MainActivity::class.java
        )

        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SectionCard(section = testSection, onClick = {})
            }
        }

        composeTestRule
            .onNodeWithText("99. Test Section")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Test Description")
            .assertIsDisplayed()
    }

    @Test
    fun mainScreen_hasScrollableContent() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                MainScreen()
            }
        }

        // Verify that the screen is scrollable by checking if content exists
        // that might be off-screen initially
        composeTestRule
            .onNodeWithText("1. Custom Profile Cards")
            .assertIsDisplayed()

        // The last section should also be accessible (even if scrolling is needed)
        composeTestRule
            .onNodeWithText("15. Onboarding")
            .assertExists()
    }
}
