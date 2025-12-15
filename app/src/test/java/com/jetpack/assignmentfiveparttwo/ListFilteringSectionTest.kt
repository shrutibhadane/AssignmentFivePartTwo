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
 * Robolectric test cases for ListFilteringSection
 * Tests search and filtering functionality
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class ListFilteringSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun listFiltering_displaysTitle() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        composeTestRule
            .onNodeWithText("City Search")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_displaysSearchField() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        composeTestRule
            .onNodeWithText("Search cities...")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_displaysInitialResultCount() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Should show all 30 cities initially
        composeTestRule
            .onNodeWithText("Results: 30")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_displaysAllCitiesInitially() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Verify some cities are displayed
        composeTestRule
            .onNodeWithText("New York")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Los Angeles")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Chicago")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_searchFiltersResults() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("San")

        // Verify filtered results
        composeTestRule
            .onNodeWithText("San Diego")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("San Francisco")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("San Antonio")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("San Jose")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_searchIsCaseInsensitive() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter lowercase search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("new york")

        // Verify result is found
        composeTestRule
            .onNodeWithText("New York")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_updatesResultCount() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("San")

        // Verify result count is updated (should be 4 cities with "San")
        composeTestRule
            .onNodeWithText("Results: 4")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_showsSearchingForText() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("Chicago")

        // Verify "Searching for" text is displayed
        composeTestRule
            .onNodeWithText("Searching for: \"Chicago\"")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_clearButtonAppearsWhenTyping() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("Test")

        // Verify clear button is present (by checking for Clear content description)
        composeTestRule
            .onNodeWithContentDescription("Clear")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_clearButtonClearsSearch() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("Test")

        // Click clear button
        composeTestRule
            .onNodeWithContentDescription("Clear")
            .performClick()

        // Verify results are back to 30
        composeTestRule
            .onNodeWithText("Results: 30")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_showsNoResultsMessage() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter search query that won't match anything
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("XYZ123")

        // Verify no results message
        composeTestRule
            .onNodeWithText("No cities found")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Try a different search term")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_displaysSearchFeatures() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        composeTestRule
            .onNodeWithText("Search Features:")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Real-time filtering")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Case-insensitive search")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Using derivedStateOf for efficiency")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ 30 total cities")
            .assertIsDisplayed()
    }

    @Test
    fun listFiltering_partialMatchWorks() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                ListFilteringSection()
            }
        }

        // Enter partial search query
        composeTestRule
            .onNodeWithText("Search cities...")
            .performTextInput("port")

        // Verify Portland is found
        composeTestRule
            .onNodeWithText("Portland")
            .assertIsDisplayed()
    }

    @Test
    fun cityItem_displaysCorrectly() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                CityItem(city = "Test City", searchQuery = "")
            }
        }

        composeTestRule
            .onNodeWithText("Test City")
            .assertIsDisplayed()
    }
}
