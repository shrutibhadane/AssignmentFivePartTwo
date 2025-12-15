package com.jetpack.assignmentfiveparttwo

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for ProfileCardsActivity
 * Tests the activity screen with back navigation
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class ProfileCardsActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ProfileCardsActivity>()

    @Test
    fun profileCardsActivity_displaysTitle() {
        composeTestRule
            .onNodeWithText("Custom Profile Cards")
            .assertIsDisplayed()
    }

    @Test
    fun profileCardsActivity_displaysSectionTitle() {
        composeTestRule
            .onNodeWithText("Section 1: Custom Profile Cards")
            .assertIsDisplayed()
    }

    @Test
    fun profileCardsActivity_hasBackButton() {
        composeTestRule
            .onNodeWithContentDescription("Back")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun profileCardsActivity_displaysProfileCards() {
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
}
