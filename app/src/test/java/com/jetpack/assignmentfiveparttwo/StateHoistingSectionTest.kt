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
 * Robolectric test cases for StateHoistingSection
 * Tests state management and stateless components
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class StateHoistingSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun stateHoisting_displaysTitle() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        composeTestRule
            .onNodeWithText("State Hoisting Demo")
            .assertIsDisplayed()
    }

    @Test
    fun stateHoisting_displaysDescription() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        composeTestRule
            .onNodeWithText("All counters are stateless. State is managed here in the parent.")
            .assertIsDisplayed()
    }

    @Test
    fun stateHoisting_displaysTotalCount() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        composeTestRule
            .onNodeWithText("Total Count")
            .assertIsDisplayed()

        // Initial total should be 0
        composeTestRule
            .onAllNodesWithText("0")
            .assertCountEquals(4) // Total + 3 counters
    }

    @Test
    fun stateHoisting_displaysAllCounters() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        composeTestRule
            .onNodeWithText("Counter 1")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Counter 2")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Counter 3")
            .assertIsDisplayed()
    }

    @Test
    fun stateHoisting_incrementButtonWorks() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        // Find Counter 1 and click increment
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[0]
            .performClick()

        // Verify counter increased (there should now be one "1" visible)
        composeTestRule
            .onAllNodesWithText("1")
            .assertCountEquals(2) // Total count + Counter 1
    }

    @Test
    fun stateHoisting_decrementButtonWorks() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        // First increment Counter 1
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[0]
            .performClick()

        // Then decrement Counter 1
        composeTestRule
            .onAllNodesWithContentDescription("Decrement")[0]
            .performClick()

        // Verify counter is back to 0
        composeTestRule
            .onAllNodesWithText("0")
            .assertCountEquals(4) // Total + 3 counters
    }

    @Test
    fun stateHoisting_decrementButtonDisabledAtZero() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        // All decrement buttons should be disabled initially (count is 0)
        composeTestRule
            .onAllNodesWithContentDescription("Decrement")[0]
            .assertIsNotEnabled()

        composeTestRule
            .onAllNodesWithContentDescription("Decrement")[1]
            .assertIsNotEnabled()

        composeTestRule
            .onAllNodesWithContentDescription("Decrement")[2]
            .assertIsNotEnabled()
    }

    @Test
    fun stateHoisting_totalCountUpdates() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        // Increment Counter 1 twice
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[0]
            .performClick()
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[0]
            .performClick()

        // Increment Counter 2 once
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[1]
            .performClick()

        // Increment Counter 3 three times
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[2]
            .performClick()
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[2]
            .performClick()
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[2]
            .performClick()

        // Total should be 2 + 1 + 3 = 6
        // The total count is displayed in a large font, so we can find it
        composeTestRule
            .onAllNodesWithText("6")
            .assertCountEquals(1) // Only the total count
    }

    @Test
    fun stateHoisting_resetButtonExists() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        composeTestRule
            .onNodeWithText("Reset All Counters")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun stateHoisting_resetButtonResetsAllCounters() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        // Increment all counters
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[0]
            .performClick()
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[1]
            .performClick()
        composeTestRule
            .onAllNodesWithContentDescription("Increment")[2]
            .performClick()

        // Click reset button
        composeTestRule
            .onNodeWithText("Reset All Counters")
            .performClick()

        // Verify all counters are back to 0
        composeTestRule
            .onAllNodesWithText("0")
            .assertCountEquals(4) // Total + 3 counters
    }

    @Test
    fun stateHoisting_displaysBenefitsInfo() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        composeTestRule
            .onNodeWithText("State Hoisting Benefits:")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Stateless components are reusable")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Easier to test")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Single source of truth")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Better state management")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("✓ Follows Compose best practices")
            .assertIsDisplayed()
    }

    @Test
    fun statelessCounter_displaysCorrectly() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StatelessCounter(
                    count = 5,
                    onIncrement = {},
                    onDecrement = {},
                    label = "Test Counter",
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        }

        composeTestRule
            .onNodeWithText("Test Counter")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("5")
            .assertIsDisplayed()
    }

    @Test
    fun statelessCounter_hasIncrementAndDecrementButtons() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StatelessCounter(
                    count = 5,
                    onIncrement = {},
                    onDecrement = {},
                    label = "Test Counter",
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Increment")
            .assertIsDisplayed()
            .assertHasClickAction()

        composeTestRule
            .onNodeWithContentDescription("Decrement")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun stateHoisting_multipleIncrementsWork() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StateHoistingSection()
            }
        }

        // Increment Counter 1 five times
        repeat(5) {
            composeTestRule
                .onAllNodesWithContentDescription("Increment")[0]
                .performClick()
        }

        // Verify Counter 1 shows 5
        composeTestRule
            .onAllNodesWithText("5")
            .assertCountEquals(2) // Total count + Counter 1
    }
}
