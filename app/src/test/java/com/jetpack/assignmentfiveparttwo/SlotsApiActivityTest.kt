package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for SlotsApiActivity
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class SlotsApiActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<SlotsApiActivity>()

    @Test
    fun slotsApiActivity_displaysTitle() {
        composeTestRule
            .onNodeWithText("Slots API")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApiActivity_displaysSectionTitle() {
        composeTestRule
            .onNodeWithText("Section 2: Slots API Pattern")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApiActivity_hasBackButton() {
        composeTestRule
            .onNodeWithContentDescription("Back")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun slotsApiActivity_displaysSlotCards() {
        composeTestRule
            .onNodeWithText("Welcome Card")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Special Offer")
            .assertIsDisplayed()
    }
}
