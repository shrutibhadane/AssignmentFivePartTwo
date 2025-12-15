package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for StateHoistingActivity
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class StateHoistingActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<StateHoistingActivity>()

    @Test
    fun stateHoistingActivity_displaysTitle() {
        composeTestRule
            .onNodeWithText("State Hoisting")
            .assertIsDisplayed()
    }

    @Test
    fun stateHoistingActivity_displaysSectionTitle() {
        composeTestRule
            .onNodeWithText("Section 13: State Hoisting Pattern")
            .assertIsDisplayed()
    }

    @Test
    fun stateHoistingActivity_hasBackButton() {
        composeTestRule
            .onNodeWithContentDescription("Back")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun stateHoistingActivity_displaysStateHoistingDemo() {
        composeTestRule
            .onNodeWithText("State Hoisting Demo")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Total Count")
            .assertIsDisplayed()
    }
}
