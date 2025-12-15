package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.jetpack.assignmentfiveparttwo.ui.theme.AssignmentFivePartTwoTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for ProfileCardsSection
 * Tests reusable composable components
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class ProfileCardsSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun profileCardsSection_displaysAllProfiles() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCardsSection()
            }
        }

        // Verify all three profiles are displayed
        composeTestRule
            .onNodeWithText("John Doe")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Jane Smith")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Mike Johnson")
            .assertIsDisplayed()
    }

    @Test
    fun profileCardsSection_displaysEmails() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCardsSection()
            }
        }

        composeTestRule
            .onNodeWithText("john.doe@example.com")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("jane.smith@example.com")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("mike.johnson@example.com")
            .assertIsDisplayed()
    }

    @Test
    fun profileCardsSection_displaysRoles() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCardsSection()
            }
        }

        composeTestRule
            .onNodeWithText("Software Engineer")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Product Manager")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("UX Designer")
            .assertIsDisplayed()
    }

    @Test
    fun profileCard_displaysName() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCard(
                    name = "Test User",
                    email = "test@example.com",
                    image = "test",
                    role = "Tester"
                )
            }
        }

        composeTestRule
            .onNodeWithText("Test User")
            .assertIsDisplayed()
    }

    @Test
    fun profileCard_displaysEmail() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCard(
                    name = "Test User",
                    email = "test@example.com",
                    image = "test",
                    role = "Tester"
                )
            }
        }

        composeTestRule
            .onNodeWithText("test@example.com")
            .assertIsDisplayed()
    }

    @Test
    fun profileCard_displaysRole() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCard(
                    name = "Test User",
                    email = "test@example.com",
                    image = "test",
                    role = "Tester"
                )
            }
        }

        composeTestRule
            .onNodeWithText("Tester")
            .assertIsDisplayed()
    }

    @Test
    fun profileCard_displaysInitial() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCard(
                    name = "Alice",
                    email = "alice@example.com",
                    image = "alice",
                    role = "Developer"
                )
            }
        }

        // Should display first letter as initial
        composeTestRule
            .onNodeWithText("A")
            .assertIsDisplayed()
    }

    @Test
    fun profileCard_isReusable() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                androidx.compose.foundation.layout.Column {
                    ProfileCard(
                        name = "User One",
                        email = "one@example.com",
                        image = "one",
                        role = "Role One"
                    )
                    ProfileCard(
                        name = "User Two",
                        email = "two@example.com",
                        image = "two",
                        role = "Role Two"
                    )
                }
            }
        }

        // Both cards should be displayed
        composeTestRule
            .onNodeWithText("User One")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("User Two")
            .assertIsDisplayed()
    }

    @Test
    fun profileCard_acceptsCustomModifier() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCard(
                    name = "Test User",
                    email = "test@example.com",
                    image = "test",
                    role = "Tester",
                    modifier = androidx.compose.ui.Modifier
                )
            }
        }

        composeTestRule
            .onNodeWithText("Test User")
            .assertIsDisplayed()
    }

    @Test
    fun profileCardsSection_hasThreeCards() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCardsSection()
            }
        }

        // Count the number of profile cards by checking for unique names
        val names = listOf("John Doe", "Jane Smith", "Mike Johnson")
        names.forEach { name ->
            composeTestRule
                .onNodeWithText(name)
                .assertExists()
        }
    }

    @Test
    fun profileCard_displaysAllComponents() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ProfileCard(
                    name = "Complete User",
                    email = "complete@example.com",
                    image = "complete",
                    role = "Complete Role"
                )
            }
        }

        // Verify all components are present
        composeTestRule
            .onNodeWithText("C") // Initial
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Complete User")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("complete@example.com")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Complete Role")
            .assertIsDisplayed()
    }
}
